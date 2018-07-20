package command;

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
		setPage(request.getParameter("page"));
		System.out.println("업데이트");
		Carrier.redirect(request, response,"");
		execute();
	}
	@Override
	public void execute() {
		
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("업데이트 확인");
			MemberBean m = new MemberBean();
			m.setUserid(request.getParameter("userid"));
			m.setPassword(String.format("%s/%s",request.getParameter("pw"), request.getParameter("npw")));
			MemberServiceImpl.getInstance().update(m);
			
			break;
		default:
			break;
			
			
		
		}
		super.execute();
	}
}
