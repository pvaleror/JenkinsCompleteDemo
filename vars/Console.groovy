def debug(msg){
  echo '\033[34m' + msg + '\033[0m'
}

def call(Map conf) {
  switch(conf.type){
    case 'debug':
      debug(conf.msg)
      break;
    default:
      echo '\033[34m' + conf.msg + '\033[0m'
      break;
  }
}