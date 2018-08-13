package service;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberService {
	public void add(MemberBean member);
	public MemberBean retrieve(MemberBean member);
	public void modify(Map<?,?>param);
	public void remove(MemberBean member);
	public int memberCount();
	public List<MemberBean> search(Map<?,?>param);
	public MemberBean login(MemberBean member);
	
}
