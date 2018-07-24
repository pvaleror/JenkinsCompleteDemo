def call(config, body) {
  config.each{ k, v -> println "${k}:${v}" }
  if(config){
    echo "ENTRA"
    body()
    
  }else{
    echo "NO VA"
  }
  
}