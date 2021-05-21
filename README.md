##### How to run java application (Windows)
###### Without build jar
1. Open command prompt in project folder 
2. Run application, type: mvnw spring-boot:run

###### With build jar
1. Open command prompt in project folder 
2. Compile java source code, type: mvnw clean package
3. Run application: java -jar target/test-geekseat.jar

Sample: 
- url: localhost:8080/calculate
- method: POST

- body request : 
{
    "A": {
        "ageOfDeath": 10,
        "yearOfDeath": 11
    },
    "B": {
        "ageOfDeath": 10,
        "yearOfDeath": 54
    }
}