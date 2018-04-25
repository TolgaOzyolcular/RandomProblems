import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  When finding roots, typically we use a quadratic equation: x = (b +- sqrt((b^2) - 4ac)) / 2a
 *  
 *  This is the equation we will be applying to all the equations in order to find the root
 *  where x is the roots of the equation. This will be applied to a*(x^2) + (b*x) + c.
 *  
 *  *Note* This will not apply for imaginary numbers. I'm not sure if you've learned those yet, but 
 *  they will require a different logic.
 *  
 *  This will also only work
 *  
 */

public class RootFinder {
	public static void main (String[] args) {
		
		// Below I am declaring the variables for the quadratic equation. 
		// They are represented as such: a*(x^2) + (b*x) + c
		// Where x is the unknown variable.
		
		int a;
		int b;
		int c;
		double root1;
		double root2;
		
		// Below I am creating a BufferedReader in order to input the data.
		System.out.println("\nPlease enter your equation below: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuffer sb = new StringBuffer();
		
		try {
			String input = br.readLine();
			
			input = input.replaceAll("[\\^\\(\\)\\*\\s]", "");
			
			Pattern p = Pattern.compile("([+-]?\\d+)x2([+-]?\\d+)x([+-]?\\d+)");
			Matcher m = p.matcher(input);
			
			if(m.matches()) {
				a = Integer.parseInt(m.group(1));
		        b = Integer.parseInt(m.group(2));
		        c = Integer.parseInt(m.group(3));
				
		        if(b>0 && c>0)
		        		System.out.println("\nYour equation is: " + a + "(x^2) + " + b + "x + " + c);
		        
		        else if(b<0 && c>0)
		        		System.out.println("\nYour equation is: " + a + "(x^2) - " + Math.abs(b) + "x + " + c);
		        
		        else if(b>0 && c<0)
	        			System.out.println("\nYour equation is: " + a + "(x^2) + " + b + "x - " + Math.abs(c));
		        
		        else if(b<0 && c<0)
	        			System.out.println("\nYour equation is: " + a + "(x^2) - " + Math.abs(b) + "x - " + Math.abs(c));
				
				// Below I am calculating what the 2 roots of the equation are equal to.
				// root1 is the addition variant, and root2 is the subtraction variant.
				
				root1 = ((b + (Math.sqrt((Math.pow(b,2)) - (4*a*c)))) / (2*a));	
				root2 = ((b - (Math.sqrt((Math.pow(b,2)) - (4*a*c)))) / (2*a));
				
				// Below I am checking to see if the roots are equal to imaginary numbers. This results 
				// when a square root is taken of a negative number! 
				// *Note* NaN stands for "Not a Number".
				
				if(Double.isNaN(root1) || Double.isNaN(root2)) {
					System.out.println("\nThe roots equate to imaginary numbers. Please try a different input!");
				}
				else {
					System.out.println("\nThe roots are: x = " + root1 + " & x = " + root2);
				}
			}

		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
