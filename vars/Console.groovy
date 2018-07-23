def log(msg) {
  spit(msg, '\033[34m')
}

def error(msg) {
  spit(msg, '\033[31m')
}

def warning(msg){
  spit(msg, '\033[33m')
}

def success(msg){
  spit(msg, '\033[32m')
}

def spit(msg, color){
  ansiColor('xterm') {
    echo color + msg + '\033[0m'
  }
}

def call(Map conf) {
  switch(conf.type){
    case 'debug':
    case 'success':
      //success(conf.msg)
      echo '\033[32m' + conf.msg + '\033[0m'
      break;
    default:
      success(conf.msg)
      break;
  }
}