package org.apirest.Dao;

import org.apirest.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserEntity , Long> {
    public UserEntity findByUsername(String username);
}
