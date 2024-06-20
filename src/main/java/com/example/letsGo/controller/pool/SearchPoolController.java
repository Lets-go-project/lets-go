package com.example.letsGo.controller.pool;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.pool.Pool;
import com.example.letsGo.domain.pool.PoolScrapMapping;
import com.example.letsGo.domain.pool.PoolScrapMappingId;
import com.example.letsGo.repository.PoolRepository;
import com.example.letsGo.repository.PoolScrapMappingRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/map")
public class SearchPoolController {

    @Autowired
    private PoolRepository poolRepository;

    @Autowired
    private PoolScrapMappingRepository poolScrapMappingRepository;

    @PostMapping("/search/json")
    @ResponseBody
    public ResponseEntity<String> savePool(@RequestBody Map<String, String> requestData, HttpSession session) {
        String placeId = requestData.get("placeId");
        String placeName = requestData.get("placeName");
        String addr = requestData.get("placeLoc");
        String placePhone = requestData.get("placePhone");

        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }
        int userId = user.getUser_id();

        // Pool 테이블에서 placeId가 존재하지 않으면 추가
        if (!poolRepository.existsById(placeId)) {
            Pool pool = new Pool();
            pool.setPoolId(placeId);
            pool.setPoolName(placeName);
            pool.setPoolTel(placePhone);
            pool.setPoolLoc(addr);
            poolRepository.save(pool);
        }

        // PoolScrapMapping에 userId와 placeId가 이미 존재하는지 확인
        PoolScrapMappingId id = new PoolScrapMappingId(userId, placeId);
        if (poolScrapMappingRepository.existsById(id)) {
            return ResponseEntity.status(400).body("이미 등록된 즐겨찾기입니다.");
        }

        // PoolScrapMapping에 새로 추가
        PoolScrapMapping poolScrapMapping = new PoolScrapMapping();
        poolScrapMapping.setId(id);
        poolScrapMapping.setUser(user);
        poolScrapMapping.setPool(poolRepository.findById(placeId).orElse(null));
        poolScrapMappingRepository.save(poolScrapMapping);

        return ResponseEntity.ok("즐겨찾기에 추가되었습니다.");
    }

    @GetMapping("/scrap")
    @ResponseBody
    public ResponseEntity<?> getScrapPools(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }
        int userId = user.getUser_id();

        // 스크랩된 수영장 위치들을 가져옴
        List<Pool> pools = poolScrapMappingRepository.findByUserId(userId).stream()
                .map(mapping -> poolRepository.findById(mapping.getId().getPoolId()).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return ResponseEntity.ok(pools);
    }
}