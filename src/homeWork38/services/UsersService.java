package homeWork38.services;

import homeWork38.models.User;
import homeWork38.repositories.UsersRepository;

public class UsersService { // сервис для работы с пользователями
    private UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository) { // конструктор, чтобы положить конкретный репозиторий
        this.usersRepository = usersRepository;
    }
    public void register(String firstName, String lastName, String email, String password) {
        if (usersRepository.isExistsByEmail(email)) {
            System.err.println("Пользователь с таким email уже есть");
            return;
        }
        User user = new User(firstName, lastName, email, password);
        usersRepository.save(user);
    }
    public User[] getAllUsers() {
        return usersRepository.findAll();
    }
}