package ua.com.kisit.courseonlinecourse3712025.repository;

import ua.com.kisit.courseonlinecourse3712025.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Long id(Long id);

}
