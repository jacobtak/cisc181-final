package pkgLogic;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Loan {
	
	private LocalDate StartDate;
	private double LoanStartAmount;
	private double LoanFinalAmount;
	private double InterestRate;
	private double AdditionalPayment;
	private int LoanPaymentCnt;
	private boolean bCompoundingOption;
	
	private ArrayList<Payment> loanPayments = new ArrayList<Payment>();
	
	public Loan(LocalDate startDate, double loanAmount, double interestRate, double additionalPayment, int loanPaymentCnt) {
		super(); 
		this.StartDate = startDate;
		LoanStartAmount = loanAmount;
		InterestRate = interestRate;
		AdditionalPayment = additionalPayment;
		LoanPaymentCnt = loanPaymentCnt;
		bCompoundingOption = false;
		LoanFinalAmount = 0;
		
		double RemainingBalance = LoanStartAmount;
		int LoanPaymentCnt = 1;
		
		while(RemainingBalance >= this.getPMT() ) {
			Payment payment = new Payment(RemainingBalance, LoanPaymentCnt++, startDate = startDate.plusMonths(LoanPaymentCnt-2),this);
			RemainingBalance = LoanFinalAmount;
			loanPayments.add(payment);
		
		}
	}	
	
	
	
	public Loan(LocalDate startDate, double LoanStartAmount, double LoanFinalAmount, double interestRate,
			double additionalPayment, int loanPaymentCnt, boolean bCompoundingOption, ArrayList<Payment> loanPayments) {
		super();
		StartDate = startDate;
		LoanStartAmount = LoanStartAmount;
		LoanFinalAmount = LoanFinalAmount;
		InterestRate = interestRate;
		AdditionalPayment = additionalPayment;
		LoanPaymentCnt = loanPaymentCnt;
		this.bCompoundingOption = bCompoundingOption;
		this.loanPayments = loanPayments;
		
	}
	
	public LocalDate getStartDate() {
		return StartDate;
	}




	public double getLoanStartAmount() {
		return LoanStartAmount;
	}




	public double getLoanFinalAmount() {
		return LoanFinalAmount;
	}




	public double getInterestRate() {
		return InterestRate;
	}




	public double getAdditionalPayment() {
		return AdditionalPayment;
	}




	public int getLoanPaymentCnt() {
		return LoanPaymentCnt;
	}




	public boolean isbCompoundingOption() {
		return bCompoundingOption;
	}
	
	
	
	public double getAdditionalPayments() {
		return AdditionalPayment;
	}




	public double getPMT() {
		double PMT = Math.abs(FinanceLib.pmt(this.getInterestRate()/12,this.LoanPaymentCnt,this.LoanStartAmount,this.LoanFinalAmount,this.bCompoundingOption));
		return PMT;
		
	}
	
	public double getTotalPayments() {
		return loanPayments.parallelStream().mapToDouble(p->p.getTotalPayment()).sum();
		}
	
	public ArrayList<Payment> getLoanPayments(){
		return loanPayments;
	}
	
	public double getTotalInterest() {
		return getTotalPayments() ;
	}
	
}
