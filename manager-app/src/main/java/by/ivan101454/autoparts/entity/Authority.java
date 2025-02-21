package by.ivan101454.autoparts.entity;

import by.ivan101454.autoparts.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authority", schema = "user_management")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID authority_id;
    @Column(name = "authority")
    @Enumerated(value = EnumType.STRING)
    private Role role;
}
