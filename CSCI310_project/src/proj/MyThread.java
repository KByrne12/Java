package proj;

public class MyThread extends Thread{

	int id;
	int[] requested;

	
	MyThread(int id,int[] requested)
	{
		this.id = id;
		this.requested = requested;
	}
	
	MyBank banking = new MyBank(id,);
	
	public void run() 
	{
		System.out.println(id);
		banking.getState();
		banking.requestResources(customerNum, requested);
		banking.releaseResources(customerNum, release);
		
	}
}
