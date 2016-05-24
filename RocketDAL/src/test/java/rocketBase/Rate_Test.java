package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {


	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
	}

	//Test to see if rates in tblRate Table is greater than 0
	@Test
	public void testGetAllRates() {
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		assertTrue(rates.size() > 0);
		
	}
	
	
	
}
