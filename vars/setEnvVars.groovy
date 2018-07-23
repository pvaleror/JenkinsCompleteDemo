def call(configFiles) {
  for(int i=0; i < configFiles.size(); i++){
    def cnfName = configFiles[i]
    configFileProvider([configFile(fileId: cnfName, variable: cnfName+'File')]){
      def tmp = cnfName+'File'
      itError(tmp)
      script{
        def shProps = sh(returnStdout: true, script: 'cat '+cnfName+'File').trim()
        def props = readProperties text: shProps, replaceTokens: true;
        for (item in props){
          env[item.key] = item.value;
        }
      }
    }
  }
}