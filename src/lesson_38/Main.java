package lesson_38;

import lesson_38.repositories.UsersRepository;
import lesson_38.services.UsersService;
import lesson_38.view.Menu;

public class Main {
    public static void main(String[] args) {
        UsersRepository usersRepository  = new UsersRepository();
        UsersService usersService = new UsersService(usersRepository);
        Menu menu = new Menu(usersService);

        menu.run();
    }
}