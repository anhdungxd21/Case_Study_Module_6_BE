package com.codegym.lastwhisper.controller;


import com.codegym.lastwhisper.common.GooglePojo;
import com.codegym.lastwhisper.common.GoogleUtils;
import com.codegym.lastwhisper.model.Song;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class BaseController {
	
	@Autowired
	private GoogleUtils googleUtils;

	@RequestMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("/login-google")
	public ResponseEntity<?> loginGoogle(HttpServletRequest request) throws ClientProtocolException, IOException {
		String code = request.getParameter("code");
		
		if (code == null || code.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String accessToken = googleUtils.getToken(code);
		
		GooglePojo googlePojo = googleUtils.getUserInfo(accessToken);
		UserDetails userDetail = googleUtils.buildUser(googlePojo);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetail, null,
				userDetail.getAuthorities());
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping("/user")
	public String user() {
		return "user";
	}

	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}

	@RequestMapping("/403")
	public String accessDenied() {
		return "403";
	}
}
