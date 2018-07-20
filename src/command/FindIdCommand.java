package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class FindIdCommand extends Command{

	public FindIdCommand(HttpServletRequest request) {
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
		MemberBean m = new MemberBean();
		m.setUserid(request.getParameter("userid"));
		MemberBean mem=MemberServiceImpl.getInstance().findById(m);
		System.out.println(mem);
		break;
		default:
			break;
		}
		super.execute();
		
	}
}
