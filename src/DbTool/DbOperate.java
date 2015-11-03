package DbTool;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Javabean.Goods;
import Javabean.User;

public class DbOperate {
	
	/**
	 * 通过goods外键user_id找到user
	 * @param user_id
	 * @return
	 */
	public User getUserById(String user_id){
		
		Session session = HibernateUtils.currentSession();
		User user = null;
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from User where id=:id");
			query.setParameter("id", user_id);
			@SuppressWarnings("rawtypes")
			List list = query.list();
			
			if(!list.isEmpty()){
				user = (User) list.get(0);
				tx.commit();
			}
			
		}catch (HibernateException ex){
			if(tx != null)tx.rollback();
			throw ex;
		}
		
		session.close();
		return user;
	}
	
	
	/**
	 * 根据用户名获取User
	 * @param username 用户名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User getUserByUserName(String username){
		
		User user = null;
		Transaction tx = null;
		Session session = HibernateUtils.currentSession();
		
		try{
			
			tx=session.beginTransaction();
			Query query = session.createQuery("from User where username=:username");
			query.setParameter("username", username);
			List<User> list = query.list();
			
			if(!list.isEmpty()){
				user = (User)list.get(0);
				tx.commit();
			}
			
		}catch(HibernateException ex){
			
			if(tx!=null){
				tx.rollback();
			}
			throw ex;
		}
		session.close();
		return user;
	
	}
	
	
	/**
	 * 根据用户名获取User
	 * @param username 用户名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public User getUserByUserNameNostate(String username){
		
		User user = null;
		Transaction tx = null;
		Session session = HibernateUtils.currentSession();
		
		try{
			
			tx=session.beginTransaction();
			Query query = session.createQuery("from User where username=:username");
			query.setParameter("username", username);
			List<User> list = query.list();
			
			if(!list.isEmpty()){
				user = (User)list.get(0);
				tx.commit();
			}
			
		}catch(HibernateException ex){
			
			if(tx!=null){
				tx.rollback();
			}
			throw ex;
		}
		session.close();
		return user;
	
	}
	
	
	

	/**
	 * 分页查询商品
	 * @param first
	 * @param max
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> getGoodsByPage(int first,int max){
		
		Session session = HibernateUtils.currentSession();
		List<Goods> list = null;
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Goods");
			query.setFirstResult(first);
			query.setMaxResults(max);
			list = query.list();
			tx.commit();			
			
		}catch(HibernateException ex){
			
			if(tx != null){
				tx.rollback();
			}
			
			throw ex;
		}
		
		session.close();
		return list;
	}
	
	
	/**
	 * 通过user_id获取goods
	 * @param user_id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> getGoodsByUser(String user_id){
		
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		List<Goods> list = null;
		
		try{ 
			
			tx = session.beginTransaction();
			Query query = session.createQuery("from Goods where user_id:=user_id");
			query.setParameter("user_id", new Integer(user_id));
			list = query.list();
			tx.commit();
			
		}catch (HibernateException e){
			
			if(tx != null){
				tx.rollback();
			}
			throw e;
		} 
		
		session.close();
		return list;
	}
	
	
	/**
	 * 模糊查询 根据关键字来查询
	 * @param key 关键字
	 * @param first 
	 * @param max
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Goods> getGoodsByUncertain(String key,int first,int max){
		
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		List<Goods> list=null;
		
		try{
			tx = session.beginTransaction();
			Query query = session.createQuery("from Goods where name like : name");
			query.setString("name", key);
			query.setFirstResult(first);
			query.setMaxResults(max);
			list = query.list();
			tx.commit();
			
		}catch (HibernateException ex){
			if(tx != null){
				tx.rollback();
			}
			
			throw ex;
		}
		session.close();
		return list;
	}
	
	
	/**
	 * 存储一个对象到表中
	 * @param object 要存储的对象
	 */
	public void save(Object object){
		
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			session.save(object);
			tx.commit();
			
		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
			throw e;
		}
		
		session.close();
	}
	
	
	/**
	 * 删除一个对象
	 * @param object 要删除的对象
	 */
	public void delete(Object object){
		
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			session.delete(object); 
			
		}catch(HibernateException ex){
			
			if(tx != null){
				tx.rollback();
			}
			
			throw ex;
		}
	}
	
	
	/**
	 * 跟新数据
	 * @param object  被更新的对象
	 */
	public void update(Object object){
		
		Session session = HibernateUtils.currentSession();
		Transaction tx = null;
		
		try{
			
			tx = session.beginTransaction();
			session.update(object); 
			
		}catch(HibernateException ex){
			
			if(tx != null){
				tx.rollback();
			}
			
			throw ex;
		}
		
		session.close();
	}
	
	
}
