package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.Tier;
import com.locknlol.coukie.domain.user.User;
import com.locknlol.coukie.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/v1/member", method = RequestMethod.POST)
	public User memberSave(@RequestBody User user) {
		return userService.saveMember(user);
	}

	@RequestMapping(value = "/v1/member", method = RequestMethod.DELETE)
	public void doing() {

	}

	@RequestMapping(value = "/v1/member/{tier}", method = RequestMethod.GET)
	public List<User> findMember(@PathVariable Tier tier) {
		return userService.findByTier(tier);
	}
}
