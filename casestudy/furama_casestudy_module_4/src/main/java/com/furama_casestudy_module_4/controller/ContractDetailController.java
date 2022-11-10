package com.furama_casestudy_module_4.controller;

import com.furama_casestudy_module_4.dto.ContractDetailDto;
import com.furama_casestudy_module_4.dto.FacilityDto;
import com.furama_casestudy_module_4.model.contract.ContractDetail;
import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.service.contract.IAttachFacilityService;
import com.furama_casestudy_module_4.service.contract.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("")
    public ModelAndView listContracts(@PageableDefault(value = 5) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("views/contract/list");
        modelAndView.addObject("attachFacilities", attachFacilityService.findAll());
        modelAndView.addObject("contractDetails", contractDetailService.findAll());
        return modelAndView;
    }

    @GetMapping("/show-form-create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/contract/create");
        modelAndView.addObject("attachFacilities", attachFacilityService.findAll());
        modelAndView.addObject("contractDetails", contractDetailService.findAll());
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveContractDetail(@Validated @ModelAttribute ContractDetailDto contractDetailDto,
                                     BindingResult bindingResult,
                                     @PageableDefault(value = 2) Pageable pageable
    ) {
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/contract/create");
            modelAndView.addObject("attachFacilities", attachFacilityService.findAll());
            modelAndView.addObject("contractDetails", contractDetailService.findAll());
            return modelAndView;
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetail.setStatus(0);
            contractDetailService.save(contractDetail);
            ModelAndView modelAndView = new ModelAndView("redirect:/contract");
            modelAndView.addObject("message", "Add new successfully!");
            modelAndView.addObject("attachFacilities", attachFacilityService.findAll());
            modelAndView.addObject("contractDetails", contractDetailService.findAll());
            return modelAndView;
        }
    }

}
