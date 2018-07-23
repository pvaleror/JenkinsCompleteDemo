import org.iteraprocess.SharedLibs.*
pipeline {
  agent {
    label 'master'
  }
  parameters {
    string(defaultValue: "REQPR000002", description: 'What Record ID to deploy?', name: 'ID_RECORD')
    // choices are newline separated
    choice(choices: 'Development\nTest\nProduction', description: 'What Target to Deploy?', name: 'TARGET')
  }
  options {
    ansiColor('xterm')
  }
  environment{
    SOME_TXT = "static text"
  } 
  stages{
    stage('prepare'){
      steps{
        script{
          if(params.ID_RECORD == "00000"){
            ItError("No se ha especificado el id del requerimiento")
          }
        }
        setEnvVars(['GlobalVars', 'Global2', 'BPM'])
        addInfoBadge(text: "Ejecutando proyecto ${params.ID_RECORD}",id:"info")
        addShortText(text: "${params.ID_RECORD}",border:0)
        
        currentBuild.result = 'FAILURE'
        
        script{
          def shProps = sh(returnStdout: true, script: "php /var/lib/jenkins/scripts/funcs.php selectRecord ${params.ID_RECORD}").trim() //verificarActividad
          if(shProps =~ /ERROR/) {
            ItError(shProps)
          }
          def props = readProperties text: shProps, replaceTokens: true;
          for (item in props){
            env[item.key] = item.value
            Console(type: 'debug', msg: item.key + '=>' + item.value)
          }
        }
        echo "\u001B[31mOther Text\u001B[0m"
        
        echo "\u001B[31mSome text\u001B[0m"
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
