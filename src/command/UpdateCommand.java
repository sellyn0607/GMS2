package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;
public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request,HttpServletResponse response) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		
		execute();
	}
	@Override
	public void execute() {
		
		
		request.setAttribute("pagename",request.getParameter("page"));
			System.out.println("업데이트 확인");
			Map<String,Object> map = new HashMap<>();
			map.put("userid",((MemberBean) request.getSession().getAttribute("user")).getUserid());
			map.put("password",request.getParameter("password"));
			map.put("roll",(request.getParameter("roll")));
			map.put("teamid", request.getParameter("teamId"));
			MemberServiceImpl.getInstance().modify(map);
		
			
		
		
		super.execute();
	}
}
