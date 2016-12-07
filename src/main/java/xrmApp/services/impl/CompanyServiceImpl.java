package xrmApp.services.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xrmApp.entity.Company;
import xrmApp.services.api.CompanyService;


/**
 * Created by diran on 07.12.2016.
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    SessionFactory sessionFactory;
  /* @PersistenceContext
   private SessionFactory sessionFactory;

    public CompanyServiceImpl(){
        this.sessionFactory = sessionFactory;
    }*/


    public void saveCompany(Company company) {


        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        session.save(company);

    }

    public List<Company> getAllCompany() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Company ");
        return query.list();
    }
}
