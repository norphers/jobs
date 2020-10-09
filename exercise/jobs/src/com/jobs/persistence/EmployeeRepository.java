package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;

public class EmployeeRepository {

	private static List<AbsStaffMember> members=new ArrayList<>();
	
	public EmployeeRepository(){
	}
	
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	
	public List<AbsStaffMember> getAllMembers(){
		return new ArrayList<>(members);
	}

	@Override
	public String toString() {
		return getAllMembers().toString().substring(1).replaceFirst("]", "").replaceAll(",","");
	}	
	
}
