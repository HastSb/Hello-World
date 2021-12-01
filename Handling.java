import java.io.* ;
public class Handling {
public static void main(String args[]) throws IOException{
	
	
	BufferedReader stdin = new BufferedReader ( new
			InputStreamReader( System.in ) );
			String inData = null;
			int num = 0; boolean goodData = false;
	while( !goodData ) {
		System.out.println("Enter an integer:");
		inData = stdin.readLine();
		try {
		num = Integer.parseInt( inData );
		goodData = true;
		}
		catch (NumberFormatException ex ) {
		System.out.println("Bad data, try again. n" );
		}
		}
		System.out.print("The square of "+ inData+" is "+ num*num );
	
		System.out.println();
		BufferedReader stdin1 = new BufferedReader ( new
				InputStreamReader( System.in ) );
				String inData1;
				int data=0, slot=0 ;
				int[] value = new int[10];
				
				try {
					System.out.println("Enter the data:");
					inData = stdin.readLine();
					data = Integer.parseInt( inData );
					System.out.println("Enter the array index:");
					inData = stdin.readLine();
					slot = Integer.parseInt( inData );
					value[slot] = data;
					} catch (NumberFormatException ex ) {
					System.out.println("This is your problem: " +
					ex.getMessage() + " \nHere is where it happened:");
					ex.printStackTrace();
					}
					catch (IndexOutOfBoundsException ex ) {
					System.out.println("This is your problem: " +
					ex.getMessage() + " nHere is where it happened:");
					ex.printStackTrace();
					ex.printStackTrace();
					} 
				}

	
	

}
