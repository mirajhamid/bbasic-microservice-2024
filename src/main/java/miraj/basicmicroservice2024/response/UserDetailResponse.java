package miraj.basicmicroservice2024.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDetailResponse extends GeneralResponse {

    @Serial
    private static final long serialVersionUID = -4883453532373541203L;
    private int userId;
    private String fristName;
    private String lastName;
    private int age;

}
