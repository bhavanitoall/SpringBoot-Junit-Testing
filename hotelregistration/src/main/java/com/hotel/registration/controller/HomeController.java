package com.hotel.registration.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hotel.registration.dao.BookingDao;
import com.hotel.registration.dao.RegisterDao;
import com.hotel.registration.model.BookedRooms;
import com.hotel.registration.model.RegisterBean;
import com.hotel.registration.repository.UserRepository;

@Controller
public class HomeController {
	
	//controller => service => repository
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	BookingDao bookingDao;

	
	
	@ModelAttribute
	public void models(Model map,@ModelAttribute("userDetails") RegisterBean userDetails){
		long cid= registerDao.customerCount()+1;
		map.addAttribute("cid", cid);
		
		long bid = bookingDao.bookingCount()+1;
        map.addAttribute("bid",bid );
        
        
	}
	@GetMapping(value={"/home","/"})
	public String showHomePage(String string) {
		return "home";
	}

	@RequestMapping(value = "/user/home", method = RequestMethod.GET)
	public String userWelcome(Model map) {

		return "userhome";
	}

	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public String adminHome(Model map) {

		return "adminhome";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.GET)
	public String loginPage() {
		return "userlogin";
	}

	@GetMapping("/signup")
	public String doRegister(Model map) {
		
		map.addAttribute("userDetails", new RegisterBean());
		return "signup";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String postForm(@ModelAttribute("userDetails") RegisterBean userDetails, ModelMap model,
			BindingResult result) throws ClassNotFoundException, SQLException, IOException {
		
		registerDao.addDetails(userDetails);
		
		return "home";
	}
	 
	@GetMapping("/bookroom")
	public String doBooking(Model map) {
		
		
		map.addAttribute("bookingDetails", new BookedRooms());
		
		return "booking";
	}
	@PostMapping("/bookroomsuccess")
	public String bookingDone(Model map,@ModelAttribute("bookingDetails") BookedRooms bookedRooms) {
		bookingDao.saveBooking(bookedRooms);
		map.addAttribute("msg", "Room booked successfully ! ");
		return "booking";
	}
	@GetMapping("/bookedrooms")
	public String cheakBookings(@ModelAttribute("bookingDetails") BookedRooms bookedRooms,Model map) {
	
		List <BookedRooms> rooms = bookingDao.getAllrooms();
		
		map.addAttribute("rooms", rooms);
		
		return "bookingdetails";
	}

	
}
