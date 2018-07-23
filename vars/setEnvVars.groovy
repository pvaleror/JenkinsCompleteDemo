def call(configFiles) {
  def size = configFiles.size()
  for(int i=0; i < configFiles.size(); i++){
    def cnfName = configFiles[i]
    configFileProvider([configFile(fileId: cnfName, variable: cnfName)]){
      script{
        def shProps = sh(returnStdout: true, script: "cat $cnfName").trim()
        def props = readProperties text: shProps, replaceTokens: true;
        for (item in props){
          env[item.key] = item.value;
        }
      }
    }
  }
}