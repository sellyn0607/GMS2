package command;

import javax.servlet.http.HttpServletRequest;
import domain.*;
import service.*;


import enums.Domain;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}

	@Override
	public void execute() {
		
		switch(Domain.valueOf(domain.toUpperCase())){
		case MEMBER :
		MemberBean m = new MemberBean();
		//String name = ((MemberBean) (request.getSession().getAttribute("user"))).getUserid();
		m.setUserid(((MemberBean) (request.getSession().getAttribute("user"))).getUserid());
		m.setPassword(request.getParameter("pw"));
		MemberServiceImpl.getInstance().delete(m);
		request.getSession().invalidate();
		default:
			break;
		
		}
		super.execute();
	}
}
