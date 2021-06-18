package ir.maktab.dto;

public class ManagerDto {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public ManagerDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ManagerDto setPassword(String password) {
        this.password = password;
        return this;
    }
}
