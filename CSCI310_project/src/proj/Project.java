package proj;

import java.util.Random;



public class Project {
	
	
	

	public static void main(String[] args) {
		
		Random rand = new Random();		
		int UPPERBOUND = 10;
		
		
		int numberOfCustomers = rand.nextInt(UPPERBOUND) % UPPERBOUND + 1;
		int numberOfResources = rand.nextInt(UPPERBOUND) % UPPERBOUND + 1;
		
		int[] available;
		int[][] maximum;
		int[][] allocation;
		
		int[][] need;
		
		MyThread[] customers;
		
		
		for (int i = 0; i < numberOfCustomers; i++)
		{
			customers[i] = new MyThread(i); 
		}
		for (int i = 0; i < numberOfCustomers; i++)
		{
			customers[i].start();
		}
		
		try {
			for(int i = 0; i < numberOfCustomers; i++)
			{
				customers[i].join();
			}
		}
		catch (InterruptedException e) {}
	}

}