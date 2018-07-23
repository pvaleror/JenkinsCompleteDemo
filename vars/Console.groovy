def log(msg) {
  spit(msg, '\033[1;34m')
}

def error(msg) {
  spit(msg, '\033[1;31m')
}

def warning(msg){
  spit(msg, '\033[1;33m')
}

def success(msg){
  spit(msg, '\033[1;32m')
}

def spit(msg, color){
  echo color + msg + '\033[7m'
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