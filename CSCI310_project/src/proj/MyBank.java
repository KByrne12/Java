package proj;


//grabbed the bank class from textbook as a starting grounds, will need to be updated
public class MyBank extends Thread{
	
	
	public void addCustomer(int customerNum,int[] maximumDemand)
	{
	
	}
	
	
	public void getState()
	{
		System.out.print("[");
		For(int i = 0; i < available; i++)
		{
			System.out.print (available[i] + ",");
		}
		System.out.println("]");
		
	}
	//only says true to get rid of the red line
	
	public boolean requestResources(int customerNum, int[] request)
	{
		return true;
	}
	
	
	public void releaseResources(int customerNum, int[] release)
	{
		
	}
	
	
}
