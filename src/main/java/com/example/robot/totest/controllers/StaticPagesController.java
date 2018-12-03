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
		// Sleep 10 seconds to simulated a page that loads a big amount of data
		Thread.sleep(10000);
		return "delay-page";
	}
	
	@GetMapping(value="/delay2")
	public String showDelay2Page() throws InterruptedException {
		return "delay-page";
	}
	
	@GetMapping(value="/info")
	public String showMoreInfoPage() {
		return "more-info";
	}
	
	@GetMapping(value="/carousel")
	public String showCarouselPage() {
		return "carousel";
	}
	
}
