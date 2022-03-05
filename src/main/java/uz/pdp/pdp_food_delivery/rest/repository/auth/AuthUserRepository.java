package uz.pdp.pdp_food_delivery.rest.repository.auth;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.enums.Department;
import uz.pdp.pdp_food_delivery.rest.enums.Role;
import uz.pdp.pdp_food_delivery.rest.repository.BaseRepository;

import java.util.Optional;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {

    Page<AuthUser> findAllByDeleted(boolean deleted, Pageable pageable);

    @Query(value = "select u.language from users.user u where u.chat_id = :chatId", nativeQuery = true)
    String getLanguage(@Param(value = "chatId") String chatId);


    @Query(value = "select u.role from users.user u where u.chat_id = :chatId", nativeQuery = true)
    String findRoleByChatId(@Param(value = "chatId") String chatId);

    @Query(value = "select u.role from users.user u where u.chat_id = :chatId", nativeQuery = true)
    String getRole(@Param(value = "chatId") String chatId);

    boolean existsByChatId(String chatId);

    @Query(value = "select u.active from users.user u where u.chat_id = :chatId", nativeQuery = true)
    boolean isActive(@Param(value = "chatId") String chatId);

    Optional<AuthUser> findByIdAndDeleted(Long id, boolean deleted);

    AuthUser findByPhoneNumber(String phoneNumber);


    AuthUser getByChatId(String chatId);

    //    @Query(value = "select u.* from users.user u where u.role=:role  and u.department=:dep",nativeQuery = true)
    AuthUser getByDepartmentAndRole(Department dep, Role role);

    @Query(value = "select u.* from users.user u where u.chat_id = :chatId", nativeQuery = true)
    AuthUser findByChatId(@Param(value = "chatId") String chatId);

    @Query(value = "select u.role from users.user u where u.chat_id =:chatId", nativeQuery = true)
    String getRoleByChatId(String chatId);

}

