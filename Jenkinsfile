def appGitUrl='git@github.com:myorg/my-api.git'
def accessToken

pipeline {
    agent any
    parameters {
      string          name: 'environment',        defaultValue: 'DEV',           trim: true,     description: 'This field is required.'
  }
    stages {
        stage('Checkout Source Code') { 
        // Get code from a GitHub repository
            steps {
                //git credentialsId: 'github1', url: "git@github.com:joshuarbnsn/tweet-translation.git"
                //sh "bash ./deploy.sh"
                echo "Env: ${environment}"
            }
        }
    }
}