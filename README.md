# OverView
Develop a RESTful API service using Spring Boot to manage the Leaderboard for a Coding Platform while using MongoDB to persist the data.

## Implementation of Logic
1. The API must handle CRUD operations for competing user registrations
2. Each user has the following fields:
    * User ID (Unique Identifier)
    * Username
    * Score (0 <= Score <= 100)
    * Badges (Code Ninja, Code Champ, Code Master)
3. User registration requests must have a User ID and Username
4. The score must be 0, and the badges must be empty initially after the registration
5. Updation through PUT requests is only allowed for Score
6. Badges must be awarded based on the score:
    * 1 <= Score < 30 -> Code Ninja
    * 30 <= Score < 60 -> Code Champ
    * 60 <= Score <= 100 -> Code Master
7. A user can only have a maximum of three unique badges
    * {Code Ninja, Code Champ, Code Master} -> Valid
    * {Code Ninja} -> Valid
    * {Code Ninja, Code Champ, Code Master, Code Ninja} -> Invalid
8. User retrieval must be sorted based on the score
9. Sorting should have the time complexity of O(nlogn)
10. Include basic JUnit test cases to verify the operations

## Error Handling
* Handle common errors and return appropriate HTTP codes (Ex. 404, User not found)

## API EndPoints
* GET /users - Retrieve a list of all registered users
* GET /users/{userId} - Retrieve the details of a specific user
* POST /users - Register a new user to the contest
* PUT /users/{userId} - Update the score of a specific user
* DELETE /users/{userId} - Deregister a specific user from the contest

## Quick Start
* Clone this Repository your IDE
* Change the DataSource.url is used MongoDB Altas, So that my Database url is there just REPLACE it your url

## For APIs Testing
* Click: https://elements.getpostman.com/redirect?entityId=34329189-ab47c279-b5b9-4c08-8ba5-7cfb1d158686&entityType=collection

* I added Swagger UI also use to Test APIs : https://localhost:8080

