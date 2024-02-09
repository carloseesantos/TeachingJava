package com.tbt.api.essentials.service;

import com.tbt.api.essentials.domain.User;
import com.tbt.api.essentials.exception.BadRequestException;
import com.tbt.api.essentials.mapper.UserMapper;
import com.tbt.api.essentials.repository.UserRepository;
import com.tbt.api.essentials.requests.UserPostRequestBody;
import com.tbt.api.essentials.requests.UserPutRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    public Page<User> listAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }
    public List<User> findByName(String name){
        return userRepository.findByName(name);
    }

    public User findByIdOrThrowBadRequestException(long id){
        return userRepository.findById(id)
                .orElseThrow(()-> new BadRequestException("User not Found"));
    }
    @Transactional
    public User save(UserPostRequestBody userPostRequestBody) {
        return userRepository.save(UserMapper.INSTANCE.toUser(userPostRequestBody));
    }

    @Transactional
    public void delete(long id) {
        userRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(UserPutRequestBody userPutRequestBody) {
        User savedUser = findByIdOrThrowBadRequestException(userPutRequestBody.getId());
        User user = UserMapper.INSTANCE.toUser(userPutRequestBody);
        user.setId(savedUser.getId());
        userRepository.save(user);
    }
}
