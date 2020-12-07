package model;

import java.io.Serializable;

public class LoginResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private String username;
    private String role;
    private String jwt;

    public LoginResponse( String username, String role, String jwt ) {
        this.username = username;
        this.role = role;
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getJwt() {
        return jwt;
    }
}
