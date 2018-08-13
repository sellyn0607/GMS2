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
	public void add(MemberBean member) {
		MemberDAOImpl.getInstance().add(member);
	}
	@Override
	public MemberBean retrieve(MemberBean member) {
		return MemberDAOImpl.getInstance().retrieve(member);
	}
	@Override
	public void modify(Map<?, ?> param) {
		MemberDAOImpl.getInstance().modify(param);
		
	}
	@Override
	public void remove(MemberBean member) {
		MemberDAOImpl.getInstance().remove(member);
		
	}
	@Override
	public int memberCount() {
		return MemberDAOImpl.getInstance().count();
	}
	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().search(param);
	}
	@Override
	public MemberBean login(MemberBean member) {
		return MemberDAOImpl.getInstance().login(member);
	}

	
}
