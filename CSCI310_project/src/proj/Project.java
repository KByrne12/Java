package proj;

import java.util.Random;



public class Project {
	
	
	

	public static void main(String[] args) {
		
		Random rand = new Random();		
		int UPPERBOUND = 10;
		
		
		int numberOfCustomers = rand.nextInt(UPPERBOUND) + 1;
		int numberOfResources = rand.nextInt(UPPERBOUND) + 1;
		
		
		int[] available = new int[numberOfResources];							//available amount of each resource
		int[][] maximum = new int[numberOfResources][numberOfCustomers];  		//max demand of each customer
		int[][] allocation = new int [numberOfResources][numberOfCustomers];	//amount each customer holds
		
		int[][] need = new int[numberOfResources][numberOfCustomers];			//remaining needs of each customer
		
		MyBank[] customers = new MyBank[numberOfCustomers];
		
		
		for (int i = 0; i < numberOfCustomers; i++)
		{
			
			customers[i] = new MyBank(i,need,allocation,maximum); 
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
