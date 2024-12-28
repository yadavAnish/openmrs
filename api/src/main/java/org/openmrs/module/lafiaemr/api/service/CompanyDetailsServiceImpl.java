package org.openmrs.module.lafiaemr.api.service;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.lafiaemr.api.CompanyDetailsService;
import org.openmrs.module.lafiaemr.api.dao.CompanyDetailsDAO;
import org.openmrs.module.lafiaemr.api.model.CompanyDetails;

import java.util.List;

public class CompanyDetailsServiceImpl extends BaseOpenmrsService implements CompanyDetailsService {
    
    private CompanyDetailsDAO dao;
    
    public void setDao(CompanyDetailsDAO dao) {
        this.dao = dao;
    }
    
    @Override
    public CompanyDetails getCompanyDetailsById(Integer id) {
        return dao.getCompanyDetailsById(id);
    }
    
    @Override
    public CompanyDetails getCompanyDetailsByUuid(String uuid) {
        return dao.getCompanyDetailsByUuid(uuid);
    }
    
    @Override
    public List<CompanyDetails> getAllCompanyDetails() {
        return dao.getAllCompanyDetails();
    }
    
    @Override
    public CompanyDetails saveCompanyDetails(CompanyDetails companyDetails) {
        return dao.saveCompanyDetails(companyDetails);
    }
    
    @Override
    public void purgeCompanyDetails(CompanyDetails companyDetails) {
        dao.purgeCompanyDetails(companyDetails);
    }
}