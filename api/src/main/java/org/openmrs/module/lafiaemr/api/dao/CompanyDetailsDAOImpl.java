package org.openmrs.module.lafiaemr.api.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.module.lafiaemr.api.dao.CompanyDetailsDAO;
import org.openmrs.module.lafiaemr.api.model.CompanyDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("companyDetailsDAO")
public class CompanyDetailsDAOImpl implements CompanyDetailsDAO {
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public CompanyDetails getCompanyDetailsById(Integer id) {
        return (CompanyDetails) sessionFactory.getCurrentSession()
                .get(CompanyDetails.class, id);
    }
    
    @Override
    public CompanyDetails getCompanyDetailsByUuid(String uuid) {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(CompanyDetails.class);
        criteria.add(Restrictions.eq("uuid", uuid));
        return (CompanyDetails) criteria.uniqueResult();
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<CompanyDetails> getAllCompanyDetails() {
        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(CompanyDetails.class);
        criteria.add(Restrictions.eq("voided", false));
        return criteria.list();
    }
    
    @Override
    public CompanyDetails saveCompanyDetails(CompanyDetails companyDetails) {
        sessionFactory.getCurrentSession().saveOrUpdate(companyDetails);
        return companyDetails;
    }
    
    @Override
    public void purgeCompanyDetails(CompanyDetails companyDetails) {
        sessionFactory.getCurrentSession().delete(companyDetails);
    }
}
