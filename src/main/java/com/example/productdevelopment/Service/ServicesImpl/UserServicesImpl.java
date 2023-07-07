package com.example.productdevelopment.Service.ServicesImpl;


import com.example.productdevelopment.Dao.UserRepository;
import com.example.productdevelopment.Entity.Role;
import com.example.productdevelopment.Entity.User;
import com.example.productdevelopment.Service.UserServices;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices {


    private final UserRepository userRepository;
    //    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void saveUser(User user) {
        if (user.getEmail().equals("sahbibebek55@gmail.com")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getALLUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);

    }
}
