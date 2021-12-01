import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Handling2 {

	public static void main(String[] args) throws IOException {
		

		
				BufferedReader stdin1 = new BufferedReader ( new InputStreamReader( System.in ) );
						String inData1;
						int data=0, slot=0 ;
						int[] value = new int[10];
						
						try {
							System.out.println("Enter the data:");
							inData1 = stdin1.readLine();
							data = Integer.parseInt( inData1 );
							System.out.println("Enter the array index:");
							inData1 = stdin1.readLine();
							slot = Integer.parseInt( inData1 );
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
