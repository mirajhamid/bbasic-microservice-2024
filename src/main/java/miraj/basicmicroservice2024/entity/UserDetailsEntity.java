package miraj.basicmicroservice2024.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;

@NoArgsConstructor
@Data
@Accessors(chain = true)
@Entity
@Table(name = "user_details",
        indexes = {@Index(name = "i_user_details_primary",  columnList="userId", unique = true),
                @Index(name = "i_user_details_age", columnList="age", unique = false)})
public class UserDetailsEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -5581507750646938544L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String firstName;
    private String lastName;
    @Column(columnDefinition = "integer default 25")
    private int age;
    @Column(columnDefinition = "integer default 0")
    private int userType;
}
