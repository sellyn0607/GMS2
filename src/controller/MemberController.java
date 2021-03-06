package controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import enums.*;

import command.Carrier;
import command.FindIdCommand;
import command.FindSearchCommand;
import command.ListCommand;
import command.Sentry;
import command.UpdateCommand;
import domain.MemberBean;
import service.MemberServiceImpl;
@WebServlet("/member.do")
/*@WebServlet({"/member/joinFrom.do","/member/joinResult.do","/member/userLoginFrom.do","/member/listFrom.do",
	"/member/findByIdFrom.do","/member/findByTeamIdFrom.do","/member/updateFrom.do","/member/deleteFrom.do"})*/
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Sentry.init(request,response);
		switch(Action.valueOf(Sentry.cmd.getAction().toUpperCase())) {//명령을 보냄 
		case MOVE :
			if(Sentry.cmd.getPage().equals("index")) {
				Carrier.redirect(request, response,"");
				
			}
				Carrier.forword(request, response);//캐리어로 보냄 ?
			
		break;
		
		case JOIN:
			Carrier.forword(request, response);
			break;
		
		case UPDATE:
			Carrier.forword(request, response);
		break;
		case DELETE:
			
			Carrier.redirect(request, response,"");
			break;
		case FINDID:
			Carrier.redirect(request, response,"");
			
			
		break;
		case FINDSEARCH:
			
			Carrier.forword(request, response);
			break;
		case COUNT:
			//System.err.println(request.getAttribute("count"));
			break;
		case LIST:
			Carrier.forword(request, response);
			break;
		case LOGIN:
			
			if(request.getAttribute("match").equals("TRUE")){
				
			
				Carrier.forword(request, response);
				
			
			
			}else {
				Carrier.redirect(request, response,"/member.do?action=move&page=userLoginForm");
			}
			break;
		  	}
		
		}
		
		
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
