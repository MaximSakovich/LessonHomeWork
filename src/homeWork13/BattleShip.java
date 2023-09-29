package homeWork13;

import java.util.Random;
import java.util.Scanner;

public class BattleShip {

    public static int numRows = 9; // Количество строк (можно настроить по вашим правилам)
    public static int numCols = 9; // Количество столбцов (можно настроить по вашим правилам)

    public static void main(String[] args) {
        // Создаем игровое поле и расставляем на нем корабли
        char[][] board = createBoard(numRows, numCols);
        placingShipsCertainLength(board);
        // Создаем поле для отображения выстрелов игрока
        char[][] playerBoard = createBoard(numRows, numCols);
        // Определяем общее количество кораблей на игровом поле
        int totalShips = countShips(board);
        System.out.println("Добро пожаловать в игру Морской Бой!");
        Scanner scanner = new Scanner(System.in);
        // Игровой цикл продолжается, пока есть не потопленные корабли
        while (totalShips > 0) {
            //  if (totalShips > 0) {System.out.print("");// раскомментировать, чтобы увидеть расположение кораблей
            //     displayBoard(board);}
            displayBoard(playerBoard);
            System.out.print("Введите координаты для выстрела (например, A5): ");
            String input = scanner.nextLine();
            int[] coordinates = parseCoordinates(input);
            if (coordinates == null) {
                System.out.println("Неверный формат координат. Используйте формат, например, A5.");
                continue;
            }
            int row = coordinates[0];
            int col = coordinates[1];
            if (!isValidShot(playerBoard, row, col)) {
                System.out.println("Неверные координаты. Попробуйте снова.");
                continue;
            }

            char result = takeShot(board, row, col);

            if (result == 'X') {
                System.out.println("Попадание, корабль подбит!");
                playerBoard[row][col] = 'X';
                totalShips--;
            } else if (result == 'O') {
                System.out.println("Промах. Нужно стараться!!!");
                playerBoard[row][col] = 'O';
            }
        }

        System.out.println("Вы выиграли! Все корабли потоплены.");
    }

    // Метод создает пустое игровое поле и заполняет его пробелами
    public static char[][] createBoard(int rows, int cols) {
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    // Метод для размещения кораблей разной длинны на поле
    public static void placingShipsCertainLength(char[][] board) {
        Random random = new Random();
        int[] shipLengths = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1}; // Размещаем корабли разных длин на игровом поле
        for (int length : shipLengths) {
            placeShip(board, length, random);
        }
    }

    // Метод для определения не соприкасаются ли корабли друг с другом на расстоянии одного игрового поля
    public static void placeShip(char[][] board, int length, Random random) {
        boolean placed = false;

        while (!placed) {
            int row = random.nextInt(numRows);
            int col = random.nextInt(numCols);
            int orientation = random.nextInt(2); // 0 - вертикально, 1 - горизонтально
            if (orientation == 0) {
                // Размещаем корабль вертикально
                if (row + length <= numRows) {
                    boolean canPlace = true;

                    // Проверяем, что корабль не соприкасается с другими кораблями по вертикали
                    for (int i = row - 1; i <= row + length; i++) {
                        for (int j = col - 1; j <= col + 1; j++) {
                            if (i >= 0 && i < numRows && j >= 0 && j < numCols && board[i][j] != ' ') {
                                canPlace = false;
                                break;
                            }
                        }
                        if (!canPlace) {
                            break;
                        }
                    }
                    if (canPlace) {
                        for (int i = row; i < row + length; i++) {
                            board[i][col] = 'S'; // 'S' представляет корабль
                        }
                        placed = true;
                    }
                }
            } else {
                // Размещаем корабль горизонтально
                if (col + length <= numCols) {
                    boolean canPlace = true;

                    // Проверяем, что корабль не соприкасается с другими кораблями по горизонтали
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int j = col - 1; j <= col + length; j++) {
                            if (i >= 0 && i < numRows && j >= 0 && j < numCols && board[i][j] != ' ') {
                                canPlace = false;
                                break;
                            }
                        }
                        if (!canPlace) {
                            break;
                        }
                    }
                    if (canPlace) {
                        for (int j = col; j < col + length; j++) {
                            board[row][j] = 'S'; // 'S' представляет корабль
                        }
                        placed = true;
                    }
                }
            }
        }
    }

    // Метод для отображения игрового поля
    public static void displayBoard(char[][] board) {
        System.out.print("  ");
        // Отображаем заголовок с буквами для столбцов
        for (int col = 0; col < numCols; col++) {
            char colLabel = (char) ('A' + col);
            System.out.print(colLabel + "|");
        }
        System.out.println();

        // Отображаем игровое поле с клетками и их содержимым
        for (int row = 0; row < numRows; row++) {
            System.out.print((row + 1) + "|"); // Отображаем номер строки

            for (int col = 0; col < numCols; col++) {
                char cell = board[row][col];
                // Отображаем содержимое клетки в зависимости от его значения
                switch (cell) {
                    case 'S':
                    case 'X':
                    case 'O':
                        System.out.print(cell + "|");
                        break;
                    default:
                        System.out.print("_|");
                }
            }
            System.out.println();
        }
    }

    // Метод для разбора введенных координат (например, "A5" -> [0, 4])
    public static int[] parseCoordinates(String input) {
        input = input.trim().toUpperCase(); // Удаляем лишние пробелы и преобразуем в верхний регистр

        if (input.length() != 2) {
            return null; // Поддерживается только двух символьный формат (например, "A5")
        }
        char colChar = input.charAt(0);
        int row;
        if (colChar < 'A' || colChar >= ('A' + numCols)) {
            return null;  // Первый символ должен быть буквой столбца
        }
        try {
            row = Integer.parseInt(input.substring(1)) - 1; // Преобразовать номер строки
        } catch (NumberFormatException e) {
            return null; // Неправильный формат номера строки
        }
        if (row < 0 || row >= numRows) {
            return null; // Недопустимый номер строки
        }
        return new int[]{row, colChar - 'A'};
    }

    // Метод для проверки возможности выстрела по указанным координатам
    public static boolean isValidShot(char[][] board, int row, int col) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return false; // Координаты выходят за пределы поля
        }

        char cell = board[row][col];
        return cell != 'X' && cell != 'O'; // Вернем true, если клетка не содержит попадания ('X') и промаха ('O')
    }

    // Метод для выполнения выстрела по указанным координатам
    public static char takeShot(char[][] board, int row, int col) {
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return '_'; // Координаты выходят за пределы поля, возвращаем пробел
        }
        char cell = board[row][col];
        if (cell == 'S') {
            board[row][col] = 'X'; // Попадание
            return 'X';
        } else if (cell == ' ') {
            board[row][col] = 'O'; // Промах
            return 'O';
        } else {
            return cell; // Уже стреляли в эту клетку ранее
        }
    }

    // Метод для подсчета количества кораблей на поле
    public static int countShips(char[][] board) {
        int count = 0;

        for (char[] row : board) {
            for (char cell : row) {
                if (cell == 'S') {
                    count++;
                }
            }
        }

        return count;
    }
}