package stepDefintions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.log.Log;
import org.openqa.selenium.devtools.v114.network.model.RequestWillBeSent;
import org.openqa.selenium.devtools.v114.network.model.ResponseReceived;

import java.util.Optional;

public class Network {


    private WebDriver driver;
        private DevTools devTools;

        @Given("I open the browser")
        public void iOpenTheBrowser() {
            // Set up ChromeDriver with DevTools support
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            devTools = ((ChromeDriver) driver).getDevTools();
            devTools.createSession();

        System.out.println("Browser opened with DevTools support.");}

        @When("I enable network tracking")
        public void iEnableNetworkTracking() {
            // Enable network tracking in DevTools
            devTools.send(org.openqa.selenium.devtools.v114.network.Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

            // Add listeners for network events
            devTools.addListener(org.openqa.selenium.devtools.v114.network.Network.requestWillBeSent(), (RequestWillBeSent event) -> {
                System.out.println("Request URL: " + event.getRequest().getUrl());
            });

            devTools.addListener(org.openqa.selenium.devtools.v114.network.Network.responseReceived(), (ResponseReceived event) -> {
                System.out.println("Response URL: " + event.getResponse().getUrl());
                System.out.println("Response Status: " + event.getResponse().getStatus());
            });
            devTools.addListener(Log.entryAdded(), logEntry -> {
                System.out.println("Log Entry: " + logEntry.getText());
            });

            System.out.println("Network tracking enabled.");
        }

        @When("I navigate to websites")
        public void iNavigateToWebsites() {
            // Navigate to the specified URL
            driver.get("https://www.flipkart.com/");
            System.out.println("Navigated to url");
        }

        @Then("I should see the network logs")
        public void iShouldSeeTheNetworkLogs() {
            // Wait for a short duration to capture network traffic
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            // Close the browser after capturing logs
            driver.quit();
        }
    }


