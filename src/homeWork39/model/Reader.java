package homeWork39.model;


import homeWork39.lib.MyArrayListBook;
import homeWork39.lib.MyLinkedListReader;


public class Reader {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    private MyArrayListBook<Book> availableBooks;//список чтобы отслеживать книги, которые взял данный читатель.

    public Reader(String firstName, String lastName, String email, String username, String password, MyArrayListBook<Book> availableBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.availableBooks = availableBooks;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", availableBooks=" + availableBooks +
                '}';
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public MyArrayListBook<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(MyArrayListBook<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }
}
