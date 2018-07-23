def call(configFiles) {
  for(int i=0; i < configFiles.size(); i++){
    def cnfName = configFiles[i]
    configFileProvider([configFile(fileId: cnfName, variable: 'tmp')]){
      script{
        def shProps = sh(returnStdout: true, script: 'cat '+tmp).trim()
        def props = readProperties text: shProps, replaceTokens: true;
        echo "\n\nvariables del archivo "+cnfName+":"
        for (item in props){
          env[item.key] = item.value;
          Console(type: 'debug', msg: item.key + '=>' + item.value)
        }
      }
    }
  }
}