package com.locknlol.coukie.domain.member.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.locknlol.coukie.domain.member.dto.MemberDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by leetaejun on 2017. 6. 21..
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberRepositoryServiceTest {

	@Autowired
	WebApplicationContext wac;

	@Autowired
	ObjectMapper objectMapper;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void save() throws Exception {


		MemberDto.Request dto = new MemberDto.Request();
		dto.setEmail("ltj1@naver.com");
		dto.setPassword("123qwe");

		ResultActions result = mockMvc.perform(post("/admin/member/save")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(dto)));

		result.andDo(print());
		result.andExpect(status().isCreated());

		// TODO JSON Path
	}

	@Test
	public void saveBadRequest() throws Exception {
		MemberDto.Request dto = new MemberDto.Request();
		dto.setEmail(" ");
		dto.setPassword("1234");

		ResultActions result = mockMvc.perform(post("/admin/member/save")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(dto)));

		result.andDo(print());
		result.andExpect(status().isBadRequest());
	}
}
