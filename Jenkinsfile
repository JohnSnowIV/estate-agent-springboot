pipeline {
    agent any
    stages {
        stage('Build Maven'){
            steps{
                checkout scm
                bat 'mvn clean install'
            }
        }
//         stage('Build Docker Image'){
//             steps{
//                 script{
//                     bat 'docker build -t shippingcontainer1/java-pipeline .'
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