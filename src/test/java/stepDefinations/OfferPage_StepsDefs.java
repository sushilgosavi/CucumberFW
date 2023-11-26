package stepDefinations;


import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OfferPage_StepsDefs {
	TestContextSetup testContextSetup;
	public OffersPage op;
	public LandingPage lp;
	public String offerPageProdName;
	
	public OfferPage_StepsDefs(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.op  = testContextSetup.POM.getOffersPage();
		this.lp = testContextSetup.POM.getLandingPage();
	}
	
	
	@Then("^User Serach (.+) on offer page$")
	public void user_serached_for_same_product_on_offer_page_to_check_if_product_exists(String pName) {
		switchToOffersPage();
		
		op.searchItem(pName);
		offerPageProdName = op.getFirstProductName();
		System.out.println("Product name in the search result on Offer Page is = " + offerPageProdName);	
	}
	
	
	public void switchToOffersPage() {
		
		lp.clickTopDeals();
		testContextSetup.genericUtils.SwitchWindowToChild();
	
	}
	
	
	@And("Validate HomePage and OfferPage products are same")
	public void Validate_HomePage_and_OfferPage_products_are_same() {		
		Assert.assertEquals("Tomato", testContextSetup.LandingPageProdName);
	}
}
