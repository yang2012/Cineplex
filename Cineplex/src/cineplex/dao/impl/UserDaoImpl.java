package cineplex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cineplex.bean.Member;
import cineplex.dao.MemberDao;

public class UserDaoImpl implements MemberDao {
	private UserDaoImpl() {

	}

	public void save(Member member) {
		try {
			DataBaseManager sessionFactory = DataBaseManager.getInstance();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(member);
			tx.commit();
			session.close();
			sessionFactory.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	public Member find(String column, String value) {
		try {
			DataBaseManager sessionFactory = DataBaseManager.getInstance();
			Session session = sessionFactory.openSession();

			String hql = "from User as us where us."
					+ column + "='" + value + "'";
			Query query = session.createQuery(hql);
			List list = query.list();

			if ((list.size()) == 0)
				return null;
			else
				return (Member) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void update(Member menber) {
		try {
			DataBaseManager sessionFactory = DataBaseManager.getInstance();
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(menber);
			tx.commit();
			session.close();
			sessionFactory.closeSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
