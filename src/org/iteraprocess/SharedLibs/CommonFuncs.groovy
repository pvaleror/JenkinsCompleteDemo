package org.iteraprocess.SharedLibs;

class CommonFuncs implements Serializable{
  def steps
  Utilities(steps) {this.steps = steps}
  def Error(string) {
    echo "\u001B[31m ----- " + string + " ++++++ \u001B[0m"
  }
}