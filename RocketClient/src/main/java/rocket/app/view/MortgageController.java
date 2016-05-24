package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketBase.RateBLL;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	
	private TextField txtIncome; 		//Used to enter income
	private TextField txtExpenses; 		//Used to enter monthly expenses
	private TextField txtCreditScore; 	//Used to enter Credit Score
	private TextField txtHouseCost;		//Used to enter cost of the house you want to buy
	private ComboBox cmbTerm;			//Used to select term
	private TextField txtMortgagePayment;
	private TextField txtDownPayment;
	private TextField txtRate;
	private TextField txtTerm;
	private TextField txtAmount;
	private Label CreditScoreLabel;
	private Label TermLabel;
	private Label IncomeLabel;
	private Label ExpensesLabel;
	private Label HouseCostLabel;
	private Label lblMortgagePayment; 	//Calculated based on house cost, # of payments, interest rate
	private Button btnPayment; 	//Button to calculate error messages
	private Label ThrowExceptionLabel;
	private Label PaymentExceptionLabel;

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		a.setLoanRequest(lq);
		
		//Setters in lq
		//rate, term, amount, credit score, downpayment
		lq.setdRate(Integer.parseInt(txtRate.getText()));
		lq.setiTerm(Integer.parseInt(txtTerm.getText()));
		lq.setdAmount(Integer.parseInt(txtAmount.getText()));
		lq.setiCreditScore(Integer.parseInt(txtCreditScore.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		double MonthlyPITI = (lRequest.getdIncome() * (28/100));
		double MonthlyIncome = ((lRequest.getdIncome()) * (36/100));

		
		if (MonthlyIncome < MonthlyPITI) {
			double PMT = Math.round(lRequest.getdPayment());
			System.out.printf("Payment is %.2f", PMT);
		if (MonthlyPITI < MonthlyIncome) {
			PMT = Math.round(lRequest.getdPayment());
			System.out.printf("Payment is %.2f", PMT);
		}
			
	}
	}
}
