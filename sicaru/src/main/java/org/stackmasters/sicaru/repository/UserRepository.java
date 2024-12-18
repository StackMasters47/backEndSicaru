package org.stackmasters.sicaru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stackmasters.sicaru.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
