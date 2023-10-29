package homeWork38.models;


public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
        } else {
            System.err.println("Неверный формат пароля. Пожалуйста, введите корректный пароль.");
            System.err.println("Требования к паролю: ");
            System.err.println("Длина >= 8, мин 1 цифра, маленькая буква, большая буква и спец.символ !%$@&");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailValid(String email) {

        int indexAt = email.indexOf('@');
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) return false;
        if (email.indexOf('.', indexAt) == -1) return false;
        if (email.lastIndexOf('.') >= email.length() - 2) return false;
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '.'
                    || c == '_' || c == '-' || c == '@')) {
                return false;
            }
        }
        return true;
    }

    public boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasDigit = false;
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasSpecial = false;
        String specialCharacters = "!%$@&";
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            } else if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (specialCharacters.indexOf(c) != -1) {
                hasSpecial = true;
            }
        }
        return hasDigit && hasLower && hasUpper && hasSpecial;
    }

    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            System.err.println("Неверный формат электронной почты.");
        }
    }
}