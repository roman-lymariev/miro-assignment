# MIRO-ASSIGNMENT
I am very grateful for the opportunity to do it. The assignment was challenging enough and super fun!
Also, it gave me a chance to know wonderful Miro product a little bit closer.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites
The solution is OS-independent. You will need the following: 

* [Java 9+](https://java.com/en/download/help/download_options.xml)
* [Maven](https://maven.apache.org/install.html)
* [Chrome](https://www.google.com/chrome/)
* [chromedriver.exe (aligned with Chrome version)](https://chromedriver.chromium.org/downloads)

### Installing
 - download the project
 - open download folder
 - if chromedriver.exe is not installed in the system, copy it to the project root

## Running the tests
To run the automated tests, go to the solution download folder, open command line (cmd, shell, etc) and run command:
```
mvn clean install
```
After execution is finished, you can open /target/site/serenity/index.html to see HTML report.


## Built With
* [SerenityBDD](https://www.thucydides.info) - The framework. I picked it for the assignment because is packs nice Selenium wrappers, 
jBehave, test data management, plus nice HTML report. It facilitates convention-over-configuration approach, so quite easy to set up.
* [Maven](https://maven.apache.org/) - another pillar of the framework. I am also experienced with Gradle, but Maven still seems
to dominate Java landscape (save for Android development). So I picked Maven for the assignment.
* [REST-Assured](https://rest-assured.io/) - simple and elegant REST API client, an engineering standard of test automation.
* [aShot](https://github.com/pazone/ashot) - WebDriver Screenshot utility. I was selecting between already familiar ApplitoolsEyes and 
not yet familiar aShot. Decided to take a bit of extra challenge and chosen aShot, as it is a free tool. Quite liked it!
* [jBehave](https://jbehave.org) - BDD tools are popular these days, so I decided to demonstrate some proficiency with one. 
Otherwise I would have selected plain jUnit or TestNG. 

## Framework Composition
-- resources-filtered/testdata - to store test data separately from code
-- resources/stories - test scenarios written in Gherkin and stored in .story files. I prefer jBehave implementation. Stored in /resources/stories/
-- story - blank Java classes, one for each .story file. Allow jUnit test runner to pick and run corresponding .story files.
-- steps - stored in the /java/framework/steps/ folder. A glue code between Stories and PageObjects.
-- pages - PageObjects to interact with tested website via Selenium. Each PageObject represents one page/frame/other logical piece.


## The Task
To automate the following Test case from Sticker creation functionality:
We have two users in Miro. Verify that the sticker which was created on a board by the first user will appear on the board 
for the second user.

## My approach
I read the tips and took advantage of using REST API calls to create a board and to open/invite. 
During a sticker creation I decided to add color and text, even if it was not required by test scenario.
The presence of the sticker on the second user board is verified by comparing a screenshot with baseline image.
Quick and simple, the margin of difference helps to handle different shapes of sticker "shadow".

POJOes: big pojo objects might look like an overkill, but they are actually auto-generated to save time.
Steps: Most of steps are divided between broad API and UI categories for simplicity sake,
BrowserSteps and SetupTeardownSteps pretty much speak for itself.

## What would I improve next
- implement Delete Board via API to cleanup after tests
- implemented pick style for a Sticker
- created a proper helper for aShot
- implement encrypt passwords and tokens in .properties

## 
## Author

* **Roman Lymariev**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to all brilliant individuals I had a pleasure to work with and to learn from!


