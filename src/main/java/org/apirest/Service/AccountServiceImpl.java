package org.apirest.Service;

import org.apirest.Dao.RoleRepository;
import org.apirest.Dao.UserRepository;
import org.apirest.Entity.RoleEntity;
import org.apirest.Entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountServiceImpl(UserRepository userRepository, RoleRepository roleRepository , BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserEntity saveUser(String username, String password, String confirmedPassword) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null) new RuntimeException("User Already Exist !!");
        if (!password.equals(confirmedPassword)) throw new RuntimeException("Please Confirm your Password");

        UserEntity user_new = new UserEntity();
        user_new.setUsername(username);
        user_new.setActived(true);
        user_new.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user_new);
        addRoleToUser(username , "USER");
        return user_new;
    }

    @Override
    public RoleEntity save(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    @Override
    public UserEntity loadByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        UserEntity user = userRepository.findByUsername(username);
        RoleEntity role = roleRepository.findByRoleName(rolename);
        user.getRoles().add(role);
    }
}
