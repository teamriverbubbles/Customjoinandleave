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
        archiveArtifacts(artifacts: 'target/customjoinandleave-1.1-SNAPSHOT.jar', onlyIfSuccessful: true)
      }
    }

  }
  tools {
    maven '1'
  }
}