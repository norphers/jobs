package com.jobs.application;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Boss;
import com.jobs.domain.Employee;
import com.jobs.domain.Manager;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository(); 
	
	public JobsController(){ // constructor
		
	}
	
	public void createVolunteer(String name, String adress, String phone, String description) throws Exception {	
		Volunteer volunteer = new Volunteer(name, adress, phone, description);
		repository.addMember(volunteer);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateEmployee()); //PaymentFactory.createPaymentRateEmployee() es el this.paymentRate=paymentRate de la clase Employee
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Manager manager = new Manager(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Boss boss = new Boss(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}

	//-------------------------------------------------------------------------------------------------------------------
	
	public void payAllEmployeers() { //setter
		 for (AbsStaffMember member : repository.getAllMembers()) {
			 member.pay();
		 }
	}
	
	public String getAllEmployees() { //getter
		return repository.toString();
	}

	//--------------------------------------------------------------------------------------------------------------------

	
}
