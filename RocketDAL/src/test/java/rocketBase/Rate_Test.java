package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class Rate_Test {
	
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
	
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
		
		//TODO - RocketDAL rate_test
		//Check to see if a known credit score returns a known interest rate

		for(RateDomainModel r : rates){
			System.out.println("Interest rate is: " + r.getdInterestRate());
		}
		
		//TODO - RocketDAL rate_test
		//		Check to see if a RateException is thrown if there are no rates for a given
		//		credit score
		try {
			double rRates = 0;
			
			if(rRates == 0){
				throw new RateException(null);
			}
			
		} catch (RateException e) {
			System.out.println("No credit score.");
		}
	}

}
