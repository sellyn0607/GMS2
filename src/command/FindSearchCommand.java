package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oracle.jrockit.jfr.RequestableEvent;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class FindSearchCommand extends Command{
	public FindSearchCommand(HttpServletRequest request) {
		
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
			//request.setAttribute("member",MemberServiceImpl.getInstance().findByTeam(request.getParameter("team_id")));
		break;
		case ADMIN:
			request.setAttribute("list",MemberServiceImpl.getInstance().Search(
					request.getParameter("searchOption")+"/"+request.getParameter("searchText")));
			break;
		default:
			break;
		}
		super.execute();
	}
}
