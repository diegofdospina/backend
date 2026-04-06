package co.diegoospina.backend.account.infrastructure.repository.jpa.entity;

import co.diegoospina.backend.shared.infrastructure.repository.jpa.entity.AbstractAuditableEntity;
import co.diegoospina.backend.transaction.infrastructure.repository.jpa.entity.TransactionEntity;
import co.diegoospina.backend.user.infrastructure.repository.jpa.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldNameConstants
@Entity
@Table(name = AccountEntity.TABLE_NAME)
public class AccountEntity extends AbstractAuditableEntity {

    public static final String TABLE_NAME = "accounts";

    public static final String COLUMN_NAME_USER_ID = "user_id";
    public static final String COLUMN_NAME_AMOUNT = "amount";

    public static final String FK_NAME_USER_ID = "fk_account_user_id";

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COLUMN_NAME_USER_ID, foreignKey = @ForeignKey(name = FK_NAME_USER_ID))
    private UserEntity user;

    @Default
    @NotNull
    @Column(name = COLUMN_NAME_AMOUNT, precision = 10, scale = 2)
    private BigDecimal amount = BigDecimal.ZERO;

    @Default
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = TransactionEntity.Fields.originAccount
    )
    private List<TransactionEntity> outcomingTransactions = new ArrayList<>();

    @Default
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = TransactionEntity.Fields.destinationAccount
    )
    private List<TransactionEntity> incomingTransactions = new ArrayList<>();

}
