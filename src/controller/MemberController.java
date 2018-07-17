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
		String action = request.getParameter("action");
		String page = request.getParameter("page");
		//request.getServletPath()
		switch(action) {
		case "move" :
			switch(page) {
			case "joinForm" :request.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp").forward(request, response);break;
			case "joinResult" :request.getRequestDispatcher("/WEB-INF/view/member/joinResult.jsp").forward(request, response);break;
			case "userLoginForm" :request.getRequestDispatcher("/WEB-INF/view/member/userLoginForm.jsp").forward(request, response);break;
			case "userLoginResult" :request.getRequestDispatcher("/WEB-INF/view/member/userLoginResult.jsp").forward(request, response);break;
			case "listForm" :request.getRequestDispatcher("/WEB-INF/view/member/listForm.jsp").forward(request, response);break;
			case "findByIdForm" :request.getRequestDispatcher("/WEB-INF/view/member/findByIdForm.jsp").forward(request, response);break;
			case "findByIdResult" :request.getRequestDispatcher("/WEB-INF/view/member/findByIdResult.jsp").forward(request, response);break;
			case "findByTeamIdForm" :request.getRequestDispatcher("/WEB-INF/view/member/findByTeamIdForm.jsp").forward(request, response);break;
			case "findByTeamIdResult" :request.getRequestDispatcher("/WEB-INF/view/member/findByTeamIdResult.jsp").forward(request, response);break;
			case "updateForm" :request.getRequestDispatcher("/WEB-INF/view/member/updateForm.jsp").forward(request, response);break;
			case "updateResult" :request.getRequestDispatcher("/WEB-INF/view/member/updateResult.jsp").forward(request, response);break;
			case "deleteForm" :request.getRequestDispatcher("/WEB-INF/view/member/deleteForm.jsp").forward(request, response);break;
			case "deleteResult" :request.getRequestDispatcher("/WEB-INF/view/member/deleteResult.jsp").forward(request, response);break;
			
			}
		
		break;
		
		
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
