package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Todobase;

public class TodoHP extends Todobase{
	
	@FindBy(id="todo-input") WebElement Todo;
	@FindBy(xpath="(//input[@class='toggle'])[2]") WebElement Check;
	@FindBy(xpath="(//button[@class='destroy'])[1]") WebElement Delete;
	@FindBy(xpath = "(//ul[@class='todo-list']//li)[1]") WebElement FirstTodoItem;
	

	public TodoHP(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public TodoHP EnterTodo1(String Todolist) {
		Todo.sendKeys(Todolist);
		Todo.sendKeys(Keys.ENTER);
		return this;
	}
	
	public TodoHP CheckClick() {
		Check.click();
		return this;
	}
	public TodoHP DestroyClick() {
		Actions actions=new Actions(driver);
		actions.moveToElement(FirstTodoItem).perform();
		Delete.click();
		return this;
	}
}
