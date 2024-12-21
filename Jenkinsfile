pipeline {
    agent none
    stages {
        stage('Prepare Environment') {
            agent {
                docker { image 'maven:3.8.1-openjdk-17' }
            }
            steps {
                echo 'Installing Maven...'
                sh 'mvn --version'
            }
        }
        stage('Build') {
            agent {
                docker { image 'maven:3.8.1-openjdk-17' }
            }
            steps {
                echo 'Building the project...'
                sh 'mvn clean package'
            }
        }
        stage('Docker Build') {
            agent {
                docker { image 'docker:20.10.24' }
            }
            steps {
                echo 'Building Docker image...'
                sh 'docker build -t adminka:latest .'
            }
        }
        stage('Run Docker') {
            steps {
                echo 'Running Docker container...'
                sh 'docker run -d -p 8081:8081 adminka:latest'
            }
        }
    }
    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
