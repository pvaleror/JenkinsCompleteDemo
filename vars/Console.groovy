def itLog(msg) {
  spit(msg, '37;44m')
}

def itError(msg) {
  spit(msg, '37;41m')
  error(msg.replace("ERROR: ",""))
}

def itWarning(msg){
  currentBuild.result = 'UNSTABLE'
  spit(msg, '37;43m')
}

def itSuccess(msg){
  spit(msg, '37;42m')
}

def spit(msg, color){
  for(line in msg.split('\n')){
    echo '\033[1;' + color + ' ' + line + ' \033[0m'
  }
}

def call(Map conf) {
  switch(conf.type){
    case 'log':
      itLog(conf.msg)
      def PROPS = readYaml file:'Config/some'
      env["TECH"] = PROPS.T_T4C_WS.TECH
      if(conf.msg == "rtn"){
        return PROPS.T_T4C_WS.PROD
      }
      

      break;
    case 'error':
      itError(conf.msg)
      break;
    case 'warning':
      itWarning(conf.msg)
      break;
    case 'success':
      itSuccess(conf.msg)
      break;
    default:
      success(conf.msg)
      break;
  }
}