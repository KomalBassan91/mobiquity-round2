# mobiquity-assignment
Mobiquity Assignment

## Building
For building mobiquity-round2 locally

- Set Java Home and Maven Home variable in your environment variables `JAVA_HOME & MAVEN_HOME`
- Import the mobiquity-round2 in your local IDE `InteliJ or Eclipse`
- Configure Java and Maven in your local IDE
- Create and Configure `reports` folder in the base directory and update `Constants.java`

**Note:** You should create `reports` folder to generate graphical reports for all test cases in the project
## Running
- Goto `testng.xml` right-click and run the project

## TestCase Explaination

|ClassName   |   MethodName  | Description                                                                                | Status |
 |---------------|--------------------------------------------------------------------------------------------|--------|-------------|
UsersTest| verifyPostsForUser     | Test to validate Posts for a given user id identified by given username from the excel     | Pass   |
UsersTest| verifyAlbumsForUser | Test to validate Albums for a given user id identified by given username from the excel    | Pass   |
UsersTest | verifyIncorrectUser | Test validity of given user from the excel                                            | Pass   |
PostsTest | verifyEmailforPosts  | Test to validate email-id for each Comment of every Post for the given user from excel     | Pass   |
AlbumsTest | verifyPhotosforAlbums | Test to validate photo-url for each Photo of every Album for the given user from excel     | Pass   |
BaseClass |     | Generic class used for reporting purpose and setting up environment for each Test Class to run | -      |
Helper |  | Utility class used for reusability of code purposes                                        | -      |

##What is covered
Framework Explaination

**Language:** In my Test Project I am using Java as a language.

**Type of Framework:** I am using TestNG-RestAssured Framework for API Testing for building a robust,externalised and scalable framework.

**Test Data:** All the test user data will be kept in an excel sheet.I pass test data and handle data-driven testing. I use Apache POI to handle excel sheets.

**Extent Reports:** For the reporting purpose, I am using Extent Reports. It generates readable HTML reports. I use the extent reports for maintaining logs in the Extent Report.

##What wasn't covered
Items that couldn't be covered due to time crunch/API short-comings:
- Couldn't spend enough time on code refinement
- Couldn't operate on HTTP Codes coming from out of the application for invalid URL's like:https://jsonplaceholder.typicode.com/users/abcd/posts, https://jsonplaceholder.typicode.com/albums/a/photos
- Couldn't integrate Circle CI for continuous integration but Have done Github Actions-instead 

