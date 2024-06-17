package com.example.letsGo.service;

import com.example.letsGo.dao.UserDao;
import com.example.letsGo.domain.member.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    public String uploadProfilePicture(User user, MultipartFile profilePictureFile) {
        if (profilePictureFile.isEmpty()) {
            return "파일을 선택해주세요.";
        }
        try {
            // 업로드할 파일의 경로를 설정합니다. 여기서는 사용자의 홈 디렉토리를 기준으로 설정합니다.
            String uploadDir = System.getProperty("user.home") + "/uploads/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs(); // 디렉토리가 없으면 생성합니다.
            }

            byte[] bytes = profilePictureFile.getBytes();
            Path path = Paths.get(uploadDir + profilePictureFile.getOriginalFilename());
            Files.write(path, bytes);

            user.setProfilePicture(profilePictureFile.getOriginalFilename());
            updateUser(user);

            return "프로필 사진이 성공적으로 업로드되었습니다.";
        } catch (IOException e) {
            e.printStackTrace();
            return "파일 업로드 중 오류가 발생했습니다.";
        }
    }

    @Override
    public void deleteProfilePicture(User user) {
        String fileName = user.getProfilePicture();
        if (fileName != null) {
            String uploadDir = System.getProperty("user.home") + "/uploads/";
            Path path = Paths.get(uploadDir + fileName);
            File file = new File(path.toString());
            if (file.exists()) {
                file.delete();
            }
            user.setProfilePicture(null);
            updateUser(user);
        }
    }
}