# CoderHack Leaderboard API

This is a RESTful API service for managing the leaderboard of a coding platform contest using Spring Boot and MongoDB.

## Endpoints

- `GET /users` - Retrieve a list of all registered users
- `GET /users/{userId}` - Retrieve the details of a specific user
- `POST /users` - Register a new user to the contest
- `PUT /users/{userId}` - Update the score of a specific user
- `DELETE /users/{userId}` - Deregister a specific user from the contest

## Badges

- `1 <= Score < 30` -> Code Ninja
- `30 <= Score < 60` -> Code Champ
- `60 <= Score <= 100` -> Code Master

## Running the Application

1. Install MongoDB and start the MongoDB server.
2. Clone the repository.
3. Navigate to the project directory.
4. Run `mvn spring-boot:run`.

## Postman Collection

[Postman Collection](./postman_collection.json)
