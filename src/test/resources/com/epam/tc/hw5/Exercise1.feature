Feature: Service page check

  Scenario: Click checkboxes

    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    Then 'Different Elements' page should be opened
    When I select 'Water' and 'Wind' checkboxes
    Then 'Water' and 'Wind' checkboxes should be selected
    When I select radio 'Selen'
    Then Radio 'Selen' should be selected
    When I select 'Yellow' in dropdown
    Then 'Yellow' should be selected in dropdown
