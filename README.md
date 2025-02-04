Descrition:
A RESTful API for managing nodes. It supports adding, retrieving, and validating nodes, with auto-generation of nodeId and nodeName. The service validates user input to ensure fields are not null, empty, or contain special characters, and checks for duplicates before saving. 

API Endpoints:
GET /api/nodes: Fetch all nodes.
POST /api/nodes: Add a new node. The request should include nodeType, parentNodeGroupName, parentNodeGroupId, parentNode, description, and memo. nodeId and nodeName are auto-generated.

Example POST Request:
{
  "nodeType": "Type A",
  "parentNodeGroupName": "Group 1",
  "parentNodeGroupId": "G100",
  "parentNode": "Parent Node 1",
  "description": "Description of Node 1",
  "memo": "Memo of Node 1"
}

Validation Errors:
Returns an error message if any field is null, empty, or contains special characters.
Notes
* Auto-generated fields: nodeId and nodeName are auto-generated if not provided.
* Validation: Ensures valid input and checks for duplicates in the database before saving.

PostMan Testing Screenshots
![image](https://github.com/user-attachments/assets/5dcf8f1b-4886-4fee-bfc7-1ab2febe6b6f)
![image](https://github.com/user-attachments/assets/d09f41e6-9fba-4a79-82c2-a100fc904957)
![image](https://github.com/user-attachments/assets/9cf5fcff-dcc4-4d13-80b5-3011fe8021a9)
![image](https://github.com/user-attachments/assets/9be27d45-441b-4bc5-ba9c-9287eb518214)
![image](https://github.com/user-attachments/assets/832ef4c1-9827-4dc6-b112-d0f3d481ad4c)
![image](https://github.com/user-attachments/assets/2abfd9c3-902e-46a7-9a04-182d36038bc0)


Technologies
* Java (Spring Boot)
* PostgreSQL
* Spring Data JPA

Project Structure: 
src
└── main
    └── java
        └── com
            └── example
                └── nodeservice
                    ├── NodeServiceApplication.java
                    ├── controller
                    │   └── NodeController.java
                    ├── model
                    │   └── Node.java
                    ├── repository
                    │   └── NodeRepository.java
                    └── service
                        └── NodeService.java



                        
