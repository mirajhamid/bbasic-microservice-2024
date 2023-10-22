package miraj.basicmicroservice2024.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUserRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = -8556062318656042957L;
    private String fristName;
    private String lastName;
    private int age;
}
