package com.hibernate.OrmDemo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Fullname fn=new Fullname();
//    	fn.setFname("Arjun");
//    	fn.setMname("prasadu");
//    	fn.setLname("Gurajapu");
//        Alien a=new Alien();
//        a.setId(101);
//        a.setName(fn);
//        a.setColor("green");
        
    	Alien a=null;
    	
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class);
       ServiceRegistry reg=new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session1=sf.openSession();
        Query q1=session1.createQuery("from Alien where id=101");
        q1.setCacheable(true);
        Transaction tx1=session1.beginTransaction();
        a=(Alien) q1.uniqueResult();
        //a=(Alien) session.get(Alien.class, 101);
        System.out.println(a);
        tx1.commit();
        session1.close();
        
        Session session2=sf.openSession();
        Query q2=session2.createQuery("from Alien where id=101");
        q2.setCacheable(true);
        Transaction tx2=session2.beginTransaction();
        a=(Alien) q2.uniqueResult();
        //Transaction t1=session2.beginTransaction();
       // a=(Alien) s1.get(Alien.class, 101);
        System.out.println(a);
        //session.save(a);
        tx2.commit();
        
        session2.close();
        
    }
}
