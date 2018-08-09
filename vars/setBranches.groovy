def call(Map config){
  if(env.TARGET == "Development"){
    def sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + ${params.ID_RECORD}
    def targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.branch.develop').trim()
  } else if(env.TARGET == "Test"){
    def sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + ${params.ID_RECORD};
    def targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + ${params.ID_RECORD};
  } else if(env.TARGET == "Production"){
    def sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + ${params.ID_RECORD};
    def targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.branch.master').trim()
  }
  echo sourceBranch
  echo targetBranch
  env[sourceBranch] = sourceBranch
  env[targetBranch] = targetBranch
}