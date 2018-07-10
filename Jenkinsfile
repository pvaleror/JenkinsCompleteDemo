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
      //configFileProvider([configFile('GlobalVars'), configFile('Global2')]) {
      //  sh 'echo ConfigFile $FOO $TOO $GO'
      //}
      steps{
        sh "set +x"
        //sh "echo ID_RECORD: ${params.ID_RECORD}"
        addBadge(icon: "info", text: "some test")
        sh 'echo retag'
        sh 'echo verificarActividad'
        sh 'echo identificarProyectos'
        sh 'echo ValidarDespliegue'
        sh 'echo obtenerStreamOrigDest'
        sh 'echo IdentificarHerramientas'
        sh 'echo crearVista'
        sh 'echo AislarCarpeta'
        sh 'echo IniciarVistaTmp'
        sh 'echo IniciarDeliver'
        sh 'echo ObtenerIdActEntrega'
        sh 'echo ObtenerObjetos'
        sh 'echo RegistrarElementosDesplegar'
        sh 'echo RegistrarCambiosCQ'
      }
    }
    stage("Desplegar Oracle"){
      steps{
        sh 'echo Construir Instrucciones'
        sh 'echo Desplegar Estructura'
        sh 'echo Desplegar Parametros'
        sh 'echo Desplegar Packages'
      }
    }
    stage("Desplegar WebLogic"){
      steps{
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
  }
}
