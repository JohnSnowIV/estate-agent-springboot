pipeline {
    agent any
    tools {
        maven 'maven_3_9_6'
    }
    stages {
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/docker']], extensions:[], userRemoteConfigs: [[url: 'https://github.com/JohnSnowIV/estate-agent-springboot']]])
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