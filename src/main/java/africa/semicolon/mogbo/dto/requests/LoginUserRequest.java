package africa.semicolon.mogbo.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LoginUserRequest {

    private String email;
    private String password;
}
