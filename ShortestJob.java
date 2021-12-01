import java.util.Iterator;
import java.util.Scanner;

public class ShortestJob {
static int operation;
static int swap2;
static int time;
static int start;
static int end;
static int waiting=0;
static int turnaround=0;
static float averagewaiting=0;
static float averageturnaround=0;
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		

			
				System.out.println("Then How many Operations do you want?");
				operation=input.nextInt();
				int array[][]=new int [9][operation];
				//int op[]=new int[operation];
				//int arrival[]=new int[operation];
				for (int j = 0; j < array[0].length ; j++) {
					System.out.println("Burst Time for Operation "+(j+1)+ " is ?");
					array[0][j]=input.nextInt();
				
					System.out.println("And it's Arrival Time?");
					array[1][j]=input.nextInt();
				}
				
				
				SwapArrival(array);
				
				int ar[]=new int[2];
				ar[1]=array[1][0];
				ar[0]=array[0][0];
				
				int alert=0;
				SwapBurst(array);
				for (int i = 0; i < array[0].length; i++) {
					if (array[1][0]<array[1][i]) {
						alert++;
					}
				}
				System.out.println("alert "+alert);
				System.out.println("Hast"+ar[0]);
				System.out.println("Hast"+ar[1]);
				System.out.println("Operation  WaitingTime  TurnaroundTime  Start  End");
				int test=0;
				for (int i = 0; i < array[0].length; i++) {
					
					if (test==0) {
						start=time;
						test=1;
					}
					
					if(!((ar[0]==array[0][i])&&(ar[1]==array[1][i])) && alert==0) 
					{
							start=time;	
							
						time+=array[0][i];
						end=time;
						System.out.println("Step 1");
				
						
					}else {
						System.out.println("Step 2");
						start=time;	
						time+=ar[0];
						alert=0;
						end=time;	
					}
						
					waiting=(time-array[1][i]);
					turnaround=waiting+array[0][i];
					
					averagewaiting+=waiting;
					averageturnaround+=turnaround;
					System.out.println("P"+(i+1)+ "\t \t"+waiting+"\t \t"+turnaround+"\t "+start+"\t"+end);	
					
				}
		
				
		
	}
public static void SwapArrival(int array[][]) {
		
		for (int i = 0; i < array[0].length; i++) {
					
					for (int j = 0; j < operation-(i+1); j++) {
						
						if(array[1][j]>array[1][j+1]) {
							swap2=array[0][j];
							array[0][j]=array[0][j+1];
							array[0][j+1]=swap2;
							swap2=array[1][j];
							array[1][j]=array[1][j+1];
							array[1][j+1]=swap2;
						}
					}
				}
			}

public static void SwapBurst(int array[][]) {
	for (int i = 0; i < array[0].length; i++) {
		
		for (int j = 0; j < operation-(i+1); j++) {
			
			if(array[0][j]>array[0][j+1]) {
				swap2=array[0][j];
				array[0][j]=array[0][j+1];
				array[0][j+1]=swap2;
				swap2=array[1][j];
				array[1][j]=array[1][j+1];
				array[1][j+1]=swap2;
			}
		}
	}
}

}
