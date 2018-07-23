def call(config, body) {
  if(Eval.me(config)){
    body()
    echo "ENTRA"
  }else{
    echo "NO VA"
  }
  
}