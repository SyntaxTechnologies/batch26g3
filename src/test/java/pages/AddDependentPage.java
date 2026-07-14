package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;



public class AddDependentPage extends CommonMethods {
    public AddDependentPage(){ PageFactory.initElements(driver,this);}

    @FindBy(xpath="//span[contains(normalize-space(),'My Info')]")
    public WebElement infoBtn;

    @FindBy(linkText = "Dependents")
    public WebElement dependentBtn;






}
