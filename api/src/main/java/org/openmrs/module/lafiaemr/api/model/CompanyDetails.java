package org.openmrs.module.lafiaemr.api.model;

import org.openmrs.BaseOpenmrsData;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "company_details")
public class CompanyDetails extends BaseOpenmrsData {
    
    @Id
    @Column(name = "company_uuid")
    private UUID companyUuid;
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    // Required method from OpenmrsObject interface
    @Override
    public Integer getId() {
        // Since we're using UUID as primary key, return null for the integer id
        return null;
    }
    
    @Override
    public void setId(Integer id) {
        // Since we're using UUID as primary key, this method is empty
        // You might want to throw an UnsupportedOperationException if you want to be explicit
    }
    
    // Getters and Setters
    public UUID getCompanyUuid() {
        return companyUuid;
    }
    
    public void setCompanyUuid(UUID companyUuid) {
        this.companyUuid = companyUuid;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}