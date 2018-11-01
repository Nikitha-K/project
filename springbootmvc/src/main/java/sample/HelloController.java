package sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	ModelAndView mav;
	String message;
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		mav= new ModelAndView();
		message="welcome to spring boot mvc";
		mav.addObject("msg",message);
		mav.setViewName("Welcome");
		return mav;
		
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView LoginPage() {
		mav= new ModelAndView();
		mav.setViewName("Login");
		return mav;
		
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView Login(@RequestParam("username") String username,@RequestParam("password") String password) {
		mav= new ModelAndView();
		mav.addObject("user",username);
		mav.setViewName("Welcome");
		return mav;
		
	}
	
	
	

}
