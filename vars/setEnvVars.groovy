def call(configFiles) {
  def size = configFiles.size()
  echo "Size: " + size
  for(int i=0; i<=configFiles.size(); i++){
    echo "CNF: "+configFiles[i]
  }
}


//configFileProvider([
//          configFile(fileId: 'GlobalVars', variable: 'GlobalVars'),
//          configFile(fileId: 'Global2', variable: 'Global2'),
//          configFile(fileId: 'BPM', variable: 'BPM')
//        ]){
//          script{
//            def globaProps = "$JENKINS_HOME/envVars/global.properties"
//            def shProps = sh(returnStdout: true, script: "cat $GlobalVars;echo;cat $Global2;echo;cat $BPM;").trim()
//            def props = readProperties file: globaProps, text: shProps, replaceTokens: true;
//            for (item in props){
//              env[item.key] = item.value;
//            }
//          }
//        }