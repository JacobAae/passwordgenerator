### Password generator REST service
    1. Technologies
        * Scala 
        * Akka
        * Spray
    2. Installation
        * Clone the repository
        * Import the project in your IDE
        * Run the Boot Object
        * navigate to ``localhost:8080/passgen/{length}`` where {length} 
          is the desired password length, defaults to 8.   
    3. Testing

## Using gradle

The gradlew is a wrapper for Gradle that bootstraps Gradle, so no installation is necessary. If you do not have Gradle installed use ./gradlew instead of gradle

*Compiling the project*

 gradle assemble

*Compile project and run all tests*

 gradle build

*Run tests*

 gradle test

*Run the project*

 gradle run