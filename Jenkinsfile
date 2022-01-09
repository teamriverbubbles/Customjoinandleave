pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        sh 'mvn clean package -Dlicense.skip=true'
      }
    }

  }
  tools {
    maven '1'
  }
}