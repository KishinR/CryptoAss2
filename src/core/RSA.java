package core;

import java.math.BigInteger;

public class RSA {
	
	
	//Brute Force method to find the factor of a number
	public static String findFactor(String num) {
		
		BigInteger n = new BigInteger (num);
		//n = n.divide(BigInteger.valueOf(2));
		
		for(BigInteger i = new BigInteger("109217167039"); i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
			
			System.out.println("iteration: " + i);
			if(n.mod(i).equals(BigInteger.ZERO)) {
				return i.toString();
			}
			
		}
		
		return "null";
	}
	
	//Given a number and a factor, function returns a second factor
	public static String findSecodFactor(String factor, String number){
		
		BigInteger num = new BigInteger (number);
		BigInteger firstFactor = new BigInteger (factor);
		
		
		BigInteger secondFactor = num.divide(firstFactor);
		return secondFactor.toString();
		
	}
	
	//function that finds phi phi(N) = (p - 1) * (q - 1)
	public static String findPhi(String p, String q){
		
		BigInteger pPrime = new BigInteger(p);
		BigInteger qPrime = new BigInteger(q);
		
		qPrime = qPrime.subtract(BigInteger.ONE);
		pPrime = pPrime.subtract(BigInteger.ONE);
		
		BigInteger phi = pPrime.multiply(qPrime);
		
		return phi.toString();
		
	}
	
	// we know that e*d = 1 mod phi(N) so to find d
	// d = e^-1 * mod phi(N)
	
	public static String findPrivateExponentD(String phi, String e){
		
		BigInteger bigIntPhi =  new BigInteger(phi);
		BigInteger bigIntE =  new BigInteger(e);
		
		
		BigInteger d = bigIntE.modInverse(bigIntPhi);
		return d.toString();
		
	}
	
	public static String partb(){
		
		int e =  3;
		BigInteger N =  new BigInteger("50565301250342921824394363370567238004631816298007440052529068601097853521050825"
				+ "102537155678633475194841545792627689259875196102779401696823597361392588180478247205669049989709634074"
				+ "92662518872571716546302284938565496949790436024850842361065179779981988163466220043511870968350972004"
				+ "90691844506811161067102443");
		
		BigInteger m =  new BigInteger("427680787658796414495478412765818481773700031964971550032485995462094541318172071"
				+ "6996786335261908310006130314643005418488822520739896308020449922303704999933498911213540554090634811017"
				+ "9242085929757960674159937269282129110422877111777667374615796784966735168125981618857480006551146095372"
				+ "3930836865732656293632");
		
		BigInteger c = m.pow(e).mod(N);
		
		return c.toString();
		
	}
	
	public static String partc(){
		
		BigInteger e = new BigInteger("179769313486231590772930519078902473361797697894230657273430081157732675805500963"
				+ "132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219"
				+ "601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716"
				+ "304835356329624224137235");
		
		
		BigInteger N =  new BigInteger("2653957477790815308776062372363498492283147449008994338561159706505696289267325974"
				+ "4109981324446309372424152466807332706936768554435302389430909293098636871804124135651713890584204736362"
				+ "7287275378041992895737394917902969620822954148050418803997890441829764379787051809840244543961639445759"
				+ "733471607073670456391");
		
		BigInteger m =  new BigInteger("1690517352192774755902318269929745175844412898463737942265499868507322572948175603"
				+ "4343982074223665505461174116338988788554653376716472750180907091708396767979198861251159982531930729182"
				+ "7649611965899446561279620094290833000580211022270963614195517284629675578909864668070831108552374275648"
				+ "786037092684278007819");
		
		
		BigInteger r = BigInteger.ONE;
		
		m = m.mod(N);
		
		while(e.compareTo(BigInteger.ZERO) > 0){
			
			if (e.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ONE) == 0){
				r = r.multiply(m).mod(N);
			}
			e = e.shiftRight(1);
			m = m.multiply(m).mod(N);
		}
		
		return r.toString();
		
	}
	

}



