package day13.java;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MembersAllService_02 implements Service_02 {
	
	public MembersAllService_02() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<MemberDto_02> execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		MemberDao_02 dao = MemberDao_02.getInstance();
		return dao.membersAll();
	}

}
