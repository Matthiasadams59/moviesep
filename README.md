# moviesep

React project bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Structure 

In the menu bar we have three elements :
* Login
* Home (profile/favorites)
* Films List 

You can access the other pages with :
* Actor : /actor
* Film : /film

## Deployment

To launch the Java API Server, first of all import the moviesep database from the moviesep-webapi/ folder into your MySQL provider.  
Once imported edit the file : moviesep-webapi/src/main/resources/application.properties to make sure the configuration correspond to your MySQL provider settings.  
By default, using MAMP the MySQL port will be 8889, the default user/password will be root/root.  
Then from the root of the project :  
```
cd moviesep-webapi/  
mvn install  
mvn clean compile package  
java -jar target/moviesep-webapi-0.0.1-SNAPSHOT.jar  
```
If everything is fine, the api server should start listening on port 8080.  

Performing a GET request will return :  
* The list of actors on /actor/, a specific actor on /actor/{id}  
* The list of users on /user/, a specific user on /user/{id}  
* The list of films on /film/, a specific film on /film/{id}  

Performing a POST request :
* To create an actor on /actor/, to update a specific actor on /actorUpdate/{id}  
* To create a film on /film/, to update a specific film on /filmUpdate/{id}  
* To create a user on /user/, to update a specific user on /userUpdate/{id}  

Performing a DELETE request :  
* To delete an actor on /actorDelete/{id}  
* To delete a film on /filmDelete/{id}  
* To delete a user on /userDelete/{id}

Afterwards, open a new terminal and go back to the root of the project :
```
npm install
```
Then to launch the project : 
```
npm start
```
If you want to execute the tests : 
```
npm test
```
The project will start on localhost:3000  

Two users come with the application : 
* User 1 : username =  'rippaulwalker', password = 'ff4life'  
* User 2 : username = 'thanosdu92', password = 'madarauchiha'  

## Built with

* Visual Studio Code  
* Babel  
* Webpack  
* Spring Tool Suite 4.0.1
* MAMP (MySQL Database)

## Requirements

* Java 8+
* Maven
* Moviesep database (moviesep-webapi/moviesep-database.sql) imported in your MySQL Provider
* MySQL Active on Port 8889 (by default for MAMP users)
* React  
* NodeJs  
* NPM  

## Author

Ali Taïga Matthias-Adams  
William Aboucaya  
Noureddine Saidana  
Praveen Soni
