package homeWork39.service;

import homeWork39.lib.MyArrayListBook;
import homeWork39.model.Role;
import homeWork39.model.Reader;
import homeWork39.repository.ReaderRepository;
import homeWork39.lib.MyLinkedListReader;


public class ReaderService {
    private ReaderRepository readerRepository;
    Role roleName = new Role("some_role");

    public ReaderService() {
        this.readerRepository = new ReaderRepository();
    }

    public void saveReader(Reader reader) {
        readerRepository.addReader(reader);
    }

    public Reader findReaderByName(String firstName, String lastName) {
        for (Reader reader : readerRepository.getAllReaders()) {
            if (reader.getFirstName().equals(firstName) && reader.getLastName().equals(lastName)) {
                return reader;
            }
        }
        return null;
    }

    public void registerUser(String firstname, String lastname, String email, String username, String password) {
       // Role roleName = new Role("some_role");
        Reader newReader = new Reader(firstname, lastname, email, username, password, new MyArrayListBook<>());
        // Добавление нового пользователя в репозиторий
        readerRepository.addReader(newReader);
    }


    public boolean isReaderExistsByEmail(String email) {
        for (Reader reader : readerRepository.getAllReaders()) {
            if (reader.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
/*
      public Reader[] findAllReaders() {
    return readerRepository.getAllReaders().toArray(new Reader[0]);
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
*/
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

    public MyLinkedListReader<Reader> getAllReaders() {
        return readerRepository.getAllReaders();
    }


    public boolean authenticate(String username, String password) {
        for (Reader reader : readerRepository.getAllReaders()) {
            if (reader.getUsername().equals(username) && reader.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

  /*  public void displayUserPermissions() {
        // Логика для отображения прав доступа у пользователей
        for (Reader reader : readerRepository.getAllReaders()) {
            Role role = reader.getRole();
            if (role != null) {
                System.out.println("Пользователь: " + reader.getFirstName() + " " +
                        reader.getLastName() + " Роль: " + role.getRoleName());
            } else {
                System.out.println("Пользователь: " + reader.getFirstName() + " " +
                        reader.getLastName() + " Роль: Не определено");
            }
        }
    }

*/

    public Reader findReaderByUsername(String username) {
        for (Reader reader : readerRepository.getAllReaders()) {
            if (reader.getUsername().equals(username)) {
                return reader;
            }
        }
        return null;
    }
}
