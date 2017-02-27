import java.math.BigDecimal;
import java.math.BigInteger;


public class BigDecimalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BigDecimal
		BigDecimal num1 = new BigDecimal("3.0");
		BigDecimal num2 = new BigDecimal("2.9");
		
		BigDecimal result = num1.subtract(num2);
		System.out.println(result);
		
		System.out.println(result.intValue());
		System.out.println(result.doubleValue());
		
		BigDecimal num3 = new BigDecimal(19.4);
		BigDecimal num4 = new BigDecimal(3.1);
		//ROUND_HALF_UP:Àƒ…·ŒÂ»Î
		/*
		 * 	ROUND_UP, 
			ROUND_DOWN, 
			ROUND_CEILING, 
			ROUND_FLOOR, 
			ROUND_HALF_UP, 
			ROUND_HALF_DOWN, 
			ROUND_HALF_EVEN, 
			ROUND_UNNECESSARY
		*/
		BigDecimal result2 = num3.divide(num4, 8, BigDecimal.ROUND_HALF_UP);
		System.out.println(result2);
		
		//BigInteger
		BigInteger bigInt = new BigInteger("1");
		bigInt = BigInteger.valueOf(1);
		
		for(int i = 1; i <= 200; ++i)
			bigInt = bigInt.multiply(BigInteger.valueOf(i));
		
		System.out.println(bigInt);
		System.out.println(bigInt.toString().length());
	}

}
