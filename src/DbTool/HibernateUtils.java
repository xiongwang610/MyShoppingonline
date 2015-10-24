package DbTool;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtils {
	
	
	
	private static final SessionFactory sessionFactory;
	
	static{
		try{
			sessionFactory=new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			ex.printStackTrace();
			throw new ExceptionInInitializerError();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static final ThreadLocal session=new ThreadLocal();
	
	
	/**
	 * ��ȡ��ǰ�߳��е�session ���û�о�newһ��
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Session currentSession() throws HibernateException{
		Session s=(Session) session.get();
		if(s==null||!s.isOpen()){
			s=sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	
	/**
	 * �ر�session����
	 * @throws HibernateException
	 */
	@SuppressWarnings("unchecked")
	public static void closeSession() throws HibernateException{
		Session s=(Session) session.get();
		session.set(null);
		if(s!=null){
			s.close();
		}
	}
	
}
