@ui @healthcheck
  Feature: E-commerce project website healthcheck
    Scenario: User is able to open the browser and navigate
      to the URL and search for the product
      Given User open the browser
      And user navigated to the home application url
      And user serach for the product "Laptop"
      When User click on the search product
      Then pdroduct description open in a new tab
