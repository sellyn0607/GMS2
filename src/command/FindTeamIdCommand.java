package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class FindTeamIdCommand extends Command{
	public FindTeamIdCommand(HttpServletRequest request) {
		
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
			request.setAttribute("member",MemberServiceImpl.getInstance().findBySearch(request.getParameter("team_id")));
		break;
		default:
			break;
		}
		super.execute();
	}
}
