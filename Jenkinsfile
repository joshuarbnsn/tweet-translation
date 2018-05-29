pipeline {
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
				sh 'mvn clean'
				sh 'mvn package'
            }
        }
        
        stage('Deploy ARM') {
      		environment {
        		ANYPOINT_CREDENTIALS = credentials('anypoint.credentials')
      		}
      		steps {
        		sh 'mvn deploy -Darm.target.name=local-runtime-3.9.1 -Danypoint.username=${ANYPOINT_CREDENTIALS_USR} -Danypoint.password=${ANYPOINT_CREDENTIALS_PSW}'
      		}
    	}
    }
}
