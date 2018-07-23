def call(config, body) {
  body()
  if(Eval.me(config)){
    body()
  }else{
    echo "NO VA";
  }
  
}