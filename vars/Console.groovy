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
  lines = msg.split('\n')
  lines.each(m -> echo '\033[1;' + color + ' ' + m + ' \033[0m')
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