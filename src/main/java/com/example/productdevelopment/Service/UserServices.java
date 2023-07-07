package com.example.productdevelopment.Service;




import com.example.productdevelopment.Entity.User;

import java.util.List;

public interface UserServices {
    void saveUser(User user);

    User findByEmail(String email);

    List<User> getALLUsers();
    User getUserById(Long id);

 // Delete user By userid
    void deleteUser(Long id);
   void updateUser(User user);

}
