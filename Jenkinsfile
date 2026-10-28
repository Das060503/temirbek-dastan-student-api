
pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
        timestamps()
    }

    environment {
        IMAGE_NAME = 'temirbek-dastan-student-api'
        IMAGE_TAG = 'v1.0-37621'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo 'Dastan Temirbek - Source checkout completed'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew --no-daemon clean bootJar'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew --no-daemon test'
                sh "find build/test-results/test -name '*.xml' -print -quit | grep -q ."
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t temirbek-dastan-student-api:v1.0-37621 .'
            }
        }

        stage('Verify') {
            steps {
                sh 'docker image inspect temirbek-dastan-student-api:v1.0-37621'
                echo 'Dastan Temirbek - Docker image verified'
            }
        }
    }

    post {
        success {
            echo 'Dastan Temirbek - Pipeline SUCCESS'
        }
        failure {
            echo 'Dastan Temirbek - Pipeline FAILED'
        }
    }
}
