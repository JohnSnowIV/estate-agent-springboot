pipeline {
    agent any
    stages {
        stage('Clone Repo'){
            steps{
                checkout scm
            }
        }
        stage('Build Maven'){
            steps{
                sh 'mvn clean install'
            }
        }
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
