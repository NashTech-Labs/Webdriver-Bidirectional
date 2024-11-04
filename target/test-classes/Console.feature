Feature: Capture DevTools Logs using WebDriver BiDi

  Scenario: Capture console logs using WebDriver BiDi
    Given I open the browser with BiDi support
    When I navigate to website page
    Then I should capture console logs
