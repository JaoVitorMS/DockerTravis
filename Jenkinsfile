pipeline {
    agent any

    stages {
        stage('Check Java Version') {
            steps {
                // Verifica a versão do Java
                sh 'java -version'
            }
        }

        stage('Build') {
            steps {
                // Faz o build do projeto usando Gradle
                sh './gradlew clean build'
            }
        }

        stage('Run Unit Tests') {
            steps {
                // Executa os testes de unidade
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            // Arquiva relatórios de teste para visualização no Jenkins
            junit '**/build/test-results/test/*.xml'
        }
        success {
            echo 'Build e testes concluídos com sucesso!'
        }
        failure {
            echo 'Ocorreu um erro no build ou nos testes.'
        }
    }
}