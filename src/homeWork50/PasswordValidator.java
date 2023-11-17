package homeWork50;

public class PasswordValidator {
    public boolean isPasswordValid(String password) throws PasswordValidateException {
        // Пароль должен содержать как минимум 8 символов
        // и иметь хотя бы одну цифру, одну прописную и одну заглавную букву,
        // а также один специальный символ из списка !%$@&.
        if (password.length() < 8) {
            throw new PasswordValidateException("Пароль должен содержать не менее 8 символов");
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

        if (!(hasDigit && hasLower && hasUpper && hasSpecial)) {
            throw new PasswordValidateException("Пароль должен содержать хотя бы одну цифру, одну строчную букву, одну заглавную букву и один специальный символ из списка !%$@&");
        }

        return true;
    }
}

class PasswordValidateException extends Exception {
    public PasswordValidateException(String message) {
        super(message);
    }
}