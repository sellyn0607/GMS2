package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command{

	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		
		execute();
	}
	@Override
	public void execute() {
		
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER:
			request.setAttribute("pagename",request.getParameter("page"));
			MemberBean m = new MemberBean();
			m.setUserid(request.getParameter("userid"));
			m.setPassword(request.getParameter("pw"));
		  	m=MemberServiceImpl.getInstance().login(m);
		  	if(MemberServiceImpl.getInstance().login(m).getSsn().equals("999")) {
		  		request.setAttribute("match","FALSE");
		  		
		  	}else {
		  		request.getSession().setAttribute("match","TRUE");
		  		request.getSession().setAttribute("user",MemberServiceImpl.getInstance().retrieve(m));
		  		
		  		ImageBean img = ImageServiceImpl.getInstance().call(((MemberBean) request.getSession().getAttribute("user")).getUserid());
				String imgPath = "/upload/"+img.getImgName()+"."+img.getExtension();
				request.setAttribute("imgfile",imgPath);
		  		
		  		
		  		
		  	}
		  	
		 
			
		break;
		default:
			break;
		}
		super.execute();
		
	}
}
