BUILT on java version 1.8

how to build
1. Download the source code.
2. Navigate to the downloaded folder "travel-computer"
3. Run this step only to rebuild the jar.
   (Note : Built jar is already included in the target folder , so this step is optional.)
   Open terminal in the folder path and run the command below to create a jar file (Use java version 1.8 to build jar)
   "mvn clean install"
4. Run the below command to build docker image
   "docker build -t travel-computer ."



how to deploy
1. Run the below command to start the docker container with the image built
   "docker run -p8080:8080 travel-computer"
2. The service shoud be ready to use


how to use the services
1. Make a POST call to using below details

	Method=POST
	URI=http://localhost:8080/compute
	SAMPLE REQUEST BODY={ "vin": "W1K2062161F0046", "source": "Home", "destination": "Movie Theatre" }


	SAMPLE RESPONSE BODY=
	{
    "transactionId": "163578810495346866",
    "vin": "W1K2062161F0046",
    "source": "Home",
    "destination": "Movie Theatre",
    "distance": 50,
    "currentChargeLevel": 17,
    "isChargingRequired": true,
    "chargingStations": [
        {
            "name": "S1",
            "distance": 10,
            "limit": 20
        },
        {
            "name": "S2",
            "distance": 25,
            "limit": 15
        }
    	]
	}
