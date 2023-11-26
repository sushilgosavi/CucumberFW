
@tag
Feature: Search and Place the order for Products

  @OfferPage
  Scenario Outline: Consistent Search Result on Home Page and on Offers Page
    Given User is on GreenCart Landing Page
    When User Search <Name> and extract actual name of product
    Then User Serach <Name> on offer page 
    #And Validate HomePage and OfferPage products are same

Examples:
|	Name	|
| Tomato	|

