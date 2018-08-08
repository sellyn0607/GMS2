package command;

import java.util.*;

import domain.*;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;

import proxy.*;

import service.MemberServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
		
	}

	@Override
	public void execute() {
		switch(Domain.valueOf(getDomain().toUpperCase())) {
		
		case ADMIN:
			Map<String,Object> paramMap = new HashMap<>();
			String pageNumber = request.getParameter("pageIndex");
			PageProxy pxy = new PageProxy();
			int pn = (pageNumber==null)? 1 : Integer.parseInt(pageNumber);
			pxy.carryOut(pn);
			Pagination page = pxy.getPagination();
			paramMap.put("beginRow",String.valueOf(page.getBeginRow()));
			paramMap.put("endRow", String.valueOf(page.getEndRow()));
			request.setAttribute("page",page);
			request.setAttribute("list",MemberServiceImpl.getInstance().getlist(paramMap));
			super.execute();
				
			
			
			
			
			
			
			
			
			/*int pageSize=5;
			int pageNum = request.getParameter("pageIndex")==null ? 1 : Integer.parseInt(request.getParameter("pageIndex"));
			
			int count=MemberServiceImpl.getInstance().memberCount(); int a = MemberServiceImpl.getInstance().memberCount();
			
			
			Map<String,Object> param = new HashMap<>();
			int beginRow = (pageNum-1)*pageSize+1;
			int endRow = pageNum*pageSize;
	
			
			
			
			request.setAttribute("list", MemberServiceImpl.getInstance().getlist(param)); 
			request.setAttribute("beginPage", (request.getParameter("endPage")==null)?
					1:Integer.valueOf(request.getParameter("endPage"))+1);
			 request.setAttribute("endPage", ((int)request.getAttribute("beginPage")<count/5)? 
					 (int)request.getAttribute("beginPage")+4 :count/5+((count%5==0)?0:1));
			
			int prevBlock=0;
			int nextBlock = 0;
			int pageCount = 0;
			boolean existPrev = false;
			if(prevBlock >=0) {
				existPrev = true;
			}
			boolean existNext = false;
			if(nextBlock <= pageCount) {
				existNext = true;
			}
			request.getSession().setAttribute("endPage","");
			request.getSession().setAttribute("count",count );
			request.getSession().setAttribute("beginPage","1" );	*/
			
			/*request.setAttribute("endPage", (a%5==0)? a/5 : a/5+1);*/	
				
				break;
		default:
			break;	
		}
	super.execute();
}
}
