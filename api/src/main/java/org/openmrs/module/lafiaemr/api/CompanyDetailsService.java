package org.openmrs.module.lafiaemr.api;

import org.openmrs.annotation.Authorized;
import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.module.lafiaemr.api.model.CompanyDetails;


import java.util.List;

public interface CompanyDetailsService extends OpenmrsService {
    
    @Authorized({"View Company Details"})
    CompanyDetails getCompanyDetailsById(Integer id) throws APIException;
    
    @Authorized({"View Company Details"})
    CompanyDetails getCompanyDetailsByUuid(String uuid) throws APIException;
    
    @Authorized({"View Company Details"})
    List<CompanyDetails> getAllCompanyDetails() throws APIException;
    
    @Authorized({"Manage Company Details"})
    CompanyDetails saveCompanyDetails(CompanyDetails companyDetails) throws APIException;
    
    @Authorized({"Manage Company Details"})
    void purgeCompanyDetails(CompanyDetails companyDetails) throws APIException;
}
//