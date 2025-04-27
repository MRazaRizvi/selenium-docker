pipeline {
    agent {
        docker {
            image 'maven:3.8.6-openjdk-17'   // 👈 Pulls Maven + JDK preinstalled
        }
    }

    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t your-image-name .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([string(credentialsId: 'dockerhub-credentials', variable: 'DOCKER_PASSWORD')]) {
                    sh '''
                        echo "$DOCKER_PASSWORD" | docker login -u razadock --password-stdin
                        docker push your-image-name
                    '''
                }
            }
        }
    }
}
