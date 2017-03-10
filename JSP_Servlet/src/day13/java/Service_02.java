package day13.java;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Service_02 {
	public ArrayList<MemberDto_02> execute(HttpServletRequest request, HttpServletResponse response);
}
