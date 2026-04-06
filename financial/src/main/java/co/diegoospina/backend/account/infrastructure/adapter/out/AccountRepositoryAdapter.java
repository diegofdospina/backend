package co.diegoospina.backend.account.infrastructure.adapter.out;

import co.diegoospina.backend.account.application.port.out.AccountRepositoryPort;
import co.diegoospina.backend.account.domain.Account;
import co.diegoospina.backend.account.infrastructure.repository.jpa.AccountRepository;
import co.diegoospina.backend.account.infrastructure.repository.jpa.entity.AccountEntity;
import co.diegoospina.backend.user.domain.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findByUser(User user) {
        log.info("Finding account by user: {}", user.userName());
        Optional<AccountEntity> accountEntity = accountRepository.findByUser_Username(
            user.userName());

        if (accountEntity.isEmpty()) {
            return Optional.empty();
        }

        return null;
    }

    @Override
    public Account save(Account account) {
        return null;
    }

}
