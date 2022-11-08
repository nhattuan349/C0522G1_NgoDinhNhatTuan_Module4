package com.furama_casestudy_module_4.controller;

import com.furama_casestudy_module_4.service.contract.IContractService;
import com.furama_casestudy_module_4.service.customer.ICustomerService;
import com.furama_casestudy_module_4.service.employee.IEmployeeService;
import com.furama_casestudy_module_4.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IFacilityService facilityService;


    @GetMapping("")
    public ModelAndView listContracts(@PageableDefault(value = 5) Pageable pageable,
                                      @RequestParam Optional<String> start,
                                      @RequestParam Optional<String> end) {
        ModelAndView modelAndView = new ModelAndView("views/contract/list");
        modelAndView.addObject("start", start.orElse(""));
        modelAndView.addObject("end", end.orElse(""));
        modelAndView.addObject("contracts", contractService.findByName(pageable, start.orElse(""), end.orElse("")));
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("facilities", facilityService.findAll());
        return modelAndView;

    }

}
