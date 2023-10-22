package miraj.basicmicroservice2024.exception;

import lombok.Data;

import java.io.Serial;

@Data
public class UserException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -2870961563994964484L;
    private final int errorCode;
}
