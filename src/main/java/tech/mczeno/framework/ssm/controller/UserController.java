package tech.mczeno.framework.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.mczeno.framework.ssm.service.UserService;

import java.util.Objects;

/**
 * @author Chongming Zhou
 * @date 2018-06-29
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("auth/token")
    public ResponseEntity<?> getToken(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);
        String token = null;
        try {
            token = userService.getToken(username, password);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        return ResponseEntity.ok(token);
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello(String msg) {
        return "Hello " + (msg == null ? "" : msg);
    }

}
