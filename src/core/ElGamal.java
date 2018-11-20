package core;

import java.math.BigInteger;

public class ElGamal {
	
	//following code was implemented and modified from: 
	public static long[] xgcd(long a, long b){
		long[] retvals={0,0,0};
		long aa[]={1,0}, bb[]={0,1}, q=0;
		while(true) {
    		q = a / b; a = a % b;
	    	aa[0] = aa[0] - q*aa[1];  bb[0] = bb[0] - q*bb[1];
    		if (a == 0) {
      			retvals[0] = b; retvals[1] = aa[1]; retvals[2] = bb[1];
      			return retvals;
	    	};
    		q = b / a; b = b % a;
    		aa[1] = aa[1] - q*aa[0];  bb[1] = bb[1] - q*bb[0];
	    	if (b == 0) {
    	  		retvals[0] = a; retvals[1] = aa[0]; retvals[2] = bb[0];
      			return retvals;
	    	};
    	}
    }
	
	
	public static long mulinv(long b, long n){
		
		long g = xgcd(b, n)[0];
		long x = xgcd(b, n)[1];
		if(g == 1) return x % n;
		
		return -5;
		
	}
	
	public static boolean verify(String r, String s, String m, String p, String g, String y){
		
		BigInteger BIr = new BigInteger(r);
		BigInteger BIs = new BigInteger(s);
		BigInteger BIm = new BigInteger(m);
		BigInteger BIp = new BigInteger(p);
		BigInteger BIg = new BigInteger(g);
		BigInteger BIy = new BigInteger(y);
		
		BigInteger LHS = BIg.pow(BIm.intValue()).mod(BIp);
		
		BIy = BIy.pow(BIr.intValue());
		BIr = BIr.pow(BIs.intValue());
		
		BigInteger RHS = BIy.multiply(BIr).mod(BIp);
		
		
		System.out.println(RHS + " " + LHS);
		return !(LHS.intValue() == RHS.intValue());
	}

}
