pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
				
				powershell label: 'Maven build', script: '''
					call cd service-registry
					call mvn clean package
					call cd ../cloud-gateway
					call mvn clean package
					call cd ../user-service
					call mvn clean package
					call cd ../department-service
					call mvn clean package
				'''
				
                
                
            }
        }
     }
    
}