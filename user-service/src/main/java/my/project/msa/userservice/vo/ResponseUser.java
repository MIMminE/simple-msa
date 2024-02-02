package my.project.msa.userservice.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResponseUser {

    @Email
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than 2")
    private String email;

    @NotNull
    @Size(min = 2)
    private String name;

    @NotNull
    private String userId;
}
