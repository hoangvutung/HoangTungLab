package ppTung.lab4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MatrixMultiplicationTest {

	@Test
	public void test() throws InterruptedException {
		int[][] first= {{1,2,3,4,5,6,7},{2,4,5,6,2,1,5},{4,5,7,4,5,6,8}};
		int[][] second= {{4,5,6},{9,1,2},{8,4,5},{11,2,5},{4,6,1},{10,2,7},{2,1,3}};
		int [][] r =MatrixMultiplication.Multiplication(first,second,1);
		int[][] result= {{184,76,113},{178,65,99},{257,111,160}};
		Assert.assertArrayEquals(r, result);
	}

}
