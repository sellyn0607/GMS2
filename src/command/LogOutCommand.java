package command;

import javax.servlet.http.HttpServletRequest;

public class LogOutCommand extends Command{
	public LogOutCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		
		request.getSession().invalidate();
		//request.getSession().setAttribute("match","FASLE");
	}
}
