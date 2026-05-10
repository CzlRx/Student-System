package src.com.CzlR;

public class User {
    private String Username;
    private String Passwords;
    private String Phonenumber;
    private String id;

    public User() {
    }

    public User(String Username, String Passwords, String Phonenumber, String id) {
        this.Username = Username;
        this.Passwords = Passwords;
        this.Phonenumber = Phonenumber;
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPasswords() {
        return Passwords;
    }

    public void setPasswords(String Passwords) {
        this.Passwords = Passwords;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String Phonenumber) {
        this.Phonenumber = Phonenumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return Username + "      " + Passwords + "      " + Phonenumber + "      " + id;
    }
}
