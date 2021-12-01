import java.io.* ;
public class Handling3 {

	public static void main(String[] args) throws IOException{
		
		
		
		
		
		
		{ BufferedReader stdin = new BufferedReader ( new
		InputStreamReader( System.in ) );
		String inData; int num ;
		System.out.println("Enter an integer:");
		inData = stdin.readLine();
		num = Integer.parseInt( inData );
		System.out.println("The square of " + inData + " is " +
		num*num );
		 }
		
	

	}

}
