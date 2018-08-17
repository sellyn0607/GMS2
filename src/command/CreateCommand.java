package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class CreateCommand extends Command {
		
	public CreateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			request.setAttribute("pagename",request.getParameter("page"));
			MemberBean mem = new MemberBean();
			mem.setName(request.getParameter("name"));
			mem.setUserid(request.getParameter("userid"));
			mem.setPassword(request.getParameter("pw"));
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamId(request.getParameter("team_id"));
			mem.setSsn(request.getParameter("ssn1"));
			mem.setAge(request.getParameter("age"));
			mem.setGender(request.getParameter("gender"));
			//mem.setSubject(ParamMap.getValues(request,"subject"));
			MemberServiceImpl.getInstance().add(mem);
			break;
		default:
			break;
		}
		super.execute();
	}

}
