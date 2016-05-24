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
	@FXML
	private TextField txtIncome;
	//		TextBox  - 	txtExpenses
	@FXML
	private TextField txtExpenses;
	//		TextBox  - 	txtCreditScore
	@FXML
	private TextField txtCreditScore;
	//		TextBox  - 	txtHouseCost
	@FXML
	private TextField txtHouseCost;
	//		ComboBox -	loan term... 15 year or 30 year
	@FXML
	private ComboBox<Integer> cmbTerm;
	//		Labels   -  various labels for the controls
	@FXML
	private Label lblTitle;
	@FXML
	private Label lblCredit;
	@FXML
	private Label lblIncome;
	@FXML
	private Label lblExpense;
	@FXML
	private Label lblCost;
	@FXML
	private Label lblTerm;
	@FXML
	private Label lblMortgage;
	@FXML
	private Label lblMortgagePayment;
	//		Button   -  button to calculate the loan payment
	@FXML
	private Button btnCalculate;
	//		Label    -  to show error messages (exception throw, payment exception)
	@FXML
	private Label lblError;
	
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

		lq.setdIncome(Double.valueOf(txtIncome.getText()));
		lq.setdExpenses(Double.valueOf(txtExpenses.getText()));
		lq.setiTerm(Integer.valueOf(cmbTerm.getValue()));
		lq.setiCreditScore(Integer.valueOf(txtCreditScore.getText()));
		lq.setdAmount(Double.valueOf(txtHouseCost.getText()));
		lq.setdPayment(RateBLL.getPayment(lq.getdRate()/1200, lq.getiTerm()*12, lq.getdAmount()-lq.getiDownPayment(), 0, false)/(lq.getiTerm()*12));	
		
		a.setLoanRequest(lq);
		
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
		
		double PMT = lRequest.getdPayment();				
		double income = Double.parseDouble(txtIncome.getText());
		double expenses = Double.parseDouble(txtExpenses.getText());	

		if ((Math.round(PMT*100.0)/100.0) >= income * 0.28 || (Math.round(PMT*100.0)/100.0) >= (income * 0.36 - expenses)) {
			lblError.setText("The house cost is too dang high!!");
		} else {
			String textPMT = Double.toString((Math.round(PMT*100.0)/100.0));
			lblMortgagePayment.setText("$ "+textPMT);
		}
		
	}
}
