pipeline {
    agent any
    stages {
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/docker']], extensions:[], userRemoteConfigs: [[url: 'https://github.com/JohnSnowIV/estate-agent-springboot.git']]])
                sh 'mvn clean install'
            }
        }
//         stage('Build Docker Image'){
//             steps{
//                 script{
//                     sh 'docker build -t shippingcontainer1/java-pipeline .'
//                 }
//             }
//         }
//         stage('Push to Docker'){
//             steps{
//                 script{
//                     withCredentials
//                 }
//             }
//         }
    }
}