package cineplex.dao;

import cineplex.bean.Member;

public interface MemberDao {
	public void save(Member menber);
	public Member find(String column,String value);
	public void update(Member Member);
}
