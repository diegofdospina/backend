package co.diegoospina.backend.account.infrastructure.repository.jpa.entity;

import co.diegoospina.backend.shared.infrastructure.repository.jpa.entity.AbstractAuditableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = Account.TABLE_NAME)
public class Account extends AbstractAuditableEntity {

    public static final String TABLE_NAME = "account";

    

}
