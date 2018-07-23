def call(String msg) {
  ansiColor('xterm') {
    echo '\033[31m' + msg + '\033[0m'
  }
}