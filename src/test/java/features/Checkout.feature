
@tag
Feature: Search and Place the order for Products
# Scenario new
  @PlaceOrder
  Scenario Outline: Consistent Search Result on Home Page and on Offers Page
    Given User is on GreenCart Landing Page
    When User Search <Name> and extract actual name of product
    And Added 3 items of selected product to the cart
    Then User proceeds to the Checkout and Validate the <Name> items in the checkout page
    And verify user has ability to enter promo code and place the order
   # this is a checkout feature file on main branch
Examples: 
|	Name	|
| Tomato		|
