package proxy;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import oracle.net.aso.s;
import service.MemberServiceImpl;

@Data
public class Pagination implements Proxy{
	 int pageNumber,pageCount,pageSize,blockSize,rowCount,blockCount,beginRow,
	 endRow,prevBlock,nextBlock,endPage,beginPage;
	 
	boolean existPrev,existNext;

	@Override
	public void carryOut(Object o) {
		this.pageNumber = (int) o;
		this.pageSize = 5;
		this.blockSize = 5;
		this.rowCount = MemberServiceImpl.getInstance().memberCount();
		this.pageCount = (rowCount%pageSize==0)? rowCount/pageSize : rowCount/pageSize+1;
		this.blockCount = (pageCount%blockSize==0)? pageCount/blockSize : pageCount/blockSize+1;
		this.beginRow = pageNumber*pageSize - (pageSize-1);
		this.endRow = pageNumber *pageSize;
		this.beginPage = pageNumber-((pageNumber-1)%blockSize);
		this.endPage = ((beginPage+pageSize-1)<pageCount)? beginPage+blockSize-1:pageCount;
		this.prevBlock = beginPage - blockSize;
		this.nextBlock = beginPage + blockSize;
		this.existPrev = (prevBlock>=0);
		System.out.println("existPrev  "+existPrev);
		this.existNext = (nextBlock<=pageCount);
		System.out.println("existNext  "+existNext);
		
	//Integer.parseInt(s)	
	}
	
	
	
	
}
