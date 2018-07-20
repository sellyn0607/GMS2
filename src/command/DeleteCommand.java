package command;

import javax.servlet.http.HttpServletRequest;
import domain.*;
import service.*;


import enums.Domain;

public class DeleteCommand extends Command{
	public DeleteCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		execute();
	}

	@Override
	public void execute() {
		
		switch(Domain.valueOf(domain.toUpperCase())){
		case MEMBER :
		MemberBean m = new MemberBean();
		m.setUserid(request.getParameter("userid"));
		m.setPassword(request.getParameter("pw"));
		MemberServiceImpl.getInstance().delete(m);
		default:
			break;
		
		}
		super.execute();
	}
}
