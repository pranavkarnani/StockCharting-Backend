package com.example.charting.gateway.service;

import com.example.charting.gateway.model.AppUser;
import com.example.charting.gateway.model.MyUserDetails;
import com.example.charting.gateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUser = userRepository.findByMail(username);
		appUser.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
		return appUser.map(MyUserDetails::new).get();
	}

	public AppUser signUp(AppUser user) throws Exception {
		Optional<AppUser> userObj = userRepository.findByMail(user.getMail());
		if (userObj.isPresent()) {
			throw new Exception("User already exists");
		} else {
			AppUser appUser = userObj.get();
			String pass = user.getPassword();
			user.setPassword(bCryptPasswordEncoder.encode(pass));
			userRepository.save(user);
			return user;
		}
	}
}