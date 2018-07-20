package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CountCommand extends Command{

	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
		request.setAttribute("count",MemberServiceImpl.getInstance().memberCount());
		
		
		  	
		 
			
		break;
		default:
			break;
		}
		super.execute();
		
	}
}
