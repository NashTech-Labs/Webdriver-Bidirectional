Feature: WebDriver BiDi Integration

  Scenario: Intercepting network requests using WebDriver BiDi
    Given I open the browser
    When I enable network tracking
    And I navigate to websites
    Then I should see the network logs