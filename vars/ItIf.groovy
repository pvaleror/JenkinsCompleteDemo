def call(config, body) {
  if(Eval.me(config) == "200"){
    body()
  }else{
    echo "NO VA";
  }
  
}