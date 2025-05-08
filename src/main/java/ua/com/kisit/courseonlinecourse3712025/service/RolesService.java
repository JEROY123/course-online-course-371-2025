package ua.com.kisit.courseonlinecourse3712025.service;

import ua.com.kisit.courseonlinecourse3712025.entity.Roles;
import org.springframework.stereotype.Service;
import ua.com.kisit.courseonlinecourse3712025.repository.RolesRepository;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

}
