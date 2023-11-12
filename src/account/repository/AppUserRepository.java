package account.repository;

import account.model.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findAppUserByName(String username);
    Optional<AppUser> findAppUserByEmail(String email);
}
