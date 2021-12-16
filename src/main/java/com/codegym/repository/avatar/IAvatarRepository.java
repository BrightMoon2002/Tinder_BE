package com.codegym.repository.avatar;

import com.codegym.model.user.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAvatarRepository extends JpaRepository<Avatar, Long> {
}
