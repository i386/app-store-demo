node {
  stage 'Checkout'
  checkout scm
  
  stage 'Build'
  doBuild()

  stage 'Browser tests'
  parallel (
    'Firefox': {
        sh "echo 'setting up selenium environment'"
        sh 'sleep 5000'
    },
    'Safari': {
        sh "echo 'setting up selenium environment'"
        sh 'sleep 5000'
    },
    'Chrome': {
        sh "echo 'setting up selenium environment'"
        doBuild()
    },
    'Internet Explorer': {
        sh "echo 'setting up selenium environment'"
        doBuild()
    }
  )
  stage 'Static Analysis'
  step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])

  stage 'Package'
  step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar'])
}

def doBuild() {
    sh "mvn clean source:jar package -Dmaven.test.failure.ignore"
}