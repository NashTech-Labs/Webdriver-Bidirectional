# Webdriver BIDI
# Introduction
This template will help you implement how to integrate with Selenium Java  to intercept network requests, capture console logs, modify headers, and much more, adding greater flexibility and control to browser automation.
# What is the Webdriver BIDI and why do we need of Webdriver BIDI?
WebDriver BiDi (short for Bidirectional) is a protocol extension to the WebDriver standard that allows for two-way communication between the automation client (like Selenium) and the web browser.It enables real-time, event-driven interactions from both directions, allowing the client to listen to browser events as they happen and even intercept and manipulate them.


# Technologies Used
> Programming language - Java
> Automation tool -Selenium,Junit,and cucumber
> IDE - Intellij

# Libraries Used
# Cucumber
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
# Junit
    import org.junit.Assert;   
# Selenium
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;
# Webdriver BIDI
   import org.openqa.selenium.devtools.v114.log.Log;
   import org.openqa.selenium.devtools.v114.runtime.Runtime;
   import org.openqa.selenium.devtools.v114.runtime.model.ConsoleAPICalled;

# Dependencies
  <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-devtools-v114</artifactId>
            <version>4.12.1</version>
  </dependency>

# Steps for execution
1. Clone the repository on your local system by following the below command-
`git clone https://github.com/NashTech-Labs/Webdriver-Bidirectional.git
2. Go To
3. Open the project in your IDE
4. We can run the Application in 2 ways
   -> Terminal - 
   -> Test Runner - Under Step Definition, Open the Test Runnner class and execute the code.