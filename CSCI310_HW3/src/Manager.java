
public class Manager{
	public static final int MAX_RESOURCES = 5;
	private int availableResources = MAX_RESOURCES;
	

	public synchronized void decreaseCount(int id, int count)
	{

		while(availableResources < count) {
			try {
				
				wait();
				
			}catch (Exception e) {
			}
		}
			availableResources -= count;
	}
	// Increase availableResources by count resources
	public synchronized void increaseCount(int count)
	{
		availableResources += count;
		notify();
	}
	
	public synchronized void printResource() {
		System.out.println("Available: " + availableResources);
	}
	


	

	public static void main(String[] args) {
		
		Manager m1 = new Manager();
		
		
		
		myThread t1 = new myThread(1, m1);
		myThread t2 = new myThread(2, m1);
		myThread t3 = new myThread(3, m1);
		myThread t4 = new myThread(4, m1);
		myThread t5 = new myThread(5, m1);
		myThread t6 = new myThread(6, m1);
		myThread t7 = new myThread(7, m1);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		
		try
		{
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
			t7.join();
		} catch (Exception e) {
			System.out.println("Threads failed");
		}

	}

}

class myThread extends Thread
{
	int count = 1;
	int id;
	Manager mana;
	myThread(int id, Manager mana)
	{
		this.id = id;
		this.mana = mana;
	}
	
	public void run()
	{

			mana.decreaseCount(id, count);
			System.out.println("Thread " + id + " is starting.");
			mana.printResource();
			try{
				Thread.sleep(1000);
			}catch (Exception e) {}
			System.out.println("Thread " + id + " is done using resources");
			mana.increaseCount(count);


			
	}

}

