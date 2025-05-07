package com.spring_boot.voucher.controller.cms;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.user.UserRequestDTO;
import com.spring_boot.voucher.model.Admin;
import com.spring_boot.voucher.model.User;
import com.spring_boot.voucher.service.inf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/user-account")
public class UserController {

    private UserService userService;

    @GetMapping
    public ResponseEntity<BaseResponseDTO<List<User>>> list(){
        return ResponseEntity.ok(userService.list());
    }

    @PostMapping
    public ResponseEntity<BaseResponseDTO<User>> create(@RequestBody UserRequestDTO request){
        return ResponseEntity.ok(userService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<User>> update(@RequestBody UserRequestDTO request, @PathVariable String id){
        return ResponseEntity.ok(userService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<Boolean>> delete(@PathVariable String id){
        return ResponseEntity.ok(userService.delete(id));
    }
}
