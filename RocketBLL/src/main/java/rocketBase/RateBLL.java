package rocketBase;

import org.apache.poi.ss.formula.functions.*;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import exceptions.RateException;
import rocketDomain.RateDomainModel;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Iterator;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{		
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		double creditScore = 0;
		RateDomainModel rate = null;

				//OrderBy Clause
		//		String hql = "From getRate() WHERE rates > 10 ORDERBY rates ASC";
		//		Query query = session.createQuery(hql);
		//		List results = query.list();
			
			for (RateDomainModel r : rates) {
				if (GivenCreditScore == r.getiMinCreditScore()) {
					creditScore = r.getdInterestRate();
				}
			}
			if (rate == null) {
				throw new RateException(rate);
			}
			else {
				//TODO - RocketBLL RateBLL.getRate
				//			obviously this should be changed to return the determined rate
		
				return creditScore;
			}
		
	}

	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
