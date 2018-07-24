def call(Map config, body) {
  echo config
  if(Eval.me(config)){
    echo "ENTRA"
    body()
    
  }else{
    echo "NO VA"
  }
  
}