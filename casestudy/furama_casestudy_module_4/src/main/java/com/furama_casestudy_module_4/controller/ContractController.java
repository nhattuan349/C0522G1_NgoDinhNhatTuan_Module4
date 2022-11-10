package com.furama_casestudy_module_4.controller;

import com.furama_casestudy_module_4.dto.ContractDetailDto;
import com.furama_casestudy_module_4.dto.ContractDto;
import com.furama_casestudy_module_4.model.contract.AttachFacility;
import com.furama_casestudy_module_4.model.contract.Contract;
import com.furama_casestudy_module_4.model.contract.ContractDetail;
import com.furama_casestudy_module_4.service.contract.IAttachFacilityService;
import com.furama_casestudy_module_4.service.contract.IContractDetailService;
import com.furama_casestudy_module_4.service.contract.IContractService;
import com.furama_casestudy_module_4.service.customer.ICustomerService;
import com.furama_casestudy_module_4.service.employee.IEmployeeService;
import com.furama_casestudy_module_4.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @Autowired
    private IContractDetailService contractDetailService;


    @GetMapping("")
    public ModelAndView listContracts(@PageableDefault(value = 5) Pageable pageable,
                                      @RequestParam Optional<String> start,
                                      @RequestParam Optional<String> end) {
        ModelAndView modelAndView = new ModelAndView("views/contract/list");
        modelAndView.addObject("start", start.orElse(""));
        modelAndView.addObject("end", end.orElse(""));
        Page<Contract> contractPage = contractService.findByName(pageable, start.orElse(""), end.orElse(""));
        Page<ContractDto> contractDtoPage = contractPage.map(new Function<Contract, ContractDto>()
        {
            @Override
            public ContractDto apply(Contract contract) {
                ContractDto contractDto = new ContractDto();
                BeanUtils.copyProperties(contract, contractDto);
                contractDto.getTotalCost();
                return contractDto;
            }
        });
        modelAndView.addObject("contracts", contractDtoPage);
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("facilities", facilityService.findAll());
        modelAndView.addObject("attachFacilities", attachFacilityService.findAll());
        modelAndView.addObject("contractDetails", contractDetailService.findAll());
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());

        return modelAndView;
    }

//    @GetMapping("")
//    public ModelAndView listContracts(@PageableDefault(value = 5) Pageable pageable,
//                                      @RequestParam Optional<String> start,
//                                      @RequestParam Optional<String> end) {
//        ModelAndView modelAndView = new ModelAndView("views/contract/list");
//        modelAndView.addObject("start", start.orElse(""));
//        modelAndView.addObject("end", end.orElse(""));
//        modelAndView.addObject("contracts", contractService.findByName(pageable, start.orElse(""), end.orElse("")));
//        modelAndView.addObject("employees", employeeService.findAll());
//        modelAndView.addObject("customers", customerService.findAll());
//        modelAndView.addObject("facilities", facilityService.findAll());
//        modelAndView.addObject("attachFacilities", attachFacilityService.findAll());
//        modelAndView.addObject("contractDetails", contractDetailService.findAll());
//        return modelAndView;
//    }


    @GetMapping("/show-form-create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/contract/create");
        modelAndView.addObject("contractTypes", contractService.findAll());
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.addObject("facilities", facilityService.findAll());
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveContract(@Validated @ModelAttribute ContractDto contractDto,
                                     BindingResult bindingResult,
                                     @PageableDefault(value = 2) Pageable pageable
    ) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/contract/create");
            modelAndView.addObject("employees", employeeService.findAll());
            modelAndView.addObject("customers", customerService.findAll());
            modelAndView.addObject("facilities", facilityService.findAll());

            return modelAndView;
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            contract.setStatus(0);
            contractService.save(contract);
            ModelAndView modelAndView = new ModelAndView("redirect:/contract");
            modelAndView.addObject("message", "Add new successfully!");
            modelAndView.addObject("contracts", contractService.findAll(pageable));
            modelAndView.addObject("employees", employeeService.findAll());
            modelAndView.addObject("customers", customerService.findAll());
            modelAndView.addObject("facilities", facilityService.findAll());
            return modelAndView;
        }
    }




}
