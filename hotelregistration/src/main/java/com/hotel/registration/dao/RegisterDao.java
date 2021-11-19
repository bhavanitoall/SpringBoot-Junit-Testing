package com.hotel.registration.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotel.registration.model.RegisterBean;
import com.hotel.registration.model.User;
import com.hotel.registration.repository.UserRepository;

@Component
public class RegisterDao {
	@Autowired
	UserRepository userRepository;



	public void addDetails(RegisterBean registerBean) {

		userRepository.save(registerBean);
	}
	public long customerCount() {

		long count =userRepository.count();
		return count;
	}
	public int register(RegisterBean registerBean) {
		// TODO Auto-generated method stub
		return 0;
	}
	public RegisterBean validateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public RegisterBean validateRegisterBean(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getRegisterBeanList() {
		// TODO Auto-generated method stub
		return null;
	}
}
