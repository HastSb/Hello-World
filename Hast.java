import java.util.Scanner;
public class Hast {
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
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		for (int i = 0; i <1; i++) {
			System.out.println("\tChoose a Scheduling Algorithm");
			System.out.println("[1] FCFS Algorithm");
			System.out.println("[2] Shortest Job Algorithm");
			int in=input.nextInt();
			if(in==1 || in==2) {
				System.out.println("Then How many Operations do you want?");
				operation=input.nextInt();
				int op[]=new int[operation];
				int arrival[]=new int[operation];
				for (int j = 0; j < op.length ; j++) {
					System.out.println("Burst Time for Operation "+(j+1)+ " is ?");
					op[j]=input.nextInt();
					System.out.println("And it's Arrival Time?");
					arrival[j]=input.nextInt();
				}
				if(in==1) {
					fcfs(arrival,op);
					fcfstime(arrival,op);
					System.out.println(op[0]+" "+arrival[0]);
					System.out.println(op[1]+" "+arrival[1]);
					System.out.println(op[2]+" "+arrival[2]);
				}
				if(in==2) {
					
					shortestjob(arrival,op);
					shortestjobtime(arrival,op);
					System.out.println(op[0]+" "+arrival[0]);
					System.out.println(op[1]+" "+arrival[1]);
					System.out.println(op[2]+" "+arrival[2]);
					
				}
				
	
				
		
				
				
				
			}else {
				System.out.println("Please Enter Numbers Carefully");
				i--;
				System.out.println();
				continue;
			}
			
			
			
	
	
		}
		
		
		
		
	}
	public static void fcfs(int arrival[],int op[]) {
		for (int i = 0; i < operation; i++) {
			for (int j = 0; j < operation-(i+1); j++) {
				if(arrival[j]>arrival[j+1]) {
					swap=arrival[j];
					arrival[j]=arrival[j+1];
					arrival[j+1]=swap;
					swap2=op[j];
					op[j]=op[j+1];
					op[j+1]=swap2;
				}
			}
		}
		
		
	}
	
	public static void shortestjob(int arrival[],int op[]) {
		
		for (int i = 0; i < op.length; i++) {
			
			for (int j = 0; j < operation-(i+1); j++) {
				
				if(op[j]>op[j+1]) {
					swap2=op[j];
					op[j]=op[j+1];
					op[j+1]=swap2;
					swap=arrival[j];
					arrival[j]=arrival[j+1];
					arrival[j+1]=swap;
					//System.out.println(op[j]);
				}
			}
		}
	}
public static void shortestjobtime(int arrival[],int op[]) {
	System.out.println("Operation  WaitingTime  TurnaroundTime  Start  End");
	for (int i = 0; i < op.length; i++) {
		for (int j = 0; j < op[i]; j++) {
			if (time==0) {
				time=0;
				//time=arrival[i];
			}
			if (j==0) {
				start=time;
			}
			time++;
			if ((j+1)==op[i]) {
				end=time;
			}
//////////////////////////
			if (i!=0) {
				if (((end)!=arrival[i] && end<arrival[i])&& end>arrival[i-1]) {
					//time++;
					ideal++;	
			}
			}
			
			
			

//////////////////////////
		}
		
		waiting=(time-arrival[i]);
		turnaround=waiting+arrival[i];
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
	
	public static void fcfstime(int arrival[],int op[]) {
		System.out.println("Operation  WaitingTime  TurnaroundTime  Start  End");
		for (int i = 0; i < op.length; i++) {
			for (int j = 0; j < op[i]; j++) {
				if (time==0) {
					time=0;
					//time=arrival[i];
				}
				if (j==0) {
					start=time;
				}
				time++;
				if ((j+1)==op[i]) {
					end=time;
				}
			}
			if (i==0) {
			}else 
			waiting=(time-arrival[i]);
			turnaround=end-arrival[i];
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
	

