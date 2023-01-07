package Practice;

import java.util.ArrayList;
import java.util.Collections;


public class collections
{
  public static void main(String[] args)
  {
//	  ArrayList<Object> list=new ArrayList<Object>();
//	  list.add(10);
//	  list.add('A');
//	  list.add("hello");
//	  list.add(null);
//	  list.add(2,"Hyy");
//	  System.out.println(list);
	  
	  ArrayList<Integer> list2=new ArrayList<Integer>();
	  list2.add(10);
	  list2.add(30);
	  list2.add(20);
	  list2.add(null);
	  list2.add(10);
	  Collections.sort(list2);
	  for(Integer integer:list2)
	  {
		  System.out.println(integer);
	  } 
	  
  }
}
