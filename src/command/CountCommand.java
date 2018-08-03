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
		case ADMIN:
			int a = MemberServiceImpl.getInstance().memberCount();
			
			if(a/5==0) {
				request.setAttribute("count",a/5);
			}else {
				request.setAttribute("count",a/5+1);
			}
			
				
			break;
		default:
			break;
		}
		super.execute();
		
	}
}
