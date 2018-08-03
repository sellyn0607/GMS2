package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
		
	}

	@Override
	public void execute() {
		switch(Domain.valueOf(getDomain().toUpperCase())) {
		
		case ADMIN:
			
			request.setAttribute("list", MemberServiceImpl.getInstance().selectAllMember());
			
			int a = MemberServiceImpl.getInstance().memberCount();
			
			/*if(a%5==0) {
				request.setAttribute("count",a/5);
			}else {
				request.setAttribute("count",a/5+1);
			}*/
			request.setAttribute("count", (a%5==0)? a/5 : a/5+1);
		break;
		default:
			break;	
		}
	super.execute();
}
}
