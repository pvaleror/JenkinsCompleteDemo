def call(config, body) {
  if(config){
    body()
  }else{
    echo "NO VA"
  }
  
}