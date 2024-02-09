package com.tbt.api.essentials.controller;

import com.tbt.api.essentials.domain.User;
import com.tbt.api.essentials.requests.UserPostRequestBody;
import com.tbt.api.essentials.requests.UserPutRequestBody;
import com.tbt.api.essentials.service.UserService;
import com.tbt.api.essentials.util.DateUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("users")
@Log4j2
@RequiredArgsConstructor
public class UserController {

    private final DateUtil dateUtil;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> list(Pageable pageable){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(userService.listAll(pageable));
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<User> findById(@PathVariable long id){
        return ResponseEntity.ok(userService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path="/find")
    public ResponseEntity<List<User>> findByName(@RequestParam String name){
        return ResponseEntity.ok(userService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserPostRequestBody userPostRequestBody){
        return new ResponseEntity<>(userService.save(userPostRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<User> replace(@RequestBody @Valid UserPutRequestBody userPutRequestBody){
        log.info("CONTROLLER->");
        log.info("   userPutRequestBody:" + userPutRequestBody.getId() + "-" + userPutRequestBody.getName());
        userService.replace(userPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
