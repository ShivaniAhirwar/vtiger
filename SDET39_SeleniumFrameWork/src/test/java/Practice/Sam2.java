package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Sam2
{
  @Test(dataProvider="dataProvider")
  public void bookTicekts(String src,String dst)
  {
	  System.out.println("book the ticket from"+src+"to"+dst+"");
  }
  @DataProvider
  public Object[][] dataProvider()
  {
	  Object[][] obj=new Object[5][2];
	  obj[0][0]="Banglore";
	  obj[0][1]="goa";

	  obj[1][0]="Banglore";
	  obj[1][1]="manglore";

	  obj[2][0]="Banglore";
	  obj[2][1]="kerla";

	  obj[3][0]="Banglore";
	  obj[3][1]="pune";

	  obj[4][0]="Banglore";
	  obj[4][1]="noida";
	return obj;
  }

}
