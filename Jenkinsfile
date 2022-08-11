pipeline {
    agent any

    tools {
        jdk 'jdk-11'
        gradle 'gradle-7.4.2'
    }

    stages {
        stage("Clean") {
            steps {
                sh "chmod +x ./gradlew";
                sh "./gradlew clean";
            }
        }
        stage("Build") {
            steps {
                sh "./gradlew build --stacktrace --parallel --daemon --profile";
            }
            post {
                success {
                    archiveArtifacts artifacts: 'build/libs/serviceversion-updater.jar', fingerprint: true
                }
            }
        }
    }
}
