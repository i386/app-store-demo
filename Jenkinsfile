node {
  stage 'Checkout'
  checkout scm
  
  stage 'Build'
  def mvnHome = tool 'M3'
  doBuild()

  stage 'Browser tests'
  parallel (
    'Firefox': {
        sh "echo 'setting up selenium environment'"
        doBuild()
    },
    'Safari': {
        sh "echo 'setting up selenium environment'"
        doBuild()
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
    def mvnHome = tool 'M3'
    sh "${mvnHome}/bin/mvn clean source:jar package"
}