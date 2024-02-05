package my.project.msa.userservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import my.project.msa.userservice.vo.response.ResponseOrder;

import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private String email;
    private String pwd;
    private String name;
    private String userId;
    private Date createdAt;

    private String encryptedPwd;

    private List<ResponseOrder> orders;
}
