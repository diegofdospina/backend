package co.diegoospina.backend.user.infrastructure.repository.jpa.entity;

import co.diegoospina.backend.account.infrastructure.repository.jpa.entity.AccountEntity;
import co.diegoospina.backend.shared.infrastructure.repository.jpa.entity.AbstractAuditableEntity;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldNameConstants
@Entity
@Table(name = UserEntity.TABLE_NAME)
public class UserEntity extends AbstractAuditableEntity {

    public static final String TABLE_NAME = "users";

    public static final String COLUMN_NAME_USERNAME = "username";
    public static final String COLUMN_NAME_NAME = "name";

    @NotNull
    @Column(name = COLUMN_NAME_NAME)
    private String username;

    @NotNull
    @Column(name = COLUMN_NAME_NAME)
    private String name;

    @Nullable
    @OneToOne(
        mappedBy = AccountEntity.Fields.user,
        cascade = CascadeType.ALL
    )
    private AccountEntity account;

}
