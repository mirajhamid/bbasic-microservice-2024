package miraj.basicmicroservice2024.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeneralResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 3910855802820231102L;
    private int statusCode;
    private String statusDesc;
    private String messageId;
    private String message;
}
