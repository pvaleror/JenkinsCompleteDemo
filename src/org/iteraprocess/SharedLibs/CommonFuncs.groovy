package org.iteraprocess.SharedLibs;

class CommonFuncs implements Serializable{
  def steps
  CommonFuncs(steps) {
    this.steps = steps
  }
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

  private def spit(msg, color){
    ansiColor('xterm') {
      steps.echo color + msg + '\033[0m'
    }
  }
}