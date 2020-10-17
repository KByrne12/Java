package search;

public class BinarySearch {
	
	int binarySearch(int array[], int low, int high, int val)
	{
		//returns position of desired value.
		
		if(high >= 1) 
		{
			int currentVal = low +(high-1);
		
		
			if(array[currentVal] == val) 
			{
				return currentVal;
			}
			if(array[currentVal] > val)
			{
				return binarySearch(array,currentVal+1,high,val);
			}
			if(array[currentVal] < val)
			{
				binarySearch(array,low,currentVal-1,val);
			}
		}
		return -1;
	}

}
