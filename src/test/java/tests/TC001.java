package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Todobase;
import pages.TodoHP;

public class TC001 extends Todobase{
	
	@BeforeTest
	public void setup() {
		TestName="Todo Check";
		TestAuthor="Sundar";
		TestDescription="To Check Different Functionality of the Todo list react page";
	}
	
	@Test
	public void AddingTodo() throws IOException {
		
		TodoHP THP=new TodoHP(driver);
		THP.EnterTodo1("Go to Beach");
		TakeScreenshot("TC_Adding 1st Todo");
		THP.EnterTodo1("Have a cup of coffee");
		TakeScreenshot("TC_Adding 2nd Todo");
		THP.EnterTodo1("Have a good sleep");
		TakeScreenshot("TC_Adding 3rd Todo");
		
		//Validating whether 3 Todo's are added:
		String ExceptedText="3 items left!";
		WebElement Text=driver.findElement(By.xpath("//span[@class='todo-count']"));
		String ActualText=Text.getText();
		System.out.println(ActualText);
		Assert.assertEquals(ActualText, ExceptedText);
		
		THP.CheckClick();
		//Validating the second task is completed by printing the completed Todo
		String ExceptedText1="Have a cup of coffee";
		WebElement Text1=driver.findElement(By.xpath("//li[@class='completed']"));
		String ActualText1=Text1.getText();
		System.out.println(ActualText1);
		Assert.assertEquals(ActualText1, ExceptedText1);
		TakeScreenshot("TC_Marking 2nd Todo as completed");
		
		
		THP.DestroyClick();
		//Validating the First Todo is Deleted by printing the Remaining Todo's
		String ExceptedText2="1 item left!";
		WebElement Text2=driver.findElement(By.xpath("//span[@class='todo-count']"));
		String ActualText2=Text2.getText();
		System.out.println(ActualText2);
		Assert.assertEquals(ActualText2, ExceptedText2);
		TakeScreenshot("TC_Deleting 1st Todo");
	}
}
