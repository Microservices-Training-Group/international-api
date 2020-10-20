package com.news.app.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.news.app.model.Example;
import com.news.app.service.NewsService;

@RestController
public class NewsController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Welcome";
	}	
			
	@GetMapping(value = "/Categorizednews/{country}/{category}")
	public List<Example> sendCategorizedUpdate(@PathVariable String country,@PathVariable String category) throws ParseException, IOException {
		return NewsService.sendCategorizedUpdate(country,category);
	} 
	
	@GetMapping(value = "/Sourcednews/{country}/{source123}")
	public List<Example> sendSourcedUpdate(@PathVariable String country,@PathVariable String source123) throws ParseException, IOException {
		return NewsService.sendSourcedUpdate(country,source123);
	}
	
	@GetMapping(value = "/news/{country}/{category}/{source123}")
	public List<Example> sendRefinedUpdate(@PathVariable String country,@PathVariable String category,@PathVariable String source123) throws ParseException, IOException {
		return NewsService.sendRefinedUpdate(country,category,source123);
	} 
	
}
