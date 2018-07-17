package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/member.do")
/*@WebServlet({"/member/joinFrom.do","/member/joinResult.do","/member/userLoginFrom.do","/member/listFrom.do",
	"/member/findByIdFrom.do","/member/findByTeamIdFrom.do","/member/updateFrom.do","/member/deleteFrom.do"})*/
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		switch(request.getParameter("action")) {
		case "move" :
	request.getRequestDispatcher(String.format("/WEB-INF/view/member/%s.jsp",request.getParameter("page"))).forward(request, response);
		break;
		
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
