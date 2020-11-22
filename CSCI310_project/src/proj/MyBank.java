package proj;


//grabbed the bank class from textbook as a starting grounds, will need to be updated
public class MyBank extends Thread{
	
	int id;
	int[][] requested;
	int[][] allocation;
	int[][] maximum;

	
	MyBank(int id,int[][] requested,int[][] allocation, int[][]maximum)
	{
		this.id = id;
		this.requested = requested;
		this.allocation = allocation;
		this.maximum = maximum;
	}
	
	
	public void getState()
	{
		System.out.println("Available: ");
		System.out.print("[");
		for(int i = 0; i < available.length; i++)
		{
			System.out.print (available[i] + ",");
		}
		System.out.println("]");
		
		System.out.println("Maximum:");
		for(int i = 0; i<maximum.length;i++)
		{
			for(int j = 0; j<maximum[i].length;j++)
			{

			System.out.print("[");
			System.out.print(maximum[i][j] + ",");
			System.out.println("]");
			}
		}
		System.out.println("Allocation:");
		for(int i = 0; i<allocation.length;i++)
		{
			for(int j = 0; j<allocation[i].length;j++)
			{

			System.out.print("[");
			System.out.print(allocation[i][j] + ",");
			System.out.println("]");
			}
		}
		
	}
	//only says true to get rid of the red line
	
	public synchronized void requestResources(int id, int[][] requested)
	{
		boolean cont = true;
		while (cont == false) {
		cont = true;
		for (int i = 0; i < requested[id].length; i++)
		{
			if (requested[id][i] > available[i])
			{
				cont = false;
			}
		}
		}
		if (cont == true)
		{
			for (int i = 0; i < requested.length; i++)
			{
				available[i] -= requested[id][i];
			}
		}
	}
	
	
	public void releaseResources(int id, int[][] allocation)
	{
		for (int i = 0; i < allocation.length; i++)
		{
			available[i] += allocation[id][i];
		}
		
	}
	
	
	
	public void run() 
	{
		System.out.println(id);
		getState();

		requestResources(id, requested);
		requestResources(id,requested);
		requestResources(id,requested);
		releaseResources(id, requested);
		
	}
	
	
}
