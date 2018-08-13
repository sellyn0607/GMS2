package command;

import java.util.*;

import domain.*;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;

import proxy.*;

import service.MemberServiceImpl;

public class SearchCommand extends Command{
	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		
		execute();
		
	}

	@Override
	public void execute() {
	
			request.setAttribute("pagename",request.getParameter("page"));
			Map<String,Object> paramMap = new HashMap<>();
			String pageNumber = request.getParameter("pageIndex");
			PageProxy pxy = new PageProxy();
			int pn = (pageNumber==null)? 1 : Integer.parseInt(pageNumber);
			pxy.carryOut(pn);
			Pagination page = pxy.getPagination();
			paramMap.put("beginRow",String.valueOf(page.getBeginRow()));
			paramMap.put("endRow", String.valueOf(page.getEndRow()));
			
			if (request.getParameter("searchOption")!=null) {
				paramMap.put("column",request.getParameter("searchOption"));
				paramMap.put("value",request.getParameter("searchText"));
			}
			request.setAttribute("page",page);
			request.setAttribute("list",MemberServiceImpl.getInstance().search(paramMap));
	
				
		
	super.execute();
}
}
