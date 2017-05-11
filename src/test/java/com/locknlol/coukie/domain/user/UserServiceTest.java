package com.locknlol.coukie.domain.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Oscar on 2017. 5. 11..
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@InjectMocks
	private UserService userService;
	@Mock
	private UserFindService userFindService;
	@Mock
	private UserSaveService userSaveService;

	private User user;

	@Before
	public void setUp() {
		user = new User();
		user.setId(1L);
		user.setPassword("abcd");
		user.setSummonerId("oscar");
	}

	@Test
	public void save_member_if_summonId_does_not_exist_Test() {
		when(userFindService.findBySummonerId(anyString())).thenReturn(null);

		userService.saveMember(user);

		verify(userSaveService).saveMember(user);

	}
}