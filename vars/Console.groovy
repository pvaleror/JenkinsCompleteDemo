def log(msg) {
  spit(msg, '34m')
}

def error(msg) {
  spit(msg, '31m')
  error(msg.replace("ERROR: ",""))
}

def warning(msg){
  spit(msg, '33m')
}

def success(msg){
  spit(msg, '32m')
}

def spit(msg, color){
  echo '\033[1;' + color + msg + '\033[0m'
}

def call(Map conf) {
  switch(conf.type){
    case 'debug':
    case 'success':
      success(conf.msg)
      break;
    default:
      success(conf.msg)
      break;
  }
}