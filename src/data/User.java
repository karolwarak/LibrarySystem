package data;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {
    private static final long serialVersionUID = -869826077233377457L;

    private String firstName;
    private String lastName;
    private String pesel;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public User(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getPesel(), user.getPesel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getPesel());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + pesel;
    }
}
