package co.diegoospina.backend.concept.infrastructure.repository.jpa.entity;

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
import java.time.Instant;
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
@Table(name = ConceptConfigurationEntity.TABLE_NAME)
public class ConceptConfigurationEntity extends AbstractAuditableEntity {

    public static final String TABLE_NAME = "concept_configurations";

    public static final String COLUMN_NAME_CONCEPT_ID = "concept_id";
    public static final String COLUMN_NAME_VALUE = "value";
    public static final String COLUMN_NAME_START_DATE = "start_date";
    public static final String COLUMN_NAME_END_DATE = "end_date";

    public static final String FK_NAME_CONCEPT = "fk_concept_configuration_concept";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = COLUMN_NAME_CONCEPT_ID,
        foreignKey = @ForeignKey(name = FK_NAME_CONCEPT)
    )
    private ConceptEntity concept;

    @Default
    @NotNull
    @Column(name = COLUMN_NAME_VALUE, precision = 10, scale = 2)
    private BigDecimal value = BigDecimal.ZERO;

    @NotNull
    @Column(name = COLUMN_NAME_START_DATE)
    private Instant startDate;

    @Nullable
    @Column(name = COLUMN_NAME_END_DATE)
    private Instant endDate;

}
