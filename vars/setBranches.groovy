def call(Map config){
  if(env.TARGET == "Development"){
    def sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + ${params.ID_RECORD}
    def targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.branch.develop').trim()
  }elsif($enviroment eq "_CLIENTES"){
    def sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + ${params.ID_RECORD};
    def targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + ${params.ID_RECORD};
  }elsif($enviroment eq "_PRODUCCION"){
    def sourceBranch = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + ${params.ID_RECORD};
    def targetBranch = sh(returnStdout: true, script: 'git config --get gitflow.branch.master').trim()
  }
  env[sourceBranch] = sourceBranch
  env[targetBranch] = targetBranch
}