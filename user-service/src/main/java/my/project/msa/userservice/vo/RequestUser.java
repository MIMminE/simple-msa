package my.project.msa.userservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RequestUser {

    @Email
    @NotNull(message="Email cannot be null")
    @Size(min = 2, message = "Email not be less than 2")
    private String email;

    @NotNull(message = "...")
    @Size(min = 8, message = "...")
    private String pwd;

    @NotNull
    @Size(min = 2)
    private String name;
}
