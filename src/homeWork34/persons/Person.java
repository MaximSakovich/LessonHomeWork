package homeWork34.persons;

public class Person {
    private String email;
    private String password;

    public Person(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    // vasya.pupkin@gmail.com.net
    // vasya.pupkin@gmail.net.de
    // vasya.pupkin@gmail.de
    // vasya.pupkin@gmail.com

    /*
    1. @ присутствует и только одна (done)
    2. точка после собаки (done)
    3. после последней точки 2 или больше символов
    4. английский алфавит, цифры, '_', '-', '.', '@'
    5. до собаки должен быть мин 1 символ
     */
    public void setEmail(String email) {
        if (isEmailValid(email)) {
            this.email = email;
        }
    }

    private boolean isEmailValid(String email) {

        // eee@fdff@fdf.com

        // 1. @ присутствует и только одна (done)
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) return false;

        // 2. точка после собаки
        if (email.indexOf('.', indexAt) == -1) return false;

        // 3. после последней точки 2 или больше символов
        // индекс последнего length - 1;
        // индекс пред-последнего  length - 2;

        if (email.lastIndexOf('.') >= email.length() - 2) return false;

        // английский алфавит, цифры, '_', '-', '.', '@'
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);


            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '.'
                    || c == '_' || c == '-' || c == '@')) {
                return false;
            }

        }

        return true;
    }

    public String getPassword() {
        return password;
    }

    /*
    Требования к валидному password
    1. длина >= 8
    2. мин 1 цифра
    3. мин 1 маленькая буква
    4. мин 1 большая буква
    5. мин 1 спец. символ ("!%$@&")
    написать метод валидации isPasswordValid
     */

    public void setPassword(String password) {
        if (isPasswordValid(password)) {
            this.password = password;
        }
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

    @Override
    public String toString() {
        return "Person{" +
                "email='" + email + '\'' +
                '}';
    }
}
