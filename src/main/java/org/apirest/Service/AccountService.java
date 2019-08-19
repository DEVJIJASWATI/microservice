package org.apirest.Service;

import org.apirest.Entity.RoleEntity;
import org.apirest.Entity.UserEntity;
import org.springframework.stereotype.Service;

public interface AccountService {
    public UserEntity saveUser(String username , String password , String confirmedPassword);
    public RoleEntity save(RoleEntity roleEntity);

    public UserEntity loadByUsername(String username);
    public void addRoleToUser(String username , String rolename);
}
