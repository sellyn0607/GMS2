package dao;

import java.util.List;
import java.util.Map;

import domain.*;

public interface MemberDAO {
	public void insertMember(MemberBean member);
	public MemberBean findById(MemberBean member);
	public List<MemberBean> Search(String member);
	public List<MemberBean> findByName(String member);
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
	public List<MemberBean> selectAllMember();
	public List<MemberBean> selectList(Map<?,?>param);
	public MemberBean login(MemberBean member);
	public int countMember();
	
}
