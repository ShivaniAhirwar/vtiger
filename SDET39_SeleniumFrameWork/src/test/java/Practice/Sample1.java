package Practice;

import org.testng.annotations.Test;

public class Sample1
{
    @Test(priority=3)
    public void deleteContact()
    {
    	System.out.println("delete contact");
    }

    @Test(priority=-1)
    public void createContact()
    {
    	System.out.println("create contact");
    }
}
