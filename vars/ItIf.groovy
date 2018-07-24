def call(config, body) {
  config.each{ k, v -> println "${k}:${v}" }
  if(Eval.me(config)){
    echo "ENTRA"
    body()
    
  }else{
    echo "NO VA"
  }
  
}