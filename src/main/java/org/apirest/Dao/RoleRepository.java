package org.apirest.Dao;

import org.apirest.Entity.RoleEntity;
import org.apirest.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<RoleEntity , Long> {
    public RoleEntity findByRoleName(String roleName);
}
