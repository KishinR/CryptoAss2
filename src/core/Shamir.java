package core;

import java.util.ArrayList;

public class Shamir{

	private ArrayList<String> stringShares;
	private Long[][] longShares;
	public static final long P = 8675309;
	
	public Shamir(){
		storeShares();
	}
	
	public long findY(int x, int [] elements){
		
		long r = 0;
		
		long [][] list = customizeArray(elements);
		
		for (int i = 0; i < list.length; i++){
			
			long xPrime = list[i][0];
			long product = list[i][1];
			
			for(int j = 0; j < list.length; j++){ 
				if(j != i){
					product = product * ((list[j][0] - x) * modInverse(list[j][0] - xPrime, P));
					product = Math.floorMod(product, P);
				}
			}
			r += product;
		}
		return Math.floorMod(r, P);
	}
	
	
	public long[][] customizeArray(int [] elements){
		
		long [][] tempList = new long [5][2];
		
		tempList [0][0] = longShares[elements[0]][0];
		tempList [0][1] = longShares[elements[0]][1];
		
		tempList [1][0] = longShares[elements[1]][0];
		tempList [1][1] = longShares[elements[1]][1];
		
		tempList [2][0] = longShares[elements[2]][0];
		tempList [2][1] = longShares[elements[2]][1];
		
		tempList [3][0] = longShares[elements[3]][0];
		tempList [3][1] = longShares[elements[3]][1];
		
		tempList [4][0] = longShares[elements[4]][0];
		tempList [4][1] = longShares[elements[4]][1];
		
		return tempList;
		
	}
	
	public void storeShares(){
		
		ReadFile rf = new ReadFile("shamir.data");
		stringShares = rf.readFile();
		
		longShares = new Long[10][2];
		
		
		
		for(int i = 0; i < stringShares.size(); i++){
			String tempString = stringShares.get(i).split(",")[0];
			String tempString2 = stringShares.get(i).split(",")[1];
			
			longShares[i][0] = Long.parseLong(tempString);
			longShares[i][1] = Long.parseLong(tempString2);
			}
		}


		
		public long modInverse(long a, long m) 
		{ 
			a = Math.floorMod(a, m);  
			//a = a % m; 
			for (int x = 1; x < m; x++) 
				if (Math.floorMod(a * x, m) == 1) 
					return x; 
			return 1; 
		} 
	
	
}