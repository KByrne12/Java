package proj;

public class MyThread extends Thread{

	int id;
	
	MyThread(int id)
	{
		this.id = id;
	}
	
	public void run() 
	{
		System.out.println(id);
	}
}
