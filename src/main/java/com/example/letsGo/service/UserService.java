/*package com.example.letsGo.service;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.domain.member.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(String id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.save(user);
    }
}*/
package com.example.letsGo.service;

import com.example.letsGo.domain.member.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    void saveUser(User user);

    User getUserById(String id);

    User getUserByEmail(String email);

    User getUserByPassword(String password);

    void updateUser(User user);

    String uploadProfilePicture(User user, MultipartFile profilePictureFile);

    void deleteProfilePicture(User user);
}

