package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class LoginCommand extends Command{

	public LoginCommand(HttpServletRequest request) {
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
			MemberBean m = new MemberBean();
			m.setUserid(request.getParameter("userid"));
			m.setPassword(request.getParameter("pw"));
		  	m=MemberServiceImpl.getInstance().login(m);
		  	if(MemberServiceImpl.getInstance().login(m).getSsn().equals("999")) {
		  		request.setAttribute("match","FALSE");
		  		
		  	}else {
		  		request.setAttribute("match","TRUE");
		  		request.setAttribute("user",MemberServiceImpl.getInstance().findById(m).getUserid());
		  	}
		  	
		 
			
		break;
		default:
			break;
		}
		super.execute();
		
	}
}
