package ru.deft.mongo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.deft.mongo.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	ru.deft.mongo.domain.User user = repository.findByName(username);
	if (user == null) {
	  throw new UsernameNotFoundException("User not found");
	}
	List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("user"));
	return new User(user.getName(), user.getPassword(), authorities);
  }
}