package ua.com.kisit.courseonlinecourse3712025.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.kisit.courseonlinecourse3712025.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
    List<Clients> findAllByUsername(String username);
    List<Clients> findAllByUsernameAndPassword(String username, String password);
    Clients getClientByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO clients_roles_set (clients_set_id, roles_set_id) VALUES (:userId, :roleId)", nativeQuery = true)
    void saveNewRoleForClient(@Param("userId")Long userId, @Param("roleId") Long roleId);
}
