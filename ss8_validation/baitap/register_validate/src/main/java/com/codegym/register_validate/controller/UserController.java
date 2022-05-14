package com.codegym.register_validate.controller;

import com.codegym.register_validate.Entity.User;
import com.codegym.register_validate.Service.UserService;
import com.codegym.register_validate.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("notify")
	public String showListCustomer(Model model){
		return "user/notify";
	}

	@GetMapping("register")
	public String register(Model model){
		UserDto userDto = new UserDto();
		model.addAttribute("userDto", userDto);
		return "user/register";
	}
	@PostMapping("register")
	public String create(@ModelAttribute("userDto") @Validated UserDto userDto, BindingResult bindingResult
			, RedirectAttributes redirectAttributes , Model model){
		new UserDto().validate(userDto, bindingResult);
		System.out.println(userDto);

		if (bindingResult.hasFieldErrors()){
			return "user/register";
		} else {
			User user = new User();
			BeanUtils.copyProperties(userDto, user);

			userService.create(user);
			redirectAttributes.addFlashAttribute("message", "Register user: " + user.getFirstName()+ " done!");
			return "redirect:/user/notify";
		}
	}
}
