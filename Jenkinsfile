pipeline {
  agent any
  stages {
    stage('build') {
      agent any
      steps {
        sh 'mvn clean package -Dlicense.skip=true'
      }
    }

    stage('save files') {
      steps {
        archiveArtifacts(artifacts: '**/*.jar', onlyIfSuccessful: true)
      }
    }

  }
  tools {
    maven '1'
  }
}
