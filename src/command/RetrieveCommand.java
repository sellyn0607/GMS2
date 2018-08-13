package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{

	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		
		execute();
	}
	@Override
	public void execute() {

		switch(Domain.valueOf(getDomain().toUpperCase())) {
		case MEMBER:
			request.setAttribute("pagename",request.getParameter("page"));
			MemberBean me = new MemberBean();
			me.setUserid(request.getParameter("userid"));
			me =MemberServiceImpl.getInstance().retrieve(me);
			request.setAttribute("user", me);
			break;
			
		case ADMIN:
		MemberBean m = new MemberBean();
		m.setUserid(request.getParameter("userid"));
		m =MemberServiceImpl.getInstance().retrieve(m);
		request.setAttribute("findId", m);
		
		break;
		default:
			break;
		}
		super.execute();
		
	}
}
