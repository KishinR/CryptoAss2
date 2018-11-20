package core;

import java.util.ArrayList;

public class MainClass {

	public static void main(String[] args) {

		
		//Question 3
		
		Shamir sham = new Shamir();
		
		//Part A
		int [] list = {0, 1, 2, 3, 4};
		int [] list2 = {1, 2, 3, 4, 5};
		int [] list3 = {2, 3, 4, 5, 6};
		int [] list4 = {3, 4, 5, 6, 7};
		int [] list5 = {4, 5, 6, 7, 8};
		int [] list6 = {5, 6, 7, 8, 9};
		
		System.out.println("list1: " + sham.findY(0, list));
		System.out.println("list2: " + sham.findY(0, list2));
		System.out.println("list3: " + sham.findY(0, list3));
		System.out.println("list4: " + sham.findY(0, list4));
		System.out.println("list5: " + sham.findY(0, list5));
		System.out.println("list6: " + sham.findY(0, list6));
		
		//Part B
		System.out.println("The Y value for 1234: " + sham.findY(1234, list));
		
		
		//Part C
		ArrayList<Integer> xValues = new ArrayList<Integer>();
		for(int i = 0; i < Shamir.P; i++){
			//System.out.println(i);
			if(sham.findY(i, list) == 123456){
				xValues.add(new Integer(i));
			}
		}
		
		for (int i = 0; i < xValues.size(); i++){
			System.out.println("X" + "[" + i + "] value is: "  + xValues.get(i));
		}
		System.out.println("There are: " + xValues.size() + " values of X");
	}
}




