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
		setPage(request.getParameter("page"));
		System.out.println("크리에이트");
		execute();
	}
	@Override
	public void execute() {
		
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴 !");
			MemberBean mem = new MemberBean();
			mem.setName(request.getParameter("name"));
			mem.setUserid(request.getParameter("userid"));
			mem.setPassword(request.getParameter("pw"));
			mem.setRoll(request.getParameter("roll"));
			mem.setTeamId(request.getParameter("team_id"));
			mem.setSsn(request.getParameter("ssn1"));
			MemberServiceImpl.getInstance().createMember(mem);
			System.out.println("회원가입에 성공");
			break;
		default:
			break;
		}
		super.execute();
	}

}
