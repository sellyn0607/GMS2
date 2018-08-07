package service;

import java.util.List;
import java.util.Map;

import dao.MemberDAOImpl;
import domain.MemberBean;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}

	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);
	}

	@Override
	public MemberBean findById(MemberBean member) {
		
		return MemberDAOImpl.getInstance().findById(member);
	}

	@Override
	public void update(MemberBean member) {
		
		 MemberDAOImpl.getInstance().updateMember(member);
	}

	@Override
	public void delete(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
		
	}

	
	@Override
	public List<MemberBean> Search(String member) {
		return MemberDAOImpl.getInstance().Search(member);
	}
	@Override
	public MemberBean login(MemberBean member) {
		
		return MemberDAOImpl.getInstance().login(member);
	}
	@Override
	public List<MemberBean> selectAllMember() {
		return MemberDAOImpl.getInstance().selectAllMember();
	}
	@Override
	public int memberCount() {
		return MemberDAOImpl.getInstance().countMember();
	}
	@Override
	public List<MemberBean> findByName(String member) {
		
		return MemberDAOImpl.getInstance().findByName(member);
	}
	@Override
	public List<MemberBean> getlist(Map<?, ?> param) {
		// TODO Auto-generated method stub
		return MemberDAOImpl.getInstance().selectList(param);
	}
	

}
