package Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.ProductPage;
import TestComponent.BaseTest;

public class Test1 extends BaseTest{
	
	@Test(dataProvider="JsonData")
	public void submitOrder(HashMap<String,String> input) throws InterruptedException {
		ProductPage product = landing.launchApplication(input.get("email"),input.get("password"));
		List<WebElement> productList = product.waitForListToAppear();
		product.addToCart(input.get("product"));
		CartPage cart = product.goToCart();
		Boolean match = cart.verifyCartTitle(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkpage = cart.goToCheckPage();
		checkpage.selectCountry();
		checkpage.submitProduct();
	}

	@DataProvider(name="JsonData")
	public Object[][] getData() throws IOException {
	
		List<HashMap<String,String>> data = getJsonData("D:\\Selenium\\Scripts\\16AugFramework\\src\\test\\java\\Data\\data.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

	public void test(){}
	
}
