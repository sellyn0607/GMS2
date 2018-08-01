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
		execute();
	}
	@Override
	public void execute() {
		
		switch(Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("업데이트 확인");
			MemberBean m = new MemberBean();
			m.setUserid(((MemberBean) request.getSession().getAttribute("user")).getUserid());
			m.setPassword(request.getParameter("password"));
			m.setRoll(request.getParameter("roll"));
			m.setTeamId(request.getParameter("teamId"));
			System.out.println("보내기전"+m);
			MemberServiceImpl.getInstance().update(m);
			System.out.println(m);
			break;
		default:
			break;
			
			
		
		}
		super.execute();
	}
}
