package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.dao.mybatis.mapper.UserMapper;
import com.example.letsGo.domain.member.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.UUID;


@Repository
public class MyBatisUserDao implements UserDao {

    private final UserMapper userMapper;

    @Autowired
    public MyBatisUserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    @Override
    public User findByPassword(String password) {
        return userMapper.findByPassword(password);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public String updateProfilePicture(String userId, MultipartFile profilePicture) throws IOException {
        User user = userMapper.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        if (profilePicture == null || profilePicture.isEmpty()) {
            throw new IllegalArgumentException("Profile picture is empty or null");
        }

        // Save profile picture to a location (e.g., file system or cloud storage)
        String profilePictureUrl = saveProfilePicture(profilePicture);

        // Update user's profile picture URL in the database
        user.setProfilePicture(profilePictureUrl);
        userMapper.update(user);

        return profilePictureUrl; // Return updated profile picture URL
    }

    @Override
    public void deleteProfilePicture(String id) {
        userMapper.deleteProfilePicture(id);
    }

    private String saveProfilePicture(MultipartFile profilePicture) throws IOException {
        // Generate unique file name using UUID
        String originalFileName = profilePicture.getOriginalFilename();
        String fileExtension = Objects.requireNonNull(originalFileName).substring(originalFileName.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + fileExtension;

        // Define the directory where the file will be stored
        String uploadDir = "/your/upload/path/";
        Path uploadPath = Paths.get(uploadDir);

        // Create the directory if it doesn't exist
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Resolve the file path
        Path filePath = uploadPath.resolve(fileName);

        // Copy the profile picture to the upload path
        try (InputStream inputStream = profilePicture.getInputStream()) {
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }

        // Return the URL or path where the profile picture is saved
        return uploadDir + fileName;
    }
}
