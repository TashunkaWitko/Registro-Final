package it.pi.registro.registro.repository;

import it.pi.registro.registro.dto.response.UserDateResponseDTO;
import it.pi.registro.registro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Query("SELECT u from User u where u.email = :email AND u.userType.type = :type")
    User findByEmailAndType(@Param("email")String email, @Param("type")String type);

    @Query("SELECT u from User u where u.userDetail IS NULL")
    List<User> findUsersWhereDetailIsNull();

    @Query("SELECT u FROM User u WHERE " +
            "(:isCaseSensitive = false AND (u.firstName LIKE CONCAT(:name, '%') OR u.lastName LIKE CONCAT(:name, '%'))) OR " +
            "(:isCaseSensitive = true AND (LOWER(u.firstName) LIKE LOWER(CONCAT(:name, '%')) OR LOWER(u.lastName) LIKE LOWER(CONCAT(:name, '%')))) " +
            "ORDER BY u.birth_date DESC")
    List<User> findUsersWithString(@Param("name") String name, @Param("isCaseSensitive") Boolean isCaseSensitive);

}

