package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPage_StepsDefs {
	
	TestContextSetup testContextSetup;
	public CheckoutPage cp;
	public CheckoutPage_StepsDefs(TestContextSetup testContextSetup) {
		this.testContextSetup =  testContextSetup;
		this.cp = testContextSetup.POM.getCheckoutPage();
	}


	@And("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(cp.verifyPromoBtn());
		Assert.assertTrue(cp.verifyPlaceOrder());
	}
	
	@Then("^User proceeds to the Checkout and Validate the (.+) items in the checkout page$")
	public void User_proceeds_to_the_Checkout_and_Validate_the_items_in_the_checkout_page(String iName) throws InterruptedException {
		cp.checkoutItems();
		Assert.assertEquals(iName,cp.getProductName());
	}
}
