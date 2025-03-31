package se.lexicon;

public class AppUser {
    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty())
            throw new IllegalArgumentException("Username should not be null or empty");
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty())
            throw new IllegalArgumentException("Password should not be null or empty");
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null) throw new IllegalArgumentException("Role should not be null");
        this.role = role;
    }

    // Methods

    // Overrides equals from Java.Lang.Object
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        AppUser user = (AppUser) other;
        return username.equals(user.username) && role.equals(user.role);
    }

    // Overrides hashCode from Java.Lang.Object
    // Using the fields values of the object to generate a unique value as code.
    // If another object of the same class has the exact same values they should generate the same hash code value.
    @Override
    public int hashCode() { //Object other
        int hash = 7;
        hash = 31 * hash + username.hashCode();
        hash = 31 * hash + role.hashCode();
        return hash;
    }
    
    // Overrides toString from Java.Lang.Object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ").append(username);
        sb.append("\nRole: ").append(role);
        return sb.toString();
    }
}
