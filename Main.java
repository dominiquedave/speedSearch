/* Written by: Dave Dominique */

import java.io.*;
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors

class Pairs{
	
	int x;
	int y;
	
	public Pairs() {
		this.x = 0;
		this.y = 0;
	}
	
	public Pairs(int x, int y) {
		this.x = x;
		this.y = y;
	}
	 
	public static Pairs getCandidatePair( int A[], int target) {
		Pairs retval = new Pairs();

		int i = 0;
		int j = A.length - 1;
		
		while(i < j) {
			if(A[j] + A[i] == target) {
				retval.x = A[j];
				retval.y = A[i];
				return retval;
			}
 			else if(A[j] + A[i] < target) {
 				i++;
 			}
 			else {
 				j--;
 			}
				//System.out.print(i);
				//i++;
		}			
		return retval;
	}
	
	public static  Pairs getCandidatePairUnsorted( int A[], int target) {
		Pairs retval = new Pairs();
		
		 HashSet<Integer> s = new HashSet<Integer>();
	        for (int i = 0; i < A.length; ++i)
	        {
	            int temp = target - A[i];
	 
	            // checking for condition
	            if (s.contains(temp)) {
	                retval.y = temp;
	                retval.x = A[i];
	            }
	            s.add(A[i]);
	        }
		
		return retval;
	}
	
	
	public static void printPairs(int ss, int target, int caseNum, int arr[]) {
		 
		 Pairs pair = new Pairs();
		 
		 if(ss == 1) {
			 
			 pair = getCandidatePair(arr, target);
		 }
		 
		 else
		 {
			 pair = getCandidatePairUnsorted(arr, target);
		 }
		 
		 
		 if(pair.x == 0 && pair.y == 0) {
			 
			 System.out.println( "Test case #" + caseNum + ": Target " + target +" is NOT achievable.");
		 }
		 
		 else
			 System.out.println( "Test case #" + caseNum + ": Target " + target + " achievable by " + pair.x + " and " + pair.y );
			
	}
	
}


public class Main extends Pairs {
	
	public static void main(String[] args) throws FileNotFoundException { 
	
		File file = new File("input.txt"); //ask if the way i read in is acceptable
		Scanner myScan = new Scanner(file);
		
		int numCases = myScan.nextInt();		
	
		for(int i = 0; i < numCases; i++) {
			
			int ss =  myScan.nextInt();
			int n = myScan.nextInt();
			
			int[] arr = new int[n];
	         
			for(int j = 0; j < n; j++) {
				
				arr[j] = myScan.nextInt();
			}
			
			int target = myScan.nextInt();
			
			printPairs(ss, target, i+1 , arr); //see if this is ok??
		}
	}
}

