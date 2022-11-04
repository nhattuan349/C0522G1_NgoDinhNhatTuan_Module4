package com.furama_casestudy_module_4.controller;

import com.furama_casestudy_module_4.dto.Customer.CustomerDto;
import com.furama_casestudy_module_4.model.customer.Customer;
import com.furama_casestudy_module_4.service.impl.CustomerService;
import com.furama_casestudy_module_4.service.impl.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 @PageableDefault(value = 2) Pageable pageable
    ) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/customer/create");
            return modelAndView;
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("views/customer/list");
            modelAndView.addObject("message", "Add new successfully!");
            modelAndView.addObject("customers", customerService.findAll(pageable));
            return modelAndView;
        }
    }


    @GetMapping("/customers")
    public ModelAndView listCustomers(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("views/customer/list");

        modelAndView.addObject("customers", customerService.findAll(pageable));
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;

    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        if (customer.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/customer/edit");
            modelAndView.addObject("customerDto", customerDto);
            return modelAndView;
        } else {
            return new ModelAndView("views/customer/error.404");
        }
    }

//    @PostMapping("/edit-customer")
//    public ModelAndView updateCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.save(customer);
//        ModelAndView modelAndView = new ModelAndView("views/customer/edit");
//        modelAndView.addObject("customer", customer);
//        modelAndView.addObject("message", "Customer updated successfully");
//        return modelAndView;
//    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@Validated @ModelAttribute CustomerDto customerDto,
                                       BindingResult bindingResult,
                                       @PageableDefault(value = 2) Pageable pageable
    ) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("views/customer/edit");
            return modelAndView;
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            ModelAndView modelAndView = new ModelAndView("views/customer/list");
            modelAndView.addObject("message", "Add new successfully!");
            modelAndView.addObject("customers", customerService.findAll(pageable));
            return modelAndView;
        }
    }

//    @GetMapping("/delete/{id}")
//    public ModelAndView showDeleteForm(@PathVariable int id) {
//        Optional<Customer> customer = customerService.findById(id);
//        if (customer.isPresent()) {
//            ModelAndView modelAndView = new ModelAndView("views/customer/delete");
//            modelAndView.addObject("customer", customer.get());
//            return modelAndView;
//
//        } else {
//            return new ModelAndView("views/customer/error.404");
//        }
//    }
//
//    @PostMapping("/delete")
//    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
//        customerService.remove(customer.getId());
//        return "redirect:customers";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customer.get().setStatus("0");
            customerService.save(customer.get());
        }
        return "redirect:/customers";
    }






    @GetMapping("/search")
    public ModelAndView seachName(@PageableDefault Pageable pageable,
                                  @RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("views/customer/list");
        modelAndView.addObject("customers", customerService.findByName(pageable, name));
        return modelAndView;
    }


    @GetMapping("/search2")
    public String getListFind(@RequestParam(value = "page", defaultValue = "0") Integer page,
                              @RequestParam(value = "name", defaultValue = "") String name,
                              @RequestParam(value = "email", defaultValue = "") String email,
                              @RequestParam(value = "status", defaultValue = "1") String status,
                              @RequestParam(value = "customerTypeId", defaultValue = "") String customerTypeId,
                              Model model) {
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("customerTypeId", customerTypeId);
        if (customerTypeId.equals("") && name.equals("") && email.equals("")) {
            model.addAttribute("customers", customerService.findByStatus(status, PageRequest.of(page, 5, sort)));
        } else if (customerTypeId.equals("")) {
            model.addAttribute("customers", customerService.findByNameAndEmail(name, email, status, PageRequest.of(page, 5, sort)));
        } else {
            model.addAttribute("customers", customerService.findByNameEmailAndCustomerTypeId(name, email, status, customerTypeId, PageRequest.of(page, 5, sort)));
        }
        return "views/customer/list";
    }
}
