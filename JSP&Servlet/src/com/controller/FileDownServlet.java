package com.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileDownServlet
 */
@WebServlet("/FileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String filename = request.getParameter("file_name");
		String sDownloadPath = "c:\\upload\\";
		String sFilePath = sDownloadPath+filename;
		byte b[] = new byte[4096];
		FileInputStream in = new FileInputStream(sFilePath);
		String sMimeType = getServletContext().getMimeType(sFilePath);
		System.out.println("smimetype : "+sMimeType);
		
		if(sMimeType == null){
			sMimeType = "application/octet-stream";
			//octet-stream : 8 bit�ε� �Ϸ��� �����͸� ���Ѵ�.
			//�������� ���� ���� ������ �ǹ��Ѵ�
			response.setContentType(sMimeType);
			
			//�ѱ� ���ε�
			String sEncoding = new String(filename.getBytes("UTF-8"),"8859_1");
			response.setHeader("Content-Disposition", "attachment;filename="+sEncoding);
			ServletOutputStream out = response.getOutputStream();
			
			int numRead;
			//����Ʈ �迭 b�� 0�� ���� numRead������ �������� ���
			while((numRead = in.read(b, 0, b.length)) != -1){
				out.write(b, 0, numRead);
			}
			out.flush();
			out.close();
			in.close();
		}
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
