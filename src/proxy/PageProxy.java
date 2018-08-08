package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class PageProxy implements Proxy{
	private Pagination pagination;

	@Override
	public void carryOut(Object o) {
		this.pagination = new Pagination();
		pagination.carryOut(o);
		
	}
	

}
