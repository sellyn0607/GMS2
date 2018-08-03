package service;

import java.util.List;

import domain.*;

public interface MemberService {
	public void createMember(MemberBean member);
	public MemberBean findById(MemberBean member);
	public List<MemberBean> Search(String member);
	public List<MemberBean> findByName(String member);
	public void update(MemberBean member);
	public void delete(MemberBean member);
	public int memberCount();
	public List<MemberBean> selectAllMember();
	public List<MemberBean> list();
	public MemberBean login(MemberBean member);
	
}
