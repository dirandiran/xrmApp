package xrmApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xrmApp.entity.Company;
import xrmApp.services.api.CompanyService;

import java.util.List;

/**
 * Created by diran on 07.12.2016.
 */
@Controller
public class MainController {
    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAction(){
        ModelAndView mov = new ModelAndView("index");
        mov.addObject("company", new Company());
        return mov;
    }
    @RequestMapping(value = "/res", method = RequestMethod.POST)
    public ModelAndView postAction(@ModelAttribute() Company company){

        ModelAndView modelAndView = new ModelAndView("result");

        if(company.getCompanyName()!="") {
            // сохраняем в базу компанию
            companyService.saveCompany(company);
        }
        else {
            List<Company> listCompany = companyService.getAllCompany();
            // добавляем на jsp страницу list компаний
            modelAndView.addObject("listCompany",listCompany);
        }

        return modelAndView;
    }
}
