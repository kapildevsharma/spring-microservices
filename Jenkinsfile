pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
				
				powershell label: 'Maven build', script: '''
					cd service-registry
					mvn clean package
					cd ../cloud-gateway
					mvn clean package
					cd ../user-service
					mvn clean package
					cd ../department-service
					mvn clean package
				'''
				
                
                
            }
        }
     }
    
}