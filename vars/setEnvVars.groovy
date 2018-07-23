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
  if(config.script){
    def shProps = sh(returnStdout: true, script: config.script).trim()
    if(shProps =~ /^ERROR/) {
      Console(type: 'error', msg: shProps)
    }
    def props = readProperties text: shProps, replaceTokens: true;
    for (item in props){
      env[item.key] = item.value
      Console(type: 'log', msg: item.key + '=>' + item.value)
    }
  }
}