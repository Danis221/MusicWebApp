package ru.itis.dto;

public class UserDto {

    private String firstname;
    private String lastname;
    private String login;

    public UserDto(String firstname, String lastname, String login) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
