import java.util.Scanner;
public class OSTest {
	static int operation;
	static int waiting=0;
	static int turnaround=0;
	static float averagewaiting=0;
	static float averageturnaround=0;
	static int time=0;
	static int end=0;
	static int start=0;
	static int swap;
	static int swap2;
	static int ideal;
	static int sum;
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <1; i++) {
			System.out.println("\tChoose a Scheduling Algorithm");
			System.out.println("[1] FCFS Algorithm");
			System.out.println("[2] Shortest Job Algorithm");
			System.out.println("[3] Round Robben Algorithm");
			int in=input.nextInt();

			if(in==1 || in==2 || in==3) {
				System.out.println("Then How many Operations do you want?");
				operation=input.nextInt();
				int array[][]=new int [9][operation];
				//int op[]=new int[operation];
				//int arrival[]=new int[operation];
				for (int j = 0; j < array[0].length ; j++) {
					System.out.println("Burst Time for Operation "+(j+1)+ " is ?");
					array[0][j]=input.nextInt();
					sum=sum+array[0][j];
					System.out.println("And it's Arrival Time?");
					array[1][j]=input.nextInt();
				}
				if(in==1) {
					SwapArrival(array);
					
					fcfstime(array);
					System.out.println(array[0][0]+" "+array[1][0]);
					System.out.println(array[0][1]+" "+array[1][1]);
					System.out.println(array[0][2]+" "+array[1][2]);
				}
				if(in==2) {
					SwapBurst(array);
					
					shortestjobtime(array);
					System.out.println(array[0][0]+" "+array[1][0]);
					System.out.println(array[0][1]+" "+array[1][1]);
					System.out.println(array[0][2]+" "+array[1][2]);
					
				}
				if(in==3) {
					
					System.out.println("How Much is Your Time Quantum?");
					int TimeQ=input.nextInt();
					//SwapArrival(array);
					RRTime(array,TimeQ);
					
					
					
				}
				
	
				
		
				
				
				
			}else {
				System.out.println("Please Enter Numbers Carefully");
				i--;
				System.out.println();
				continue;
			}
			
			
			
	
	
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
	

	
	public static void RRTime(int array[][],int TimeQ) {
		System.out.println("Operation  WaitingTime  TurnaroundTime  Start  End");
		
		int count=0;
		
		for (int i = 0; i < array[0].length; i++) {
			array[8][i]=array[0][i];
			if (array[8][i]%TimeQ==0) {
				array[7][i]=1;
			}
		}
		for (int i = 0; i < 1; i++) {
			
			for (int j = 0; j < array[0].length; j++) {
				
				if(array[8][j]!=0) {
					if (i==0) {
						array[5][j]=time;
					}
					if(array[8][j]>=TimeQ) {
						array[8][j]=(array[8][j]-TimeQ);
						time+=(TimeQ);
						array[3][j]+=TimeQ;
						
					}else if(array[8][j]<TimeQ && array[8][j]!=0) {
						time+=(array[8][j]%TimeQ);
						array[3][j]+=(array[8][j]%TimeQ);
						array[8][j]=0;
					}
					
					if(array[8][j]==0) {
						 
						array[4][j]=99;
						count++;
						array[6][j]=time;
						
					}
					
				}
				if(count!=operation && (j+1==array[0].length)) {
				j=-1;	
				}else if(count==operation) 
				{
				break;	
				}
				
				
				
			}
			
			if(count==operation) {
				break;
			}
			
		}
		
		for (int i = 0; i < array[0].length; i++) {
			
			waiting=(array[6][i]-array[0][i])-array[1][i];
			turnaround=array[0][i] + waiting;
			
			averagewaiting+=waiting;
			averageturnaround+=turnaround;
			System.out.println("P"+(i+1)+ "\t \t"+waiting+"\t \t"+turnaround+"\t "+array[5][i]+""+array[6][i]);
		}
		
		
		
		
		
		System.out.println("Average Waiting Time = "+(averagewaiting/operation)+" Seconds");
		System.out.println("Average Turnaround Time = "+(averageturnaround/operation)+" Seconds");
		System.out.println("Whole Time was "+time+" Seconds");
		System.out.println("Ideal Time was = "+ideal);
		System.out.println();
		System.out.println("All Time was ="+time);
		
		
	}
	
	
	
	
	
	
public static void shortestjobtime(int array[][]) {
	System.out.println("Operation  WaitingTime  TurnaroundTime  Start  End");
	
	int count=0;
	int tempcount=0;
	for (int i = 0; i < array[0].length; i++) {
		for (int k = 0; k < operation-(i+1); k++) {
			
			if(array[1][k]<array[1][k+1]) {
				count++;
			}
			if(count==operation) {
				array[2][k]=array[1][k];
				for (int j = 0; j < array.length; j++) {
					if (array[1][j]>array[2][k]) {
				tempcount++;	
				}
				}
				
			
		}
			if (!(tempcount>0)) {
				continue;
				
			}
			
			
		}

		
		
		
		for (int j = 0; j < array[0][i]; j++) {
			if (j==0) {
				for (int j2 = 0; j2 < array[2].length; j2++) {
					if (time==0) {
					time=0;
					//time=arrival[i];
				}
				if (j==0) {
					start=time;
				}
				time++;
				if ((j+1)==array[0][i]) {
					end=time;
				}
	
				}
				
			}else {
				
			}
			
			
		}
		
		waiting=(time-array[1][i]);
		turnaround=waiting+array[1][i];
		averagewaiting+=waiting;
		averageturnaround+=turnaround;
		System.out.println("P"+(i+1)+ "\t \t"+waiting+"\t \t"+turnaround+"\t  "+start+"\t"+end);
		
	}
	System.out.println("Average Waiting Time = "+(averagewaiting/operation)+" Seconds");
	System.out.println("Average Turnaround Time = "+(averageturnaround/operation)+" Seconds");
	System.out.println("Whole Time was "+time+" Seconds");
	System.out.println("Ideal Time was = "+ideal);
	System.out.println();
		
	}
	
	public static void fcfstime(int array[][]) {
		System.out.println("Operation  WaitingTime  TurnaroundTime  Start  End");
		for (int i = 0; i < array[0].length; i++) {
			for (int j = 0; j < array[0][i]; j++) {
				if (time==0) {
					time=0;
					//time=arrival[i];
				}
				if (j==0) {
					start=time;
				}
				time++;
				if ((j+1)==array[0][i]) {
					end=time;
				}
			}
			if (i==0) {
			}else 
			waiting=(time-array[1][i]);
			turnaround=end-array[1][i];
			averagewaiting+=waiting;
			averageturnaround+=turnaround;
			System.out.println("P"+(i+1)+ "\t \t"+waiting+"\t \t"+turnaround+"\t  "+start+"\t"+end);
			
		}
		System.out.println("Average Waiting Time = "+(averagewaiting/operation)+" Seconds");
		System.out.println("Average Turnaround Time = "+(averageturnaround/operation)+" Seconds");
		System.out.println("Whole Time was "+time+" Seconds");
		System.out.println();
	}	
		
	}
	

/* 
[0] Burst 
[1] Arrival
[2]
[3] Time for every Operation
[4] Code 1000001 for knowing who is done and who is not
[5] Start Time
[6] End Time
[7] Seperating by using %
[8] Copying Burst Times into it
*/