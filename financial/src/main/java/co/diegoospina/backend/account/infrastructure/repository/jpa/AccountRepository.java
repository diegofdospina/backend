package co.diegoospina.backend.account.infrastructure.repository.jpa;

import co.diegoospina.backend.account.infrastructure.repository.jpa.entity.AccountEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    Optional<AccountEntity> findByUser_Username(String userUsername);

}
