package command;

import java.util.*;

import domain.*;
import javax.servlet.http.HttpServletRequest;
import enums.Domain;
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
			int pageSize=5;
			String beginRow="1";
			String endRow=String.valueOf(pageSize);
			int endPage=0;
			int count=40;
			int pageNumSize=0;
			
			
			
			/*request.setAttribute("list", MemberServiceImpl.getInstance().selectAllMember());*/
			Map<String,Object> param = new HashMap<>();
			if(request.getParameter("pageIndex")==null){
			
				
			}else {
			beginRow = String.valueOf((Integer.parseInt(request.getParameter("pageIndex"))-1)*pageSize+1);
			endRow = String.valueOf((pageSize*Integer.parseInt(request.getParameter("pageIndex"))));
	
			
			}
			param.put("beginRow",beginRow);
			param.put("endRow", endRow);
			
			
			request.setAttribute("list", MemberServiceImpl.getInstance().getlist(param)); 
			/*int a = MemberServiceImpl.getInstance().memberCount();*/
		
			
			if(count/pageSize>=pageSize+1) {
				endPage=5;
				}else {
					
			if(count%pageSize==0) {
			endPage=count/pageSize;
			}else {
				endPage=count/pageSize+1;
			}
				}
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
			request.getSession().setAttribute("endPage",endPage);
			request.getSession().setAttribute("count",count );
			request.getSession().setAttribute("beginPage","1" );	
			
			/*request.setAttribute("endPage", (a%5==0)? a/5 : a/5+1);*/	
				
				break;
		default:
			break;	
		}
	super.execute();
}
}
