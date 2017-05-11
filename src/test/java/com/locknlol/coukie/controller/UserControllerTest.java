package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.user.User;
import com.locknlol.coukie.domain.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by Oscar on 2017. 5. 10..
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	@Mock
	private UserService userService;


	@Test
	public void member_save_test() {
		userController.memberSave(new User());

		verify(userService).saveMember(any(User.class));
	}
}