pipeline {
  agent any
  stages {
    stage('clone') {
      steps {
        git(url: 'https://github.com/teamriverbubbles/Customjoinandleave.git', branch: 'main')
      }
    }

    stage('build') {
      steps {
        sh ' sh "mvn -Dmaven.test.failure.ignore=true clean package"'
      }
    }

  }
}