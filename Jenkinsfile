pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/JohnSnowIV/estate-agent-springboot.git'

                // Run Maven on a Unix agent.
                sh "mvn clean install"
            }

        }
    }
}