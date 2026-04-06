package co.diegoospina.backend.concept.infrastructure.repository.jpa.entity;

import co.diegoospina.backend.shared.domain.Status;
import co.diegoospina.backend.shared.infrastructure.repository.jpa.entity.AbstractAuditableEntity;
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
import java.util.ArrayList;
import java.util.List;
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
@Table(name = ConceptEntity.TABLE_NAME)
public class ConceptEntity extends AbstractAuditableEntity {

    public static final String TABLE_NAME = "concepts";

    public static final String COLUMN_NAME_USER_ID = "user_id";
    public static final String COLUMN_NAME_DESCRIPTION = "description";
    public static final String COLUMN_NAME_STATUS = "status";

    public static final String FK_NAME_USER_ID = "fk_concept_user_id";

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = COLUMN_NAME_USER_ID,
        foreignKey = @ForeignKey(name = FK_NAME_USER_ID)
    )
    private UserEntity user;

    @NotNull
    @Column(name = COLUMN_NAME_DESCRIPTION)
    private String description;

    @NotNull
    @Builder.Default
    @Column(name = COLUMN_NAME_STATUS)
    private Status status = Status.ACTIVE;

    @OneToMany(
        mappedBy = ConceptConfigurationEntity.Fields.concept,
        fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<ConceptConfigurationEntity> configurations = new ArrayList<>();

}
