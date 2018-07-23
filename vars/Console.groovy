def itLog(msg) {
  spit(msg, '37;44m')
}

def itError(msg) {
  spit(msg, '37;41m')
  currentBuild.result = 'FAILURE'
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
  echo '\033[1;' + color + ' ' + msg + ' \033[0m'
}

def call(Map conf) {
  switch(conf.type){
    case 'log':
      itLog(conf.msg)
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