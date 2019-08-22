## Test automation task
1. __Acceptance Criteria:__
     * __Execute GET for employee URL and  Assert for {“id”, ”name", "salary”, ”age", “Image”}__ 
     * __Execute GET for a particular employee and Assert if the row returns value, additionally check if it also exists in Employee URL results__ 
     * __Validate no results found condition__ 

## To run the automated tests
This api automation framework is using *RestAssured* library. To run the tests on your windows machine do the following.

#### STEPS
1. `mvn install`
2. `mvn test`

#### From Eclipse
Install all the dependencies, and once it is done. Run _'/src/test/java/apiTest/GetEmployeeTest.java'_ as TestNG, tests will start


## Framework architecture and design

## Project Structure
### src/main/java/utils
Utility classes that can be used acrossed the project. '_CommonApiMethods_' contains commom api methods like GET, POST, etc.
'_ConfigProperties_' read config.properties file.


### src/test/java/apiTest
Test files which contains test methods.

