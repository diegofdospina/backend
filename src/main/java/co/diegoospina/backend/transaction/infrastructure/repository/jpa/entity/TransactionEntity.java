package co.diegoospina.backend.transaction.infrastructure.repository.jpa.entity;

import co.diegoospina.backend.account.infrastructure.repository.jpa.entity.AccountEntity;
import co.diegoospina.backend.shared.infrastructure.repository.jpa.entity.AbstractAuditableEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
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
@Table(name = TransactionEntity.TABLE_NAME)
public class TransactionEntity extends AbstractAuditableEntity {

    public static final String TABLE_NAME = "transactions";

    public static final String COLUMN_NAME_VALUE = "value";
    public static final String COLUMN_NAME_ORIGIN_ACCOUNT_ID = "origin_account_id";
    public static final String COLUMN_NAME_DESTINATION_ACCOUNT_ID = "destination_account_id";

    public static final String FK_NAME_ORIGIN_ACCOUNT = "fk_transaction_origin_account";
    public static final String FK_NAME_DESTINATION_ACCOUNT = "fk_transaction_destination_account";

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = COLUMN_NAME_ORIGIN_ACCOUNT_ID,
        foreignKey = @ForeignKey(name = FK_NAME_ORIGIN_ACCOUNT)
    )
    private AccountEntity originAccount;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = COLUMN_NAME_DESTINATION_ACCOUNT_ID,
        foreignKey = @ForeignKey(name = FK_NAME_DESTINATION_ACCOUNT)
    )
    private AccountEntity destinationAccount;

    @Default
    @NotNull
    @Column(name = COLUMN_NAME_VALUE, nullable = false, precision = 10, scale = 2)
    private BigDecimal value = BigDecimal.ZERO;

}
