package com.concord.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.concord.Entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, Long> {
}
