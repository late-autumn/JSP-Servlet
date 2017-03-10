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
			//octet-stream : 8 bit로된 일련의 데이터를 뜻한다.
			//지정되지 않은 파일 형식을 의미한다
			response.setContentType(sMimeType);
			
			//한글 업로드
			String sEncoding = new String(filename.getBytes("UTF-8"),"8859_1");
			response.setHeader("Content-Disposition", "attachment;filename="+sEncoding);
			ServletOutputStream out = response.getOutputStream();
			
			int numRead;
			//바이트 배열 b의 0번 부터 numRead번까지 브라우저로 출력
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
