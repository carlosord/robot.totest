package com.example.robot.totest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class StaticPagesController {

	@GetMapping(value="/video")
	public String showStaticVideoIframe() {
		return "static-video";
	}
	
	@GetMapping(value="/delay")
	public String showDelayPage() throws InterruptedException {
		Thread.sleep(10000);
		return "delay-page";
	}
	
	@GetMapping(value="/info")
	public String showMoreInfoPage() {
		return "more-info";
	}
	
}
