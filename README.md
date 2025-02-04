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



                        
