package ppTung.lab4;

import java.util.Date;
import java.util.Random;

public class MatrixMultiplication extends Thread {
	int[][] matrix1, matrix2, resultMatrix;
	int rowNumber,quantity;
	public MatrixMultiplication(int[][] m1, int [][] m2, int[][] result, int row, int q){
		matrix1=m1;
		matrix2=m2;
		resultMatrix=result;
		rowNumber=row;
		quantity=q;
	}
	public void run() {
		int size= matrix1[0].length;
		for(int k=0; k<quantity;k++) {
			for(int i=0;i<resultMatrix[0].length;i++) {
				int sum=0;
				for(int j=0;j<size;j++) {
					sum+= matrix1[rowNumber+k][j]*matrix2[j][i];
				}
				resultMatrix[rowNumber+k][i]=sum;
			}
		}
	}
	public static int[][] Multiplication(int[][] m1, int [][] m2, int quatityOfThreads) throws InterruptedException{
		if(checkMatrices(m1,m2)) {
			int a=m1.length;
			int b=m2[0].length;
			int [][] result=new int[a][b];
			int n= a/quatityOfThreads;
			int remainder = a%quatityOfThreads;
			int[] quatity=new int[quatityOfThreads];
			for(int i=0;i<quatityOfThreads;i++) {
				quatity[i]=n;
				if(remainder>0) {
					quatity[i]++;
					remainder--;
				}
			}
			Thread [] multiplethreads = new Thread[quatityOfThreads];
			int counter=0;
			for(int i=0;i<quatityOfThreads;i++) {
				multiplethreads[i]= new MatrixMultiplication(m1,m2,result,counter,quatity[i]);
				counter +=quatity[i];
				multiplethreads[i].start();
			}
			for (Thread thread : multiplethreads) {
                thread.join();
            }
			return result;
		}
		else return null;
		
	}
	public static boolean checkMatrices (int[][] m1, int [][] m2) {
		if(m1==null || m2==null || m1.length==0 || m2.length==0 || m1[0].length!=m2.length) {
			System.out.println("incorrect matrices");
			return false;
		}
		return true;
	}
	public static void main(String[] args) throws InterruptedException {
		/*int[][] first= {{1,2,3,4,5,6,7},{2,4,5,6,2,1,5},{4,5,7,4,5,6,8}};
		int[][] second= {{4,5,6},{9,1,2},{8,4,5},{11,2,5},{4,6,1},{10,2,7},{2,1,3}};
		int [][] r =Multiplication(first,second,3);
		for(int i=0;i<r.length;i++) {
			for(int j=0;j<r[0].length;j++) {
				 System.out.print(r[i][j]+ "  ");
			}
			 System.out.println(" ");
		}*/
		System.out.println(new Date() + "  Start ");
		final Random r = new Random();
		int [][] first= new int[1000][4000];
		int [][] second= new int[4000][1500];
		int q = 4;
		for(int i=0;i<first.length;i++) {
			for(int j=0;j<first[0].length;j++) {
				first[i][j]=r.nextInt(15);
			}
		}
		for(int i=0;i<second.length;i++) {
			for(int j=0;j<second[0].length;j++) {
				second[i][j]=r.nextInt(15);
			}
		}
		int [][] result =Multiplication(first,second,q);
		System.out.println(new Date() + "  Finish");
	}
}
