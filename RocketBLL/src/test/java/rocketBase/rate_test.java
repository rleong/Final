package rocketBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test() {
		assert(1==1);
	}
	
	@Test
	public void creditTest() {
		assertEquals(RateBLL.getRate(633),5,0);
	}
	
	@Test
	public void rateExceptionTest() throws RateException {
		assertEquals(RateBLL.getRate(200), 0.00, 0.01);
		assertEquals(RateBLL.getRate(500), 0.00, 0.02);
	}

}
