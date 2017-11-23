pipeline {
  agent {
    docker {
      image 'maven'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean source:jar package'
      }
    }
    stage('Browser Tests') {
      parallel {
        stage('Firefox') {
          steps {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 5 localhost'
            sh 'mvn test'
          }
        }
        stage('Safari') {
          steps {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 8 localhost'
            archive '**/target/*.jar'
            sh 'mvn test'
          }
        }
        stage('Chrome') {
          steps {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 3 localhost'
            archive '**/target/*.jar'
            sh 'mvn test'
          }
        }
        stage('Internet Explorer') {
          steps {
            sh 'echo \'setting up selenium environment\''
            sh 'ping -c 4 localhost'
            archive '**/target/*.jar'
            sh 'mvn test'
          }
        }
      }
    }
    stage('Static Analysis') {
      steps {
        sh 'mvn findbugs:findbugs'
      }
    }
    stage('Deploy') {
      steps {
        sh 'mvn source:jar package -Dmaven.test.skip'
      }
    }
  }
  post {
    always {
      junit '**/target/surefire-reports/TEST-*.xml'
      
    }
    
  }
}