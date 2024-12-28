// src/main/java/org/openmrs/module/companydetails/api/db/CompanyDetailsDAO.java
package org.openmrs.module.lafiaemr.api.dao;

import org.openmrs.module.lafiaemr.api.model.CompanyDetails;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.lafiaemr.api.dao.CompanyDetailsDAO;
// import org.openmrs.module.lafiaemr.api.model.CompanyDetails;
import org.springframework.stereotype.Repository;


public interface CompanyDetailsDAO {
    CompanyDetails getCompanyDetailsById(Integer id);
    CompanyDetails getCompanyDetailsByUuid(String uuid);
    List<CompanyDetails> getAllCompanyDetails();
    CompanyDetails saveCompanyDetails(CompanyDetails companyDetails);
    void purgeCompanyDetails(CompanyDetails companyDetails);
}

// implementtation 





// @Repository("companyDetailsDAO")
// public class CompanyDetailsDAOImpl implements CompanyDetailsDAO {
    
//     private SessionFactory sessionFactory;
    
//     // Constructor with SessionFactory injection
//     public CompanyDetailsDAOImpl(SessionFactory sessionFactory) {
//         this.sessionFactory = sessionFactory;
//     }
    
//     /**
//      * @param sessionFactory the sessionFactory to set
//      */
//     public void setSessionFactory(SessionFactory sessionFactory) {
//         this.sessionFactory = sessionFactory;
//     }
    
//     /**
//      * @return the sessionFactory
//      */
//     public SessionFactory getSessionFactory() {
//         return sessionFactory;
//     }
    
//     @Override
//     public CompanyDetails getCompanyDetailsById(Integer id) {
//         return (CompanyDetails) sessionFactory.getCurrentSession()
//                 .get(CompanyDetails.class, id);
//     }
    
//     @Override
//     public CompanyDetails getCompanyDetailsByUuid(String uuid) {
//         Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CompanyDetails.class);
//         criteria.add(Restrictions.eq("uuid", uuid));
//         return (CompanyDetails) criteria.uniqueResult();
//     }
    
//     @Override
//     public List<CompanyDetails> getAllCompanyDetails() {
//         Criteria criteria = sessionFactory.getCurrentSession().createCriteria(CompanyDetails.class);
//         criteria.add(Restrictions.eq("voided", false));
//         return criteria.list();
//     }
    
//     @Override
//     public CompanyDetails saveCompanyDetails(CompanyDetails companyDetails) {
//         sessionFactory.getCurrentSession().saveOrUpdate(companyDetails);
//         return companyDetails;
//     }
    
//     @Override
//     public void purgeCompanyDetails(CompanyDetails companyDetails) {
//         sessionFactory.getCurrentSession().delete(companyDetails);
//     }
// }