import java.io.*;

public class TestJNI {
  public native int add(int n1,int n2) ;
  public native int sub(int n1, int n2);
  public native int mul(int n1, int n2);
  public native int div(int n1, int n2);
  public native double sin(double n1);
  public native double cos(double n1);
  public native double log10(double n1);
  
  public static void main (String args[]) throws Exception {
    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
    System.out.println("\n Menu: \n 1.Add \n 2. sub \n 3.Mul \n 4.Div \n 5.sin \n 6.cos \n 7.Log10 \n");
    String ch=b.readLine();
    
    TestJNI tj = new TestJNI();
    int n1 = 0, n2 = 0;
    double d1 = 0;
    switch(ch)
    {
	    case "1": 
	    	System.out.println("Enter two integer numbers:");
	    	n1=Integer.parseInt(b.readLine());
	    	n2=Integer.parseInt(b.readLine());
	    	System.out.println("Addition is="+ tj.add(n1,n2)) ;
	    	break;
	    case "2": 
	    	System.out.println("Enter two integer numbers:");
	    	n1=Integer.parseInt(b.readLine());
	    	n2=Integer.parseInt(b.readLine());
	    	System.out.println("Difference is="+tj.sub(n1,n2)) ;
	    	break;
	    case "3": 
	    	System.out.println("Enter two integer numbers:");
	    	n1=Integer.parseInt(b.readLine());
	    	n2=Integer.parseInt(b.readLine());
	    	System.out.println("Product is="+tj.mul(n1,n2)) ;
	    	break;	
	    case "4": 
	    	System.out.println("Enter two integer numbers:");
	    	n1=Integer.parseInt(b.readLine());
	    	n2=Integer.parseInt(b.readLine());
	    	System.out.println("Division is="+tj.div(n1,n2)) ;
	    	break;
	    case "5": 
	    	System.out.println("Enter gradient value:");
	    	d1=Double.parseDouble(b.readLine());
	    	System.out.println("Sine is="+tj.sin(d1)) ;
	    	break;
	    case "6": 
	    	System.out.println("Enter gradient value:");
	    	d1=Double.parseDouble(b.readLine());
	    	System.out.println("Cosine is="+tj.cos(d1)) ;
	    	break;
	    case "7": 
	    	System.out.println("Enter a positive number:");
	    	d1=Double.parseDouble(b.readLine());
	    	if (d1 < 0)
	    	{
	    		System.out.println("Logarithmic value of negative number is undefined.");
	    		break;
	    	}	
	    	System.out.println("Logarithmic value (Base 10) is="+tj.log10(d1)) ;
	    	break;
	    	
    }
  }
  static {
    System.loadLibrary ( "TestJNI" ) ;
  }
}

