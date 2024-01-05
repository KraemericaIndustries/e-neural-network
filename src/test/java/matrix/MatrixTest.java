package matrix;

import org.junit.*;

import kraemericaIndustries.matrix.Matrix;

public class MatrixTest {

	@Test
	public void constructionTest() {
		Matrix m = new Matrix(3, 4, i -> i * 2);  //  LAMBDA!  
		System.out.println(m);
	}
}