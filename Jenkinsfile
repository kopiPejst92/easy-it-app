pipeline {
    agent any
    tools {
        maven 'Maven 3.9.x'
        jdk 'Java 17'
    }

    stages {
        stage('Checkout'){
            steps {
                checkout scm
            }
        }

        stage('Build Source COde'){
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests'){
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surfire-reports/*.xml'
                }
            }
        }

        stage('Package Application'){
            steps {
                sh 'mvn package'
            }
        }
    }
        post {
        always {
            
            allure includeProperties: false, 
                   results: [[path: 'target/allure-results']]
        }
            success { 
                echo '🎉 Pipeline Successful'
            }
            failure {
                echo '❌ Pipeline failure'
            }
        }
}