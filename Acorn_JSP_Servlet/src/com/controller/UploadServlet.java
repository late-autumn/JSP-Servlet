package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/fileupload2/Upload")
@MultipartConfig(maxFileSize = 1024*1024*24, location = "c:\\upload")
//��� c����̺��� upload��� ������ ���������Ѵ�.
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	private String getFilename(Part part){
	//part �������̽��� �̿�(�� �ױ��� ��� �Ӽ��� PART�� ��ȯ�Ͽ� ó���ȴ�)	
		String filename = null;
		String contentDispositionHeader = part.getHeader("content-disposition");
		String elements[] = contentDispositionHeader.split(";");
		
		for(String element : elements){
			if(element.trim().startsWith("filename")){
				filename = element.substring(element.indexOf('=')+1);
				filename = filename.trim().replace("\"", "");
			}
		}
		return filename;
	}
	//���ϸ� ���
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
/*
	*//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *//*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

*/	
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("thefile");
		String filename = getFilename(part);
		
		if(filename != null && !filename.isEmpty()){
			
			part.write(filename);
			//part.write("c:\\upload\\"+filename);
			
		}
		String author = request.getParameter("theauthor");
		author = new String(author.getBytes("iso-8859-1"),"UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("�ۼ��� :"+author);
		out.println("���ϸ� :"+filename);
		out.print("���� ũ�� :"+part.getSize());
		
	}

}
