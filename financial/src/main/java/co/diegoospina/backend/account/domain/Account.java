package co.diegoospina.backend.account.domain;

import co.diegoospina.backend.user.domain.User;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record Account(
    @NonNull String id,
    @NonNull User user,
    @NonNull BigDecimal balance
) {

}
