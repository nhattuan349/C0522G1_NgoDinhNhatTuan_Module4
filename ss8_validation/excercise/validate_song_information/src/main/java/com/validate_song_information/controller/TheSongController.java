package com.validate_song_information.controller;

import com.validate_song_information.dto.TheSongDto;
import com.validate_song_information.model.TheSong;
import com.validate_song_information.service.ITheSongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("")
public class TheSongController {

    @Autowired
    private ITheSongService theSongService;

    @GetMapping("/create-song")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/song/create");
        modelAndView.addObject("theSongDto", new TheSongDto());
        return modelAndView;
    }

    @PostMapping("/create-song")
    public String saveTheSong(@Validated @ModelAttribute TheSongDto theSongDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model
    ) {
        new TheSongDto().validate(theSongDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/song/create";
        } else {
            TheSong theSong = new TheSong();
            BeanUtils.copyProperties(theSongDto, theSong);
            model.addAttribute("theSongDto",theSongDto);
            theSongService.save(theSong);
            redirectAttributes.addFlashAttribute("message","Add new theSong" +
                    "successfully!");
            return "redirect:/songs";
        }
    }


    @GetMapping("/songs")
    public ModelAndView listTheSongs(@PageableDefault(value = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/song/list");
        modelAndView.addObject("theSongs", theSongService.findAll(pageable));
        return modelAndView;

    }


    @GetMapping("/edit-song/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Optional<TheSong> theSong = theSongService.findById(id);
        if (theSong.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/song/edit");
            modelAndView.addObject("theSong", theSong.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/edit-song")
    public ModelAndView updateTheSong(@ModelAttribute("theSong") TheSong theSong) {
        theSongService.save(theSong);
        ModelAndView modelAndView = new ModelAndView("/song/edit");
        modelAndView.addObject("theSong", theSong);
        modelAndView.addObject("message", "TheSong updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-song/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id) {
        Optional<TheSong> theSong = theSongService.findById(id);
        if (theSong.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/song/delete");
            modelAndView.addObject("theSong", theSong.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete-song")
    public String deleteTheSong(@ModelAttribute("theSong") TheSong theSong) {
        theSongService.remove(theSong.getId());
        return "redirect:theSongs";
    }


    @GetMapping("/search")
    public String seachName(@PageableDefault Pageable pageable,
                            @RequestParam String keyword, Model model) {

        model.addAttribute("theSongs", theSongService.findByName(pageable, keyword));
        return "song/list";
    }

}
