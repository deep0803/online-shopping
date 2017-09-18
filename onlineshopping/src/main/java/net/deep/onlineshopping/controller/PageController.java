package net.deep.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.deep.shoppingbackend.dao.CategoryDAO;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home Page");
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		mv.addObject("userClickHome",true);
		return mv;
	}
	@RequestMapping(value={"/about"})
	public ModelAndView about(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us Page");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	@RequestMapping(value={"/service"})
	public ModelAndView service(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Service Page");
		mv.addObject("userClickService",true);
		return mv;
	}
	@RequestMapping(value={"/contact"})
	public ModelAndView contact(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","contact Page");
		mv.addObject("userClickContact",true);
		return mv;
	}
	/*@RequestMapping(value={"/test"})
	public ModelAndView test(@RequestParam(value="greeting",required=false) String greeting){
		if(greeting==null){
			greeting="Hello There";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}*/
	@RequestMapping(value={"/test/{greeting}"})
	public ModelAndView test(@PathVariable(value="greeting",required=false) String greeting){
		if(greeting==null){
			greeting="Hello There";
		}
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
}
