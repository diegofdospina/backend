package co.diegoospina.backend.shared.infrastructure.repository.jpa.entity;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import java.time.Instant;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractAuditableEntity {

    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_CREATED_AT = "created_at";
    public static final String COLUMN_NAME_UPDATED_AT = "updated_at";
    public static final String COLUMN_NAME_VERSION = "version";

    @Id
    @Tsid
    @NotNull
    @Column(name = COLUMN_NAME_ID)
    private String id;

    @CreatedDate
    @NotNull
    @Column(name = COLUMN_NAME_CREATED_AT)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = COLUMN_NAME_UPDATED_AT)
    private Instant updatedAt;

    @Version
    @Column(name = COLUMN_NAME_VERSION)
    private Integer version;

}
