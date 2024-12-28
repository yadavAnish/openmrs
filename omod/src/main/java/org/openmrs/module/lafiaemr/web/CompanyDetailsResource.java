package org.openmrs.module.lafiaemr.web;

import org.openmrs.api.context.Context;
import org.openmrs.module.lafiaemr.api.CompanyDetailsService;
import org.openmrs.module.lafiaemr.api.model.CompanyDetails;
import org.openmrs.*;
// import org.openmrs.module.lafiaemr.api.model.CompanyDetails;

import org.openmrs.module.webservices.rest.web.RequestContext;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.annotation.Resource;
import org.openmrs.module.webservices.rest.web.representation.DefaultRepresentation;
import org.openmrs.module.webservices.rest.web.representation.FullRepresentation;
import org.openmrs.module.webservices.rest.web.representation.Representation;
import org.openmrs.module.webservices.rest.web.resource.impl.DataDelegatingCrudResource;
import org.openmrs.module.webservices.rest.web.resource.impl.DelegatingResourceDescription;
import org.openmrs.module.webservices.rest.web.response.ResponseException;

@Resource(name = RestConstants.VERSION_1 + "/companydetails", supportedClass = CompanyDetails.class, supportedOpenmrsVersions = {"3.*"})
public class CompanyDetailsResource extends DataDelegatingCrudResource<CompanyDetails> {
    
    @Override
    public CompanyDetails getByUniqueId(String uniqueId) {
        return Context.getService(CompanyDetailsService.class).getCompanyDetailsByUuid(uniqueId);
    }
    
    @Override
    protected void delete(CompanyDetails companyDetails, String reason, RequestContext context) throws ResponseException {
        Context.getService(CompanyDetailsService.class).purgeCompanyDetails(companyDetails);
    }
    
    @Override
    public void purge(CompanyDetails companyDetails, RequestContext context) throws ResponseException {
        Context.getService(CompanyDetailsService.class).purgeCompanyDetails(companyDetails);
    }

    @Override
    public CompanyDetails newDelegate() {
        return new CompanyDetails();
    }
    
    @Override
    public CompanyDetails save(CompanyDetails companyDetails) {
        return Context.getService(CompanyDetailsService.class).saveCompanyDetails(companyDetails);
    }
    
    @Override
    public DelegatingResourceDescription getRepresentationDescription(Representation rep) {
        if (rep instanceof DefaultRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("companyName");
            description.addProperty("voided");
            description.addSelfLink();
            return description;
        } else if (rep instanceof FullRepresentation) {
            DelegatingResourceDescription description = new DelegatingResourceDescription();
            description.addProperty("uuid");
            description.addProperty("companyName");
            description.addProperty("voided");
            description.addProperty("auditInfo");
            description.addSelfLink();
            return description;
        }
        return null;
    }
}