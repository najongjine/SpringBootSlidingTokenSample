package com.jong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		return "ajaxHome";
	}
	
	@RequestMapping(value = "/",method =RequestMethod.GET)
	public String home(Model model) {
		List<String> dummyList=new ArrayList<String>();
		dummyList.add("t1");
		dummyList.add("t2");
		dummyList.add("t3");
		model.addAttribute("dummyList", dummyList);
		return "home";
	}
	
	//JWT+SECURITY 셋팅만 다 해놓면, 컨트롤러에 @PreAuthorize("hasAnyRole('MYCUSTOMROLE')")
	//이것만 적어주면 지가 다 알아서 함
	@PreAuthorize("hasAnyRole('ROLE_MEMBER')")
	@ResponseBody
	@RequestMapping(value = "/t1",method =RequestMethod.GET,produces = "application/json")
	public List<Integer> t1(Model model) {
		System.out.println("## called t1");
		List<Integer> dummyList2=new ArrayList<>();
		dummyList2.add(5);
		dummyList2.add(6);
		dummyList2.add(7);
		//model.addAttribute("dummyList2", dummyList2);
		return dummyList2;
	}
}
