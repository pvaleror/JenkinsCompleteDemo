def call(Map conf) {
  switch(conf.type){
    case 'debug':
      echo '\033[34m' + conf.msg + '\033[0m'
      break;
    default:
      echo '\033[34m' + conf.msg + '\033[0m'
      break;
  }
}