package com.furama_casestudy_module_4.controller;

import com.furama_casestudy_module_4.dto.Customer.CustomerDto;
import com.furama_casestudy_module_4.dto.Customer.FacilityDto;
import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.model.facility.Facility;
import com.furama_casestudy_module_4.service.facility.IFacilityService;
import com.furama_casestudy_module_4.service.facility.IFacilityTypeService;
import com.furama_casestudy_module_4.service.facility.IRentTypeService;
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
@RequestMapping("/facility")
public class FacilityController {


    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    public ModelAndView listFacilitys(@PageableDefault(value = 5) Pageable pageable,
                                      @RequestParam Optional<String> name,
                                      @RequestParam Optional<String> facilityType) {
        ModelAndView modelAndView = new ModelAndView("views/facility/list");
        modelAndView.addObject("name", name.orElse(""));
        modelAndView.addObject("facilityType", facilityType.orElse(""));
        modelAndView.addObject("facilitys", facilityService.findByName(pageable, name.orElse(""), facilityType.orElse("")));
        modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/show-form-create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/facility/create");
        modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        modelAndView.addObject("facilityDto", new FacilityDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                                     BindingResult bindingResult,
                                     @PageableDefault(value = 2) Pageable pageable
    ) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/facility/create");
            return modelAndView;
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facility.setStatus(0);
            facilityService.save(facility);
            ModelAndView modelAndView = new ModelAndView("redirect:/facility");
            modelAndView.addObject("message", "Add new successfully!");
            modelAndView.addObject("facilitys", facilityService.findAll(pageable));
            return modelAndView;
        }
    }


    @GetMapping("/show-form-edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Facility> facility = facilityService.findById(id);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility.get(), facilityDto);
        if (facility.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/facility/edit");
            modelAndView.addObject("facilityTypes", facilityTypeService.findAll());
            modelAndView.addObject("rentTypes", rentTypeService.findAll());
            modelAndView.addObject("facilityDto", facilityDto);
            return modelAndView;
        } else {
            return new ModelAndView("views/facility/error.404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView updateFacility(@Validated @ModelAttribute FacilityDto facilityDto,
                                       BindingResult bindingResult,
                                       @PageableDefault(value = 2) Pageable pageable
    ) {
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/facility/edit");
            return modelAndView;
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facility.setStatus(0);
            facilityService.save(facility);
            ModelAndView modelAndView = new ModelAndView("redirect:/facility");
            modelAndView.addObject("message", "Add new successfully!");
            modelAndView.addObject("facilitys", facilityService.findAll(pageable));
            return modelAndView;
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        facilityService.remove(id);
        return "redirect:/facility";
    }

}
