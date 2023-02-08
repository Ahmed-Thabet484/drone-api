Prerequisites:
•	Java 8 version
•	Create a folder as D:/Drones and place the image Capture.png under resources folder to insert the images in script.sql file with image.
•	Database url should be as screenshot below as I encountered an error and had to change it manually.
 

API examples:

1-	Register a Drone
URL: http://localhost:8080/api/register
Method: Post
Payload body example: {
  "serialNumber": "QBBERTGTQTY",
  "model": "LIGHTWEIGHT",
  "weightLimit": 500,
  "batteryCapacity": 0.55,
  "state": "IDLE"
}

I have assumed that we can register a drone with other state than idle so I did not do any validations on the state except to match the enum State

2-	Load Drone with Medications:
URL:  http://localhost:8080/api/load-drone
Method: Put
Payload body example:
{
  "serialNumber": "QBBERTGTQTY",
  "medications": [
    {
      "name": "testt",
      "weight": 70,
      "code": "testtest",
      "image": null
    },
    {
      "name": "Theophylline",
      "weight": 10,
      "code": "THEO_123",
      "image": null
    }
  ]
}

I have assumed that if the medication is not registered already, the system will register it and load it to the drone. Else it will just update the medications with the drone serial number indicating that it is loaded.
3-	Get medications by drone serial number.
URL: http://localhost:8080/api/drone/{serialNumber} 
Method: Get
4-	Get battery level of a drone.
URL: http://localhost:8080/api/battery-level/{serialNumber}  
Method: Get
5-	Get drones that can be loaded with medications.
URL: http://localhost:8080/api/idle-drones
Method: Get



