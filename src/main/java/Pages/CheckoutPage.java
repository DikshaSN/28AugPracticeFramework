package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement textbox;
	
	@FindBy(css=".list-group-item")
	List<WebElement> countryList;
	
	@FindBy(css=".action__submit")
	WebElement submitButton;
	
	public void selectCountry() {
		Actions a = new Actions(driver);
		a.sendKeys(textbox, "Ind").build().perform();
		waitForWebElementToListAppear(countryList);
		WebElement India = countryList.stream().filter(s->s.getText().equalsIgnoreCase("India")).findFirst().orElse(null);
		India.click();
	}
	
	public void submitProduct() {
		submitButton.click();
	}
}
