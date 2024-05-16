package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome ...");
		return "view-welcome";
	}
	

	@GetMapping("/login")
	public String loginView() {
		System.out.println("login view...");
		return "view-login";
	}
	

	@PostMapping("/login")
	public RedirectView login(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("login form...");
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");
		
		System.out.println("Username/password: " + username + ", " + password);
		
		RedirectView redirectView = null;
		if (LoginService.login(username, password, dob)) {
			redirectView = new RedirectView("/q1", true);
		} else {
			// Login failed, stay with login page.
			//
			redirectView = new RedirectView("/login", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
		}
		
		return redirectView;
	}
	

	@GetMapping("/q1")
	public String q1View() {		
		System.out.println("q1 view...");
		return "view-q1";
	}

	@PostMapping("/q1")
	public RedirectView q1(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		

		RedirectView redirectView;
	    try {
	        // Calculate the result
	        double calculatedResult = MathQuestionService.q1Addition(number1, number2);
	        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

	        if (resultUser.isEmpty()) {
	            throw new IllegalArgumentException("Empty user result");
	        }
	        double userResult = Double.parseDouble(resultUser);
	        if (calculatedResult == userResult) {
				redirectView = new RedirectView("/q2", true);
			} else {
				redirectView = new RedirectView("/q1", true);
				redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
			}	
	    } catch (NumberFormatException e) {
	        // Handle invalid input (non-numeric)
	        redirectAttributes.addFlashAttribute("message", "Invalid input, please enter valid numbers.");
	        redirectView = new RedirectView("/q1", true);
	    } catch (IllegalArgumentException e) {
	        // Handle empty input or user result
	        redirectAttributes.addFlashAttribute("message", e.getMessage());
	        redirectView = new RedirectView("/q1", true);
	    }	
		return redirectView;
	}	
	

	@GetMapping("/q2")
	public String q2View() {		
		System.out.println("q2 view...");
		return "view-q2";
	}	


	@PostMapping("/q2")
	public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		
		RedirectView redirectView;
	    try {
	        // Calculate the result
	        double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
	        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

	        if (resultUser.isEmpty()) {
	            throw new IllegalArgumentException("Empty user result");
	        }
	        double userResult = Double.parseDouble(resultUser);
	        if (calculatedResult == userResult) {
				redirectView = new RedirectView("/q3", true);
			} else {
				redirectView = new RedirectView("/q2", true);
				redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
			}	
	    } catch (NumberFormatException e) {
	        // Handle invalid input (non-numeric)
	        redirectAttributes.addFlashAttribute("message", "Invalid input, please enter valid numbers.");
	        redirectView = new RedirectView("/q2", true);
	    } catch (IllegalArgumentException e) {
	        // Handle empty input or user result
	        redirectAttributes.addFlashAttribute("message", e.getMessage());
	        redirectView = new RedirectView("/q2", true);
	    }
		
		return redirectView;
	}	
	

	@GetMapping("/q3")
	public String q3View() {		
		System.out.println("q3 view...");
		return "view-q3";
	}	
	
	
	@PostMapping("/q3")
	public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    System.out.println("q3 form...");
	    String number1 = request.getParameter("number1");
	    String number2 = request.getParameter("number2");
	    String resultUser = request.getParameter("result");

	    RedirectView redirectView;
	    try {
	        // Calculate the result
	        double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
	        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

	        if (resultUser.isEmpty()) {
	            throw new IllegalArgumentException("Empty user result");
	        }
	        double userResult = Double.parseDouble(resultUser);
	        if (calculatedResult == userResult) {
				redirectView = new RedirectView("/login", true);
			} else {
				redirectView = new RedirectView("/q3", true);
				redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
			}	
	    } catch (NumberFormatException e) {
	        // Handle invalid input (non-numeric)
	        redirectAttributes.addFlashAttribute("message", "Invalid input, please enter valid numbers.");
	        redirectView = new RedirectView("/q3", true);
	    } catch (IllegalArgumentException e) {
	        // Handle empty input or user result
	        redirectAttributes.addFlashAttribute("message", e.getMessage());
	        redirectView = new RedirectView("/q3", true);
	    }

	    return redirectView;
	}
}
