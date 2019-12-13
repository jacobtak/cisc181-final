package pkgUT;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import pkgLogic.Loan;

class LoanTest {

	@Test
	void TestLoan() {
		
		LocalDate ld = LocalDate.of(2019,12,11);
		Loan l = new Loan(ld,100000.00, 0.07,0.00,240);
		//TODO make an assertEquals 
	}

}

