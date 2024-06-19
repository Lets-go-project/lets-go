package com.example.letsGo.service;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.domain.member.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(String id) {
        return userDao.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getUserByPassword(String password) {
        return userDao.findByPassword(password);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    @Transactional
    public String updateProfilePicture(String userId, MultipartFile profilePicture) throws IOException {
        User user = userDao.findById(userId);
        if (user == null) {
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        // 프로필 사진이 업로드되었는지 확인
        if (profilePicture != null && !profilePicture.isEmpty()) {
            // Save profile picture to a location (e.g., file system or cloud storage)
            String profilePictureUrl = saveProfilePicture(profilePicture);

            // Update user's profile picture URL in the database
            user.setProfilePicture(profilePictureUrl);
            userDao.update(user);

            return profilePictureUrl; // 업데이트된 프로필 사진 경로 반환
        } else {
            throw new IllegalArgumentException("Profile picture is empty or null");
        }
    }

    private String saveProfilePicture(MultipartFile profilePicture) throws IOException {
        // 프로필 사진을 저장하는 로직 구현
        // 예시로 파일을 임시로 저장하는 방법을 보여줍니다. 실제로는 파일 시스템이나 클라우드 스토리지에 저장해야 합니다.
        Path tempFilePath = Files.createTempFile("profile-", ".jpg");
        try (OutputStream os = Files.newOutputStream(tempFilePath)) {
            os.write(profilePicture.getBytes());
        }

        // 실제 프로필 이미지 URL을 리턴합니다. 이 예제에서는 임시 파일의 경로를 사용합니다.
        return tempFilePath.toString();
    }

    @Override
    public void deleteProfilePicture(String id) {
        userDao.deleteProfilePicture(id);
    }
}