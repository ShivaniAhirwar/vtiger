package JavaPactice;

public class BUbbleSortingAsAscOrder
{
     public static void main(String[] args)
     {
	      int [] a= {7,3,2,10,9};
	      for(int i=0;i<a.length;i++)
	      {
	    	  for(int j=i+1;j<a.length;j++)
	    	  {
	    		  if(a[i]>a[j])
	    		  {
	    		  int temp=a[i];
	    		  a[i]=a[j];
	    		  a[j]=temp;
	    		  }	   
	    		  System.out.println(a[i]);
	    	  }
	      }
	      
	      for(int k=0;k<a.length;k++)
	      {
	    	  System.out.println(a[k]);
	      }
	}
}
