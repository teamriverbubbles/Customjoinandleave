pipeline {
  agent {
    node {
      label 'Built-In Node'
    }

  }
  stages {
    stage('build') {
      agent {
        node {
          label '1'
        }

      }
      steps {
        sh 'mvn clean package -Dlicense.skip=true'
      }
    }

  }
  tools {
    maven '1'
  }
}