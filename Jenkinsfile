pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        build 'clean'
        build 'package'
      }
    }

  }
}