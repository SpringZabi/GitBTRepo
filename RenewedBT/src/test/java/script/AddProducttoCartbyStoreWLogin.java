package script;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.CommonBaseTest;
import generic.WebDriverUtility;
import page.AddtoBagePage;
import page.BtHomepage;
import page.CheckOutPage;
import page.MultiRetailerGridPage;
import page.SignInPage;
import page.StoreGridPage;
import page.StoreListPage;

/**
* @author Jisha Jayaram
*
*/

public class AddProducttoCartbyStoreWLogin  extends CommonBaseTest{

	@Test(priority = 13)
	public void AddproductbyStoreWL() throws Throwable
	{
		try {
			
			SignInPage signinpage = new SignInPage(driver);
			BtHomepage bhp = new BtHomepage(driver);
			MultiRetailerGridPage mrp = new MultiRetailerGridPage(driver);
			StoreGridPage sgp = new StoreGridPage(driver);
			StoreListPage slp = new StoreListPage(driver);
			AddtoBagePage atb = new AddtoBagePage(driver);
			CheckOutPage cp = new CheckOutPage(driver);
			WebDriverUtility webDriverUtility = new WebDriverUtility();
			
			signinpage.signinJoinMouseOver();
			signinpage.singInClick();
			Thread.sleep(1000);
			
			String signInmail = "jisha@springdigital.com.au";
			String signInPassword ="Bt@2023";
			signinpage.enterSingInEmail(signInmail);
			signinpage.enterSingInPwd(signInPassword);
			signinpage.btnClick();
			Thread.sleep(5000);
			
			bhp.clickStoreElement();
			Thread.sleep(3000);
			
			slp.clickRetailerone();
			Thread.sleep(1000);
			
			String allstoretxt = sgp.getAllstoreElement();
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
            Thread.sleep(1000);
            
            WebElement addtobagbtn = mrp.AddtoBagBtn();
            
        //    webDriverUtility.scrollUntilElementFound(driver, addtobagbtn);
            
          //  webDriverUtility.scrollBarAction(driver);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			 // This  will scroll down the page by  1000 pixel vertical		
	        js.executeScript("window.scrollBy(0,1500)");
		
			mrp.clickAddtoBagBtn();
			Thread.sleep(1000);
			String atbprodtext = atb.getATBPopUpProd_Name();
			extentTest.log(Status.INFO, "The product name picked from Add to Bag pop-up is: "+atbprodtext);
			
			atb.clickATBPopUpBtn();
			System.out.println("Clicked Add to Bag pop-up button");			
			Thread.sleep(3000);
			
			WebElement stockvalidationelement = atb.getStockvalidationElement();
			boolean status = stockvalidationelement.isDisplayed();
			if(status)
			{
			
				String svtxt = atb.getStockvalidationtxt();
				System.out.println("Stock validation text is : "+svtxt);
				extentTest.log(Status.INFO, "The maximum quantity available for the product is 1and it is already added in your cart");
				
				atb.clickCloseIcon();
				Thread.sleep(1000);
				
				bhp.clickCartImg();
				System.out.println("Cat icon clicked");
				Thread.sleep(2000);
				String cpn = cp.getCheckoutProdName();
				System.out.println("Getting product name from checkout page "+cpn);

				extentTest.log(Status.INFO, "The product added to cart is: "+cpn);
				
				if (atbprodtext.equals(cpn))
				{
					System.out.println("Strings are equal");
					extentTest.log(Status.INFO, "The Item added to cart successfully");
				
				String delopttxt = cp.getDelveryOption();
				String yourGCtxt = cp.getYourGC();							
				System.out.println(delopttxt);
				System.out.println(yourGCtxt);
				
				if(delopttxt.equals("Delivery Options")&& yourGCtxt.equals("Deliver to"))
				   {
					extentTest.log(Status.PASS,"User is logged in and product added to cart successfully" );
				   }
				else
				   {
					extentTest.log(Status.FAIL,"Delivery options and Delivery to sections are missing in the checkout" );
				   }
			   }
			   else 
				{
				System.out.println("Strings are NOT equal");
				extentTest.log(Status.FAIL, "The selected item is not added to cart properly");				
				}		
			}
			else
			{
				
				bhp.clickCartImg();
				Thread.sleep(1000);
				String cpn = cp.getCheckoutProdName();
				System.out.println("Clicked cart image from top");

				extentTest.log(Status.INFO, "The product added to cart is: "+cpn);
				
				if (atbprodtext.equals(cpn)) {
					System.out.println("Strings are equal");
					extentTest.log(Status.INFO, "The Item added to cart successfully");
					String delopttxt = cp.getDelveryOption();
					String yourGCtxt = cp.getYourGC();							
					System.out.println(delopttxt);
					System.out.println(yourGCtxt);
					
					if(delopttxt.equals("Delivery Options")&& yourGCtxt.equals("Deliver to"))
					{
						extentTest.log(Status.PASS,"User is logged in and product added to cart successfully good to make a purchase" );
					}
					else
					{
						extentTest.log(Status.FAIL,"There is some issue observed while logging from checkout" );
					}
				} else {
					System.out.println("Strings are NOT equal");
					extentTest.log(Status.FAIL, "The selected item is not added to cart properly");
				}
			}

		
		}
		 catch(Exception e)
		 {
			 System.out.println("Oh.. No..  Caught with some error");
			 extentTest.log(Status.FAIL, "Caught with some error");
		 }
    }
}

