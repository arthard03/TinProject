package tin.tinproject.DTO;

import tin.tinproject.Model.User;

public class UserDTO {
    private Long id;
    private String name;

    public UserDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserDTO fromUser(User user) {
        return new UserDTO(user.getId_user(), user.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
