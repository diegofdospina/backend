package co.diegoospina.backend.account.application.port.out;

import co.diegoospina.backend.account.domain.Account;
import co.diegoospina.backend.user.domain.User;
import java.util.Optional;

public interface AccountRepositoryPort {

    Optional<Account> findByUser(User user);

    Account save(Account account);

}
