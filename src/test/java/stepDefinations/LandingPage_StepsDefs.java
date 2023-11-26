package stepDefinations;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPage_StepsDefs {
	public LandingPage lp;
	TestContextSetup testContextSetup;

	public LandingPage_StepsDefs(TestContextSetup testContextSetup) {
		this.testContextSetup =  testContextSetup;
		this.lp = testContextSetup.POM.getLandingPage();
	}


	@Given("User is on GreenCart Landing Page")
	public void user_in_on_green_cart_landing_page() {		
		Assert.assertTrue(lp.getTitle().toLowerCase().contains("greenkart"));
	}
	

	@When("^User Search (.+) and extract actual name of product$")
	public void user_search_and_extract_actual_name_of_product(String prodName) throws InterruptedException {		
		lp.searchItem(prodName);
		//testContextSetup.LandingPageProdName = lp.getProductName().split("-")[0].trim();
		//System.out.println("Product name in the search result on Home Page is = " + testContextSetup.LandingPageProdName);

	}


	@And("Added {int} items of selected product to the cart")
	public void Added_items_of_selected_product_to_the_cart(int Count) {
		lp.increaseQuantity(Count);
		lp.clickAddToCart();
		System.out.println("executed Added_items_of_selected_product_to_the_cart");
	}
	
}
