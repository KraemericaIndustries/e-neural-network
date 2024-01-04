package kraemericaIndustries.neuralnetwork;

public class App {

	static double neuron(double[] x, double[] w, double b) {  //  x = inputs, w = weights, b = bias

		double z = 0.0;  //  Our weighted sum

		for (int i = 0; i < x.length; i++) {  //  SUM of PRODUCTS of INPUTS and WEIGHTS
			z += x[i] * w[i];
		}

		z += b;  //  INCLUDE any bias
		return z > 0 ? 1.0 : 0.0;  //  Our activation function... IF (z > 0), THEN (a = 0.0), ELSE (a = 1.0)
	}

	static double and(double x1, double x2) {
    	//  RETURN the result of INVOKING neuron()
		//  ARGUMENTS for neuron() are inputs of x1 & x2, weights[] of 1 & 1, and a bias that achieves the desired result of an AND gate: 
		return neuron(new double[] {x1, x2}, new double[] {1, 1}, -1);  
	}
	
	static double or(double x1, double x2) {
    	//  RETURN the result of INVOKING neuron()
		//  ARGUMENTS for neuron() are inputs of x1 & x2, weights[] of 1 & 1, and a bias that achieves the desired result of an OR gate: 
		return neuron(new double[] {x1, x2}, new double[] {1, 1}, 0);  
	}
	
	static double xor(double x1, double x2) {
    	//  RETURN the result of INVOKING neuron()
		//  ARGUMENTS for neuron() are inputs of x1 & x2, weights[] of 1 & 1, and a bias that achieves the desired result of an XOR gate
		//  XOR is achieved by ANDing the results of OR and NAND:
		return and(or(x1, x2), nand(x1, x2));  
	}
	
	static double nor(double x1, double x2) {
    	//  RETURN the result of INVOKING neuron()
		//  ARGUMENTS for neuron() are inputs of x1 & x2, weights[] of 1 & 1, and a bias that achieves the desired result of an NOR gate: 
		return neuron(new double[] {x1, x2}, new double[] {-1, -1}, 1);  
	}
	
	static double nand(double x1, double x2) {
    	//  RETURN the result of INVOKING neuron()
		//  ARGUMENTS for neuron() are inputs of x1 & x2, weights[] of 1 & 1, and a bias that achieves the desired result of an NAND gate: 
		return neuron(new double[] {x1, x2}, new double[] {-1, -1}, 2);  
	}
	
	static double xnor(double x1, double x2) {
    	//  RETURN the result of INVOKING neuron()
		//  ARGUMENTS for neuron() are inputs of x1 & x2, weights[] of 1 & 1, and a bias that achieves the desired result of an XNOR gate
		//  XNOR is achieved by ORing the results of AND and NOR:
		return or(and(x1, x2), nor(x1, x2));  
	}

	public static void main(String[] args) {

		System.out.println("AND:");
		for(int i = 0; i < 4; i++) {  //  ITERATE over all possible combinations for 2 inputs...
			double x1 = i/2;		  //  The next 2 lines achieve the possible input combinations of 00, 01, 10, 11
			double x2 = i%2;
			double output = and(x1, x2);  //  INVOKE and()... first iteration x1 = 0, x2 = 0...
			
			System.out.printf("%d%d\t%d\n", (int)x1, (int)x2, (int)output);  //  Our output.  (%d = integer), (\t = tab), (\n = newline).  Doubles x1, x2, output are cast to ints  
		}
		System.out.println();
		
		System.out.println("OR:");
		for(int i = 0; i < 4; i++) {  //  ITERATE over all possible combinations for 2 inputs...
			double x1 = i/2;		  //  The next 2 lines achieve the possible input combinations of 00, 01, 10, 11
			double x2 = i%2;
			double output = or(x1, x2);  //  INVOKE or()... first iteration x1 = 0, x2 = 0...

			System.out.printf("%d%d\t%d\n", (int)x1, (int)x2, (int)output);  //  Our output.  (%d = integer), (\t = tab), (\n = newline).  Doubles x1, x2, output are cast to ints  
		}
		System.out.println();
		
		System.out.println("XOR:");
		for(int i = 0; i < 4; i++) {  //  ITERATE over all possible combinations for 2 inputs...
			double x1 = i/2;		  //  The next 2 lines achieve the possible input combinations of 00, 01, 10, 11
			double x2 = i%2;
			double output = xor(x1, x2);  //  INVOKE xor()... first iteration x1 = 0, x2 = 0...

			System.out.printf("%d%d\t%d\n", (int)x1, (int)x2, (int)output);  //  Our output.  (%d = integer), (\t = tab), (\n = newline).  Doubles x1, x2, output are cast to ints  
		}
		System.out.println();		
		
		
		System.out.println("NOR:");
		for(int i = 0; i < 4; i++) {  //  ITERATE over all possible combinations for 2 inputs...
			double x1 = i/2;		  //  The next 2 lines achieve the possible input combinations of 00, 01, 10, 11
			double x2 = i%2;
			double output = nor(x1, x2);  //  INVOKE nor()... first iteration x1 = 0, x2 = 0...

			System.out.printf("%d%d\t%d\n", (int)x1, (int)x2, (int)output);  //  Our output.  (%d = integer), (\t = tab), (\n = newline).  Doubles x1, x2, output are cast to ints  
		}
		System.out.println();
		
		System.out.println("NAND:");
		for(int i = 0; i < 4; i++) {  //  ITERATE over all possible combinations for 2 inputs...
			double x1 = i/2;		  //  The next 2 lines achieve the possible input combinations of 00, 01, 10, 11
			double x2 = i%2;
			double output = nand(x1, x2);  //  INVOKE nand()... first iteration x1 = 0, x2 = 0...

			System.out.printf("%d%d\t%d\n", (int)x1, (int)x2, (int)output);  //  Our output.  (%d = integer), (\t = tab), (\n = newline).  Doubles x1, x2, output are cast to ints  
		}
		System.out.println();
		
		
		System.out.println("XNOR:");
		for(int i = 0; i < 4; i++) {  //  ITERATE over all possible combinations for 2 inputs...
			double x1 = i/2;		  //  The next 2 lines achieve the possible input combinations of 00, 01, 10, 11
			double x2 = i%2;
			double output = xnor(x1, x2);  //  INVOKE and()... first iteration x1 = 0, x2 = 0...

			System.out.printf("%d%d\t%d\n", (int)x1, (int)x2, (int)output);  //  Our output.  (%d = integer), (\t = tab), (\n = newline).  Doubles x1, x2, output are cast to ints  
		}
	}
}