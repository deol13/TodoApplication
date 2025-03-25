package se.lexicon;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

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

    public String getSummary() {
        return "id: " + id
                + ", name: " + firstName + " " + lastName
                + ", email: " + email;
    }
}
