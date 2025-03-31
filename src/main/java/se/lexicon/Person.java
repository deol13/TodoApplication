package se.lexicon;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    private AppUser credentials;

    //todo: Most of them are not allowed to be null, but they can be in constructor, fix it!
    Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) throw new IllegalArgumentException("FName should not be null or empty");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) throw new IllegalArgumentException("LName should not be null or empty");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) throw new IllegalArgumentException("Email should not be null or empty");
        this.email = email;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    // Overrides equals from Java.Lang.Object
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Person user = (Person) other;
        return id == user.id && firstName.equals(user.firstName) && lastName.equals(user.lastName) && email.equals(user.email);
    }

    // Overrides hashCode from Java.Lang.Object
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id;
        hash = 31 * hash + firstName.hashCode();
        hash = 31 * hash + lastName.hashCode();
        hash = 31 * hash + email.hashCode();
        return hash;
    }

    // Overrides toString from Java.Lang.Object
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person ID: ").append(id);
        sb.append("\nName: ").append(firstName).append(" ").append(lastName);
        sb.append("\nEmail: ").append(email);
        return sb.toString();
    }
}
