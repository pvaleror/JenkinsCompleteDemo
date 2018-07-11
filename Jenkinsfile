pipeline {
  agent {
    label 'master'
  }
  parameters {
    string(defaultValue: "00001", description: 'What Record ID to deploy?', name: 'ID_RECORD')
    // choices are newline separated
    choice(choices: 'Development\nTest\nProduction', description: 'What Target to Deploy?', name: 'TARGET')
  }
  stages{
    stage('prepare'){
      when {
        not{
          environment name: 'ID_RECORD', value: '00000'
        }
        beforeAgent true
      }
      environment{
        SOME_TXT = sh returnStdout: true, script: 'perl /var/lib/jenkins/scripts/verificarActividad.pl'
      }
      steps{
        script{
          def props = readProperties file:"$JENKINS_HOME/envVars/global.properties";
          for (item in props){
            env[item.key] = item.value;
          }
        }
        echo "files: ${env.FILES}"
        echo "${SOME_TXT}"
        addInfoBadge(text: "some test",id:"info")
        addShortText(text: "${params.ID_RECORD}",border:0) //retag
        
        //sh returnStdout: true, script: 'perl /var/lib/jenkins/scripts/verificarActividad.pl' //verificarActividad

        configFileProvider([configFile('GlobalVars'), configFile('Global2')]) {
          sh 'echo ConfigFile $FOO $TOO $GO'
        }
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
        removeBadges(id: "info")
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
  }
}
