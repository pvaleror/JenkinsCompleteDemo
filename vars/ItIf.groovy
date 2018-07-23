def call(config, body) {
  if(Eval.me(config) == "250"){
    body()
  }else{
    echo "NO VA";
  }
  
}