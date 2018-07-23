def call(Map config) {
  if(config.configFiles){    
    for(int i=0; i < config.configFiles.size(); i++){
      def cnfName = config.configFiles[i]
      configFileProvider([configFile(fileId: cnfName, variable: 'tmp')]){
        def shProps = sh(returnStdout: true, script: 'cat '+tmp).trim()
        def props = readProperties text: shProps, replaceTokens: true;
        for (item in props){
          env[item.key] = item.value;
        }
      }
    }
  }
}