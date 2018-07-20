package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {//얘는 센트리가 말한말을 커맨더한테 전하는 일만함 
	//public static Command cmd=new Command();
	
	public static void forword(HttpServletRequest request,HttpServletResponse response)
	{
		try {
			request.getRequestDispatcher(Sentry.cmd.getView()).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void redirect(HttpServletRequest request,HttpServletResponse response,String url) 
	{
		try {
			response.sendRedirect(request.getContextPath()+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
