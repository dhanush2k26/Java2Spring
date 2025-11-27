package com.example.college;

import java.time.LocalDate;

import com.example.college.model.IBillable;
import com.example.college.model.Student;

public class Bill extends Student implements IBillable {
	
	protected double tuitionFees;
	protected double miscFees;
	protected LocalDate billDate;
	
	public Bill() {
     System.out.println("Bill Object Created");
	}

	public double getTuitionFees() {
		return tuitionFees;
	}

	public void setTuitionFees(double tuitionFees) {
		this.tuitionFees = tuitionFees;
	}

	public double getMiscFees() {
		return miscFees;
	}

	public void setMiscFees(double miscFees) {
		this.miscFees = miscFees;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	@Override
	public double calculateBill() {
		// TODO Auto-generated method stub
		return 0;
	}

}
