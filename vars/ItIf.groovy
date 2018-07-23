def call(config, body) {
  body()
  if(Eval.me(config) == "200"){
    body()
  }else{
    echo "NO VA";
  }
  
}