package org.cm.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloController {

	@Get("/")
	String hello() {
		return "Hello World";
	}
}
