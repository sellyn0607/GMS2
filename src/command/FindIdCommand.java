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
			MemberBean me = new MemberBean();
			me.setUserid(request.getParameter("userid"));
			me =MemberServiceImpl.getInstance().findById(me);
			System.out.println(me.isOverlap());
			if(me.isOverlap()) {
				request.setAttribute("over","FALSE");
			}else {
				request.setAttribute("over","TRUE");
			}			
			break;
			
		case ADMIN:
		MemberBean m = new MemberBean();
		m.setUserid(request.getParameter("userid"));
		m =MemberServiceImpl.getInstance().findById(m);
		System.out.println(m);
		request.setAttribute("findId", m);
		/*System.out.println(m);
		request.setAttribute("findById", m);*/
		break;
		default:
			break;
		}
		super.execute();
		
	}
}
