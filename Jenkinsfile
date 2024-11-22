pipeline {
    agent any

    stages {
        stage('Check Java Version') {
            steps {
                sh 'java -version'
            }
        }

        stage('Setup Java Toolchain') {
            steps {
                sh '''
                if ! java -version 2>&1 | grep -q "17"; then
                    echo "Java 17 is not installed. Installing Java 17..."
                    sudo apt-get update
                    sudo apt-get install -y openjdk-17-jdk
                fi
                '''
            }
        }

        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Run Unit Tests') {
            steps {
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
        }
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'An error occurred during the build or tests.'
        }
    }
}