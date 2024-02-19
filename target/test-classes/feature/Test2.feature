Feature: radio button

@tag1
  Scenario: click radio button
  
    Given User is on "<URL>" selenium easy page
    When User click radio button
    Then User is able to click check value button  
    
    Examples:
    
    | URL |
    | http://demo.seleniumeasy.com/basic-radiobutton-demo.html |  
    
    @tag2
     Scenario: click checkbox
  
    Given User is on "<URL>" selenium easy page
    When User click checkbox 
    Then User is able to see success message
    
    Examples:
    
    | URL |
    | http://demo.seleniumeasy.com/basic-checkbox-demo.html | 