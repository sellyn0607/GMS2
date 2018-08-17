package command;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import service.ImageServiceImpl;

public class FileCommand extends Command{
	public FileCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		request.setAttribute("pagename",request.getParameter("page"));
		ImageBean img = ImageServiceImpl.getInstance().call(((MemberBean) request.getSession().getAttribute("user")).getUserid());
		String imgPath = "/upload/"+img.getImgName()+"."+img.getExtension();
		request.setAttribute("imgfile",imgPath);
		
	}
}
