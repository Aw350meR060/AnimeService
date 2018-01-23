package com.example.aw350meServ3r.demo.services;

import com.example.aw350meServ3r.demo.Repository.RoleRepository;
import com.example.aw350meServ3r.demo.Repository.UserRepository;
import com.example.aw350meServ3r.demo.entities.Role;
import com.example.aw350meServ3r.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceUtil implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public String registerAcc(String username, String password){
        User user = userRepository.findByUsername(username);
        if (user == null){
            User newUser = new User();
            newUser.setUsername(username);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(11);
            newUser.setPassword(encoder.encode(password));
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findById((long) 2).get());
            newUser.setRoles(roles);

            userRepository.save(newUser);
            return "Success";
        }
        return "Fail";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User client = userRepository.findByUsername(username);
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(),
                    client.getPassword(),
                    client.getRoles());
        } catch (Exception repositoryProblem){
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        return loadedUser;
    }

}
