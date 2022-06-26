package africa.semicolon.mogbo.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
@Document("Users")

public class User {
    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDateTime dateTime = LocalDateTime.now();
}
