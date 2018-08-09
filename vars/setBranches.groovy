def call(Map config){
  def source
  def target
  if(env.TARGET == "Development"){
    source = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + params.ID_RECORD
    target = sh(returnStdout: true, script: 'git config --get gitflow.branch.develop').trim()
  } else if(env.TARGET == "Test"){
    source = sh(returnStdout: true, script: 'git config --get gitflow.prefix.feature').trim() + params.ID_RECORD
    target = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + params.ID_RECORD
  } else if(env.TARGET == "Production"){
    source = sh(returnStdout: true, script: 'git config --get gitflow.prefix.release').trim() + params.ID_RECORD
    target = sh(returnStdout: true, script: 'git config --get gitflow.branch.master').trim()
  }
  env['GIT_SOURCE'] = source
  env['GIT_TARGET'] = target
}