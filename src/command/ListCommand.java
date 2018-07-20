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
		
		case MEMBER:
			
			List<MemberBean> lst= MemberServiceImpl.getInstance().selectAllMember();
			System.out.println(lst);
			request.setAttribute("list", MemberServiceImpl.getInstance().selectAllMember());
			
		break;
		default:
			break;	
		}
	super.execute();
}
}
