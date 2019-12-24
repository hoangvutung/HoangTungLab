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
		System.out.println(new Date()+Thread.currentThread().getName()+ " start from " + rowNumber+ " quantity: "+ quantity );
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
		System.out.println(new Date()+Thread.currentThread().getName()+ " done! ");
	}
	public static int[][] Multiplication(int[][] m1, int [][] m2, int quatityOfThreads) throws InterruptedException{
		if(checkMatrices(m1,m2)) {
			int a=m1.length;
			int b=m2[0].length;
			int [][] result=new int[a][b];
			if(quatityOfThreads> a) quatityOfThreads=a;
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
}
