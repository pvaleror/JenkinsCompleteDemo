pipeline {
  agent {
    label 'master'
  }
  parameters {
    string(defaultValue: "00001", description: 'What Record ID to deploy?', name: 'ID_RECORD')
    // choices are newline separated
    choice(choices: 'Development\nTest\nProduction', description: 'What Target to Deploy?', name: 'TARGET')
  }
  environment{
    SOME_TXT = sh returnStdout: true, script: 'perl /var/lib/jenkins/scripts/verificarActividad.pl'
  }
  stages{
    stage('prepare'){
      when {
        not{
          environment name: 'ID_RECORD', value: '00000'
        }
        beforeAgent true
      }
      
      steps{
        addInfoBadge(text: "Ejecutando proyecto ${params.ID_RECORD}",id:"info")
        addShortText(text: "${params.ID_RECORD}",border:0)
        
        configFileProvider([configFile(fileId: 'GlobalVars', variable: 'GLOBAL_VARS')]) {
          echo "ConfigFile $GLOBAL_VARS"
          sh "cat $GLOBAL_VARS"
        }
        
        script{
          def props = readProperties file:"$JENKINS_HOME/envVars/global.properties";
          for (item in props){
            env[item.key] = item.value;
          }
        }
        
        echo "files: ${env.FILES}"
        echo "${env.SOME_TXT}"
        
        sh returnStdout: true, script: 'perl /var/lib/jenkins/scripts/verificarActividad.pl' //verificarActividad
        echo 'identifica  rProyectos'
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
      steps{
        echo "other: ${env.OTHERVAR}"
        echo "some_txt: ${env.SOME_TXT}"
        sh 'echo Construir Instrucciones'
        sh 'echo Desplegar Estructura'
        sh 'echo Desplegar Parametros'
        sh 'echo Desplegar Packages'
      }
    }
    stage("Desplegar WebLogic"){
      steps{
        echo "step: ${env.SOME_TXT} ${SOME_TXT}"
        sh 'echo Establecer Servidor Despliegue'
        sh 'echo -- Crear Carpeta Remota'
        sh 'echo Copiar archivos a server'
        sh 'echo Establecer Servidor Despliegue'
        sh 'echo -- Ejecutar despliegue'
      }
    }
    stage("Desplegar WebSphere"){
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
    failure{
      addErrorBadge(text: "Falla al ejecutar el proyecto ${params.ID_RECORD}")
    }
  }
}
