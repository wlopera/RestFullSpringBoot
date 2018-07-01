package com.wlopera;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

 @Controller
public class ProductController {
	@RequestMapping("/")
	public String product(Model model) {
		System.out.println("##=> ProductController .. poduct..!");
		return "product";
	}
}
