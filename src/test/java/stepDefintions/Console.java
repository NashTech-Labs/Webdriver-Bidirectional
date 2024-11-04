package stepDefintions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.log.Log;
import org.openqa.selenium.devtools.v114.runtime.Runtime;
import org.openqa.selenium.devtools.v114.runtime.model.ConsoleAPICalled;
import java.util.Collections;
import java.util.List;

public class Console {

        private WebDriver driver;
        private DevTools devTools;

        @Given("I open the browser with BiDi support")
        public void iOpenTheBrowserWithBiDiSupport() {
            // Set up ChromeDriver with BiDi support
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();

            System.out.println("Browser opened with BiDi support.");
        }

        @When("I navigate to website page")
        public void iNavigateToWebsitePage() {
            // Enable logging and runtime domains
            devTools.send(Log.enable());
            devTools.send(Runtime.enable());

            // Set up listeners for console logs
            devTools.addListener(Log.entryAdded(), logEntry -> {
                System.out.println("Log Entry: " + logEntry.getText());
            });

            devTools.addListener(Runtime.consoleAPICalled(), (ConsoleAPICalled event) -> {
                List<Object> args = Collections.singletonList(event.getArgs());
                for (Object arg : args) {
                    System.out.println("Console Log: " + arg.toString());
                }
            });

            // Navigate to the specified URL
            driver.get("https://www.flipkart.com/");
            System.out.println("Navigated to url");
        }

        @Then("I should capture console logs")
        public void iShouldCaptureConsoleLogs() {
            // Close the browser after capturing logs
            driver.quit();
        }
    }


