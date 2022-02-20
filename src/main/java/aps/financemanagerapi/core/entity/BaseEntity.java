package aps.financemanagerapi.core.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    @Column(name = "ID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ID id;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public BaseEntity(ID id) {
        this.id = id;
    }
}