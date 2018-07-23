def call(config, body) {
  if(eval(config) == "250"){
    body()
  }else{
    echo "NO VA";
  }
  
}