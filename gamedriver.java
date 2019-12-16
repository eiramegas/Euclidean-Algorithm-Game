package euclidgame;
import java.util.Scanner;
public class gamedriver {
	public static void main(String args[]) {
		int a,b,c,z; int x=1 ,y=1;
		String in;
		Scanner stdIn = new Scanner(System.in);
		a=(int) ( (Math.random()*120)+(Math.random()*30));
		b = findRelPrimeRand(a);
		System.out.println("Your Equation is:");
		z=(int)(Math.random()*500);
		c=a+b;
		System.out.println(a +"*x + " +b +"*y = "+z);
		System.out.println("x="+x +" y=" +y +"\nyou are at: "+c +"... want to get to: " +z);
		System.out.println("Possible moves (x+,x-,y+,y-)\n");
		do {
			System.out.println("Enter your move:");
			in = stdIn.next();
			if (in.equalsIgnoreCase("x+")) {
				x++;
			} else if(in.equalsIgnoreCase("y+")) {
				y++;
			}else if(in.equalsIgnoreCase("y-")) {
				y--;
			}else if(in.equalsIgnoreCase("x-")) {
				x--;
				
			}else {
				System.out.println("error try valid input");
			}
			c=a*x+b*y;
			readOut(x,y,c,z, a, b);
		}while(z != c);
	System.out.println("you got it!");
		
	}
	//	The probability that two random integers are relatively prime to one another works out to 6/pi^2 
	//  (in the limit, for large N), or approximately 61%. So generate-and-test should be a viable strategy -- 
	//	the GCD calculation is about O(log n), and you will probably get a result in 2 or 3 trials.
	
	public static int findRelPrimeRand(int a) {
		int b;
		int stopper =0;
		while(stopper<1000) {
		if(a%2 == 0) {
			b=(int) (2*((65*Math.random())+1));
		} else {
			b=(int) ((100*Math.random()+1));
		}
		if(egcd(a,b)==1) {
			return b;
		}else {
			findRelPrimeRand(a);
			stopper++;
		}
		}
		return -1;
	}
	public static int egcd(int a, int b) {
	    if (a == 0)
	        return b;

	    while (b != 0) {
	        if (a > b)
	            a = a - b;
	        else
	            b = b - a;
	    }

	    return a;
	}
	
	public static void readOut(int x,int y,int c, int z, int a, int b) {
		System.out.println("x="+x +" y=" +y +"\n"+a +"*x + " +b +"*y = " +c +"\nwant to get to: " +z);

	}
	
}
