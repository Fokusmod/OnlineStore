package com.example.backonlinestore.Service;

import com.example.backonlinestore.Dto.RegistrationRequest;
import com.example.backonlinestore.Models.Role;
import com.example.backonlinestore.Models.User;
import com.example.backonlinestore.aspect.ExecutionTime;
import com.example.backonlinestore.repository.RoleRepository;
import com.example.backonlinestore.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Data
public class RegistrationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @ExecutionTime
    public void save(RegistrationRequest registrationRequest) {
        System.out.println(registrationRequest);
        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setEmail(registrationRequest.getEmail());

        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(()-> new RuntimeException("Role has not found"));
        Collection<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }


}
