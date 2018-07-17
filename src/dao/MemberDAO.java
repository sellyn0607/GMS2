package dao;

import java.util.List;

import domain.*;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public MemberBean findById(MemberBean member);
	public List<MemberBean> findBySearch(String member);
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public List<MemberBean> selectAllMember();
	public MemberBean login(MemberBean member);
	public int countMember();
	
}
