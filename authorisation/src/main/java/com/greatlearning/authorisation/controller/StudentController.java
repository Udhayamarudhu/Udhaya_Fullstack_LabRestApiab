package com.greatlearning.authorisation.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.authorisation.model.Student;
import com.greatlearning.authorisation.service.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl service;

    //@ResponseBody
	@RequestMapping("/")
	public String getAllStudents(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "student";
	}

	@PostMapping("/save")
	public String createTicket(@ModelAttribute(name = "student") Student student) {
		service.save(student);
		return "redirect:/student/";

	}

	@PostMapping("/edit/{id}")
	public String updateStudent(Model model, @RequestParam("studentId") int studentId) {
		Student student = service.getById(studentId);
		model.addAttribute("student", student);
		return "edit_student";
	}

	@GetMapping("/new")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@GetMapping("/delete/{id}")
	public String deleteTicket(@PathVariable(name = "studentId") Integer id) {
		service.deleteById(id);
		return "redirect:/student/";

	}

	@GetMapping("/search/{course}")
	public String searchByCourse(Model model, @PathVariable(name = "course") String course) {
		List<Student> student = service.searchByCourse(course);
		model.addAttribute("students", student);
		return "student";
	}

	@RequestMapping("/403")
	public ModelAndView accessDenied(Principal user) {
		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "hi" + user.getName() + ", you dont have permission to access this page!");
		} else {
			model.addObject("msg", " you dont have permission to access this page!");
		}
		model.setViewName("403");

		return model;
	}

}
