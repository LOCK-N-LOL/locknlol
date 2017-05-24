package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.user.User;
import com.locknlol.coukie.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@Controller
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/v1/member", method = RequestMethod.POST)
	@ResponseBody
	public User memberSave(@RequestBody User user) {
		return userService.saveMember(user);
	}
}
