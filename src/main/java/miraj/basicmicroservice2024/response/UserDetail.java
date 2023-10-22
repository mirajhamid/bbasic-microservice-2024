package miraj.basicmicroservice2024.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserDetail implements Serializable {

    @Serial
    private static final long serialVersionUID = -4883423532373541203L;
    private int userId;
    private String fristName;
    private String lastName;
    private int age;
    @JsonProperty("type")
    private int userType;
}
