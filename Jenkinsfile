pipeline {
	agent { docker { image 'maven:3.5.3' } }
	
	environment {
        MVN_SETTINGS = credentials('priv_settings.xml')
    }
    
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
				sh 'mvn clean package -s ${MVN_SETTINGS}'
            }
        }
        stage('Deploy ARM') {
      		environment {
        		ANYPOINT_CREDENTIALS = credentials('anypoint.credentials')
      		}
      		steps {
        		echo 'mvn org.mule.tools.maven:mule-maven-plugin:deploy -Darm.target.name=local-runtime-3.9.1 -Danypoint.username=${ANYPOINT_CREDENTIALS_USR} -Danypoint.password=${ANYPOINT_CREDENTIALS_PSW}'
      		}
    	}
    }
}
