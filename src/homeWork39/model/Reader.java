package homeWork39.model;


import homeWork39.lib.MyArrayListBook;


public class Reader {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Role role;

    private MyArrayListBook<Book> borrowedBooks;//список чтобы отслеживать книги, которые взял данный читатель.

    public Reader(String firstName, String lastName, String email, String username,
                  String password, MyArrayListBook<Book> borrowedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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

    public MyArrayListBook<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(MyArrayListBook<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

