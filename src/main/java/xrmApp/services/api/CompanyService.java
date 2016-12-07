package xrmApp.services.api;


import xrmApp.entity.Company;

import java.util.List;

/**
 * Created by diran on 07.12.2016.
 */
public interface CompanyService {

    void saveCompany(Company company);

    List<Company> getAllCompany();

}
