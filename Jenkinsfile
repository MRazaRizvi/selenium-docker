pipeline {
    agent {
        docker {
            image 'maven:3.8-openjdk-17'   // 👈 Pulls Maven + JDK preinstalled
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
                sh 'docker build -t=vinsdocker/selenium .'
            }
        }

        stage('Push Docker Image') {
            environment{
                  DOCKER_HUB = credentials('dockerhub-creds')
            }

            steps {
                sh 'docker login -u %DOCKER_HUB_USR% -p %DOCKER_HUB_PSW%'
                sh "docker push vinsdocker/selenium"
                }
            }
        }


        post {
            always {
                 sh "docker logout"
            }
           }
    }




