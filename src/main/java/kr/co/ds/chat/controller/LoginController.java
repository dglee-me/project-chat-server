package kr.co.ds.chat.controller;

import kr.co.ds.chat.domain.user.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {



    @PostMapping("/login")
    public ResponseEntity<String> login(LoginDto user) {




        return ResponseEntity.ok("200");

    }
}
