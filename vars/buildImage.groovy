#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([string(credentialsId: 'jbalialoui', variable: 'dockerhubpwd')]) {
        sh 'docker build -t jbalialoui/my-app-1.0 .'
        sh 'docker login -u jbalialoui -p ${dockerhubpwd}'
        sh 'docker push jbalialoui/my-app-1.0'
    }
}