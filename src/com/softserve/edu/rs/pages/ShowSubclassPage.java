package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.rs.data.resources.ISubclass;

public class ShowSubclassPage extends RegistratorHomePage {

	private WebElement subclassAddButton;

	public ShowSubclassPage(WebDriver driver) {
		super(driver);
		this.subclassAddButton = driver.findElement(By.xpath("//*[@id='body']/p/a"));
	}

	// get--------------------------

	public WebElement getSubclassAddButton() {
		return this.subclassAddButton;
	}

	// set-------------------------

	public void clickSubclassAddButton() {
		getSubclassAddButton().click();
	}
	
	// Business Logic
	
	public void findElementToDelete(String subclass) {
		WebElement elementToDelete = driver.findElement(By.xpath("//table[@id='datatable']//tr[td='"+subclass+"']//a"));
		elementToDelete.click();
	}
	
	 public boolean findPresentSubclass(ISubclass subclass){
		 try{
				driver.findElement(By.xpath("//table[@id='datatable']//tr[td='"+subclass.getSubclassName()+"']//a"));
			}
			catch (Exception ex){
				return false;
			}
				return true;	
		}
	 
	// Functional

	public ShowSubclassPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new ShowSubclassPage(driver);
	}

	public LoginPage logout() {
		clickLogout();
		return new LoginPage(driver);
	}

	 public AddSubclassPage gotoAddSubclassPage() {
		 clickSubclassAddButton();
	        return new AddSubclassPage(driver);
	    }
	
	 public ShowSubclassPage deleteSubclass(ISubclass subclass) {
			findElementToDelete(subclass.getSubclassName());
			driver.findElement(By.xpath("//button[.='OK']")).click();
			return new ShowSubclassPage(driver);
		}

}
