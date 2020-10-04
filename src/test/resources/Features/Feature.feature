#@ui @healthcheck
# Feature: E-commerce project website healthcheck
 # Scenario: User is able to open the browser and navigate
     # to the URL and search for the product
      #Given User open the browser
      #And user navigated to the home application url
      #And user serach for the product "Laptop"
      #When User click on the search product
      #Then pdroduct description open in a new tab


    @ui @healthcheck
    Feature: E-commerce Project Web Site Health Check

    Scenario: User is able to Open the browser, navigate to the URL and Search for Product
      Given User navigated to the home application url
      When User Search for product "Laptop"
      Then Search Result page is displayed

    Scenario: User is click on the Product and check the Product Details
      Given User navigated to the home application url
      And User Search for product "Earphone"
      When User click on any product
      Then Product Description is displayed in new tab
