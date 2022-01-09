pipeline {
  agent any
  tools {maven '1'}
  stages {
    stage('build') {
      agent any
      steps {
        sh 'mvn clean install -Dlicense.skip=true'
      }
    }

  }
}
