package br.gov.sp.cps.springlab420261.security;

public class Login {

    private String username;

    private String password;

    private String[] auths;

    private String token;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getAuths() {
        return auths;
    }

    public void setAuths(String[] auths) {
        this.auths = auths;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
