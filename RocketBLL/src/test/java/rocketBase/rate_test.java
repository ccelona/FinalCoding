package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.Test;

import exceptions.RateException;
import rocketBase.RateBLL;
import rocketDomain.RateDomainModel;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	@Test 
	public void testCreditScore() throws RateException {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		int creditScore = 700;
		double rate = 0.0;
		double payment = 0.0;
		int exception = 0;
		try {
			rate = RateBLL.getRate(creditScore)/(100*12);
		} catch (RateException e) {
			exception = 1;
			throw e;	
		}
	}
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test (expected = RateException.class)
	public void TestRateException() throws Exception {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		int creditScore = 630;
		try {
			double rate = RateBLL.getRate(creditScore);
		} catch (RateException e) {
			throw e;
		}
		
	}
	
	//test getPayment()
	@Test
	public void testgetPayment() {
		double ExpectedResult = -3;
		double ActualResult = RateBLL.getPayment(0, 3, 2, 7, true);
		assertEquals(ExpectedResult, ActualResult, 0.01); 
	}
	
	@Test
	public void test() {
		assert(1==1);
	}

}
