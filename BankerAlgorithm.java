import java.util.Scanner;
public class BankerAlgorithm {
static int operation;
static int sum[]=new int[3];
static int available[]=new int [3];
							//Test
/*
 * [0] Allocated for A
 * [1] Allocated for B
 * [2] Allocated for C
 * [3] Need for A
 * [4] Need for B
 * [5] Need for C
 * [6] an code for Checking Operation if it is done or not
 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("How Many Operations You Have?");
		operation =in.nextInt();
		int array[][]=new int [7][operation];
		short deadlock=0;
		while(true) {
			System.out.println();
			System.out.println("Please Enter Number of instances Per Source\n");
			System.out.println("Max Number of Resource instances of Type A");
			int maxA=in.nextInt();
			System.out.println("Max Number of Resource instances of Type B");
			int maxB=in.nextInt();
			System.out.println("Max Number of Resource instances of Type C");
			int maxC=in.nextInt();
			int show[]= {maxA,maxB,maxC};
		for (int i = 0; i < operation; i++) {
			
			System.out.println("Enter Allocated Resource A For Operation "+(i+1));
			array[0][i]=in.nextInt();
			System.out.println("Enter Allocated Resource B For Operation "+(i+1));
			array[1][i]=in.nextInt();
			System.out.println("Enter Allocated Resource C For Operation "+(i+1));
			array[2][i]=in.nextInt();
			
			/*if((show[0]-array[0][i])<0 || (show[1]-array[1][i])<0 || (show[2]-array[2][i])<0) {
				System.out.println("Please Enter Carefully You Entered Resources More Than Max");
				i--;
			}else {}
			*/
			show[0]-=array[0][i];
			show[1]-=array[1][i];
			show[2]-=array[2][i];
			System.out.println("Be Careful You Now Have left:");
			System.out.println("A = "+show[0]+"\tB = "+show[1]+"\tC = "+show[2]);
			System.out.println();
				
		}
		for (int i = 0; i < array[0].length; i++) {
			sum[0]+=array[0][i];
			sum[1]+=array[1][i];
			sum[2]+=array[2][i];
		}
		if(maxA>=sum[0] && maxB>=sum[1] && maxC>=sum[2]) {
			available[0]=maxA-sum[0];
			available[1]=maxB-sum[1];
			available[2]=maxC-sum[2];
				System.out.println("*************");
				System.out.println("  Available  ");
				System.out.println("_____________");
				System.out.println("A     B     C");
				System.out.println((maxA-sum[0])+"     "+(maxB-sum[1])+"     "+(maxC-sum[2]));
				
			
		} else {
			if(sum[0]>maxA) {
		
			System.out.println("DeadLocked The Allocated Resource of A is More Than Max A in The System");
			deadlock=1;
		
		}if(sum[1]>maxB) {
			System.out.println("DeadLocked The Allocated Resource of B is More Than Max B in The System");
			deadlock=1;
		
		}if(sum[2]>maxC) {
			System.out.println("DeadLocked The Allocated Resource of C is More Than Max C in The System");
			deadlock=1;
		
		}
		break;
		}
		
		System.out.println("Now Enter Needed Resources For Operations");
		for (int i = 0; i < operation; i++) {
			System.out.println("Enter Need Resource A For Operation "+(i+1));
			array[3][i]=in.nextInt();
			System.out.println("Enter Need Resource B For Operation "+(i+1));
			array[4][i]=in.nextInt();
			System.out.println("Enter Need Resource C For Operation "+(i+1));
			array[5][i]=in.nextInt();
			
		}
		
		System.out.println("Enter Process Number");
		int request=in.nextInt();
		System.out.println("Enter Needed for Resource A");
		int reqA=in.nextInt();
		System.out.println("Enter Needed for Resource B");
		int reqB=in.nextInt();
		System.out.println("Enter Needed for Resource C");
		int reqC=in.nextInt();
		array[request-1][3]+=reqA;
		array[request-1][4]+=reqB;
		array[request-1][5]+=reqC;
		

		}
		int count=0;
		int iteration=0;
		int test=0;
		
		System.out.println();
		if(deadlock == 0) {
			for (int i = 0; i < array[0].length; i++) {
				
				if(array[6][i]==0) {
					
					if((available[0]>=array[3][i]) && (available[1]>=array[4][i]) && (available[2]>=array[5][i])) {
						available[0]+=array[0][i];
						available[1]+=array[1][i];
						available[2]+=array[2][i];
						array[6][i]=(i+1);
						
						count++;
						
					}else if(iteration==0){
						test++;
					}
					if(test==operation) {
						System.out.println("Unfortunately DeadLock Occured without executed any Process");
						deadlock=1;
						break;
					}
					
				}else {
					
					if(count==operation) {
						break;
					}
					if(i==(operation-1)) {
						i=-1;
						iteration++;
						
						if(iteration==((2*operation))) {
						System.out.println("\t Your System is Deadlocked :(");
						deadlock=1;
						break;
						
						}
						
					}
					
				}
				
				
				
			}
			
		}
		
		
		if(deadlock==0) {
			System.out.println("The Request Can be Granted");
			System.out.println("The System is in Safe State and The Sequence is... ");
		for (int i = 0; i < array[0].length; i++) {
			
			System.out.print("P"+array[6][i]+"  ");
		}
			
		}
		
	}

}
