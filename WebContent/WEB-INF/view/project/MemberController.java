package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/member/joinFrom.do","/member/joinResult.do","/member/userLoginFrom.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberController");
		String path = request.getServletPath();
		System.out.println(path);
		
		switch(path) {
		case "/member/joinFrom.do":  
			request.getRequestDispatcher("/WEB-INF/view/member/joinFrom.jsp").forward(request, response); break;
		case "/member/joinResult.do":
			request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response); break;
		case "/member/userLoginFrom.do":
			request.getRequestDispatcher("/WEB-INF/view/member/userLoginFrom.jsp").forward(request, response); break;
			
		
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
