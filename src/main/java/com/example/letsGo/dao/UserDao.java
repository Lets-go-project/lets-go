package com.example.letsGo.dao;

import com.example.letsGo.domain.member.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserDao {
    User findById(String id);
    void save(User user);

    User findByEmail(String email);

    User findByPassword(String password);

    void update(User user);

    String updateProfilePicture(String userId, MultipartFile profilePicture) throws IOException;

    void deleteProfilePicture(String id);
}
