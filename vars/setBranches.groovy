def call(Map config){
  def sourceBranch
  def targetBranch
  if(env.TARGET == "Development"){
    sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + params.ID_RECORD
    targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.branch.develop').trim()
  } else if(env.TARGET == "Test"){
    sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + params.ID_RECORD
    targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + params.ID_RECORD
  } else if(env.TARGET == "Production"){
    sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + params.ID_RECORD
    targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.branch.master').trim()
  }
  env['sourceBranch'] = sourceBranch
  env['targetBranch'] = targetBranch
}