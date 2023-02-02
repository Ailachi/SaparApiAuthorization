package com.example.saparauthorization.service.impl;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.mappers.SaparMapper;
import com.example.saparauthorization.model.User;
import com.example.saparauthorization.repository.UserRepository;
import com.example.saparauthorization.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private SaparMapper mapper;

    public UserService() {}
    @Autowired
    public UserService(UserRepository userRepository, SaparMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserModel findUserById(long id) throws Exception {
        if(id <= 0) {
            throw new Exception("Id is out of range");
        }

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent())
            throw new Exception("No such user exception");

        return mapper.UserToUserModel(user.get());
    }

    @Override
    public UserModel create(UserModel userModel) {
        return null;
    }

    @Override
    public UserModel findUserByEmail(String email) throws Exception{
        if(email == null || email.isEmpty()) {
            throw new Exception("Id is out of range");
        }

        User user = userRepository.getUserByEmail(email);

        if(user == null)
            throw new Exception("No such user exception");

        return mapper.UserToUserModel(user);
    }

    @Override
    public UserModel findUserByEmailAndPassowrd(String email, String password) throws Exception {
        if(email == null || email.isEmpty()) {
            throw new Exception("Id is out of range");
        }

        User user = userRepository.getUserByEmailAndPassword(email, password);

        if(user == null)
            throw new Exception("No such user exception");

        return mapper.UserToUserModel(user);
    }

}
