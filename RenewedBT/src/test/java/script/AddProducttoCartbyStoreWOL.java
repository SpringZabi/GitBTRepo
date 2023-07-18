package script;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;
import page.AddtoBagePage;
import page.BtHomepage;
import page.CheckOutPage;
import page.MultiRetailerGridPage;
import page.StoreGridPage;
import page.StoreListPage;

/**
* @author Jisha Jayaram
*
*/


public class AddProducttoCartbyStoreWOL extends CommonBaseTest {
	@Test(priority = 14)
	public void AddproductbyStore() throws Throwable
	{
		try {
			BtHomepage bhp = new BtHomepage(driver);
			MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
			StoreGridPage sgp = new StoreGridPage(driver);
			StoreListPage slp = new StoreListPage(driver);
			AddtoBagePage atb = new AddtoBagePage(driver);
			CheckOutPage cp = new CheckOutPage(driver);
			bhp.clickStoreElement();
			Thread.sleep(3000);
			mrp.popUpCloseButton();
			//System.out.println("Clicked on signup pop-up button");
			slp.clickRetailerone();
			Thread.sleep(1000);
			
			String allstoretxt = sgp.getAllstoreElement();
			//Thread.sleep(1000);			
			
			String retailernametxt = sgp.getRetailerName();
			System.out.println("Retailer name is "+retailernametxt);
			System.out.println("allstoretxt = "+allstoretxt);
			if(allstoretxt.equals("All Stores"))
			{
				extentTest.log(Status.INFO,"User entered to store page");
				extentTest.log(Status.INFO, "Retailer picked:  "+retailernametxt);
			}
			else
			{
				extentTest.log(Status.FAIL, "Unable to navigate to Store page");
			}	
		
			String gridproduct = mrp.getGridProduct_name();
            extentTest.log(Status.INFO, "The product name picked from Grid page is: "+gridproduct);
			Thread.sleep(3000);			
			
			WebElement pn = mrp.getFirst_Product();	
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 // This  will scroll down the page by  1000 pixel vertical		
	        js.executeScript("window.scrollBy(0,1000)");
		
			mrp.clickAddtoBagBtn();
			Thread.sleep(1000);
			String atbprodtext = atb.getATBPopUpProd_Name();
			extentTest.log(Status.INFO, "The product name picked from Add to Bag pop-up is: "+atbprodtext);
			//System.out.println("Clicked MRP add to bag button");
			atb.clickATBPopUpBtn();
			System.out.println("Clicked Add to Bag pop-up button");			
			Thread.sleep(3000);
			bhp.clickCartImg();
			Thread.sleep(1000);
			String cpn = cp.getCheckoutProdName();
			System.out.println("Clicked cart image from top");

			extentTest.log(Status.INFO, "The product added to cart is: "+cpn);
			
			if (atbprodtext.equals(cpn)) 
			{
				System.out.println("Strings are equal");
				extentTest.log(Status.INFO, "The Item added to cart successfully");
							
				String cpLogintxt = cp.getLoginBtn();
							
			    System.out.println("Checkout page login button txt = "+cpLogintxt);
							
				if (cpLogintxt.equals("Login"))
					{
						extentTest.log(Status.PASS, "The user is not logged in and product is added to cart");
					}
				else
					{
						extentTest.log(Status.FAIL, "Login button is missing in the checkout page");
					}
			} 
			else {
				System.out.println("Strings are NOT equal");
				extentTest.log(Status.FAIL, "The selected item is not added to cart properly");
						}
		}
		 catch(Exception e)
		 {
			 System.out.println("Oh.. No..  Caught with some error");
		 }
		}
	}
