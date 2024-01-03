package kraemericaIndustries.neuralnetwork;

public class App 
{
//  A simple perceptron    
	public static void main( String[] args )
    {
    	double[] x = {0, 1};	  //  Our inputs
        double[] w = {0.5, 0.5};  //  Our weights
        double b = 0.5;			  //  Our bias
        double z = 0.0;			  //  Our weighted sum
        
        for(int i =0; i < x.length; i++) {  //  SUM of PRODUCTS of INPUTS and WEIGHTS
        	z += x[i] * w[i];
        }
        
        z += b;  //  INCLUDE any bias

        double a = z > 0 ? 1.0: 0.0;  //  Our activation function... IF (z > 0), THEN (a = 0.0), ELSE (a = 1.0)
        System.out.println(a);		  //  Our output
    }
}