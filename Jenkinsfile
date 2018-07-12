pipeline {
  agent {
    label 'master'
  }
  parameters {
    string(defaultValue: "00000", description: 'What Record ID to deploy?', name: 'ID_RECORD')
    // choices are newline separated
    choice(choices: 'Development\nTest\nProduction', description: 'What Target to Deploy?', name: 'TARGET')
  }
  environment{
    SOME_TXT = "static text"
  }
  stages{
    stage('prepare'){
      //when {
      //  not{
      //    environment name: 'ID_RECORD', value: '00000'
      //  }
      //  beforeAgent true
      //}
      steps{
        script{
          if(params.ID_RECORD == "00000"){
            error("No se ha especificado el id del requerimiento")
          }
        }
        configFileProvider([
          configFile(fileId: 'GlobalVars', variable: 'GlobalVars'),
          configFile(fileId: 'Global2', variable: 'Global2'),
          configFile(fileId: 'BPM', variable: 'BPM')
        ]){
          script{
            def globaProps = "$JENKINS_HOME/envVars/global.properties"
            def shProps = sh returnStdout: true, script: "cat $GlobalVars;echo;cat $Global2;echo;cat $BPM;"
            def props = readProperties file: globaProps, text: shProps, replaceTokens: true;
            for (item in props){
              env[item.key] = item.value;
            }
          }
        }
        addInfoBadge(text: "Ejecutando proyecto ${params.ID_RECORD}",id:"info")
        addShortText(text: "${params.ID_RECORD}",border:0)
        script{
          def shProps = sh returnStdout: true, script: "php /var/lib/jenkins/scripts/funcs.php selectRecord ${params.ID_RECORD}" //verificarActividad
          def props = readProperties text: shProps, replaceTokens: true;
          for (item in props){
            env[item.key] = item.value;
          }
        }
        echo 'ValidarDespliegue'
        echo 'obtenerStreamOrigDest'
        echo 'IdentificarHerramientas'
        echo 'crearVista'
        echo 'AislarCarpeta'
        echo 'IniciarVistaTmp'
        echo 'IniciarDeliver'
        echo 'ObtenerIdActEntrega'
        echo 'ObtenerObjetos'
        echo 'RegistrarElementosDesplegar'
        echo 'RegistrarCambiosCQ'
      }
    }
    stage("Desplegar Oracle"){
      when {
        not{
          environment name: 'BPM_ORACLE', value: ''
        }
        beforeAgent true
      }
      steps{
        echo "other: ${env.OTHERVAR}"
        sh 'echo Construir Instrucciones'
        sh 'echo Desplegar Estructura'
        sh 'echo Desplegar Parametros'
        sh 'echo Desplegar Packages'
      }
    }
    stage("Desplegar WebLogic"){
      when {
        not{
          environment name: 'BPM_WEBLOGIC', value: ''
        }
        beforeAgent true
      }
      steps{
        sh 'echo Establecer Servidor Despliegue'
        sh 'echo -- Crear Carpeta Remota'
        sh 'echo Copiar archivos a server'
        sh 'echo Establecer Servidor Despliegue'
        sh 'echo -- Ejecutar despliegue'
      }
    }
    stage("Desplegar WebSphere"){
      when {
        not{
          environment name: 'BPM_WEBSPHERE', value: ''
        }
        beforeAgent true
      }
      steps{
        
        sh 'echo retag'
        sh 'echo retag'
        sh 'echo retag'
        sh 'echo retag'
        sh 'echo retag'
      }
    }
    stage("Registrar Cambios"){
      steps{
        sh "printenv"
        sh "set"
        sh 'echo CompletarDeliver'
        sh 'echo EliminarVistaTmp'
        sh 'echo RegistrarDespliegue'
      }
    }
  }//stages
  post{
    always{
      removeBadges(id: "info")
    }
    success{
      addBadge(icon: "completed.gif", text: "Finalizado con exito")
    }
    failure{
      addErrorBadge(text: "Falla al ejecutar el proyecto ${params.ID_RECORD}")
    }
  }
}
