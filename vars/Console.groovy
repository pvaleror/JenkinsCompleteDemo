def log(msg) {
  spit(msg, '37;44m')
}

def error(msg) {
  spit(msg, '37;41m')
  currentBuild.result = 'ABORTED'
  //error(msg.replace("ERROR: ",""))
}

def warning(msg){
  currentBuild.result = 'UNSTABLE'
  spit(msg, '37;43m')
}

def success(msg){
  spit(msg, '37;42m')
}

def spit(msg, color){
  echo '\033[1;' + color + '  ' + msg + '  \033[0m'
}

def call(Map conf) {
  switch(conf.type){
    case 'log':
      log(conf.msg)
      break;
    case 'error':
      error(conf.msg)
      break;
    case 'warning':
      warning(conf.msg)
      break;
    case 'success':
      success(conf.msg)
      break;
    default:
      success(conf.msg)
      break;
  }
}