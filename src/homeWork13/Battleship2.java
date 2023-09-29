package homeWork13;

import java.util.Random;
import java.util.Scanner;

public class Battleship2 {

    public static int numRows = 9; // Количество строк (можно настроить по вашим правилам)
    public static int numCols = 9; // Количество столбцов (можно настроить по вашим правилам)

    public static void main(String[] args) {
        char[][] board = createBoard(numRows, numCols);// Создаем игровое поле
        placingShipsCertainLength(board); // Расставляем корабли на поле
        char[][] playerBoard = createBoard(numRows, numCols);// Создаем поле для отображения выстрелов игрока
        boolean gameOver = false;
        int totalShips = countShips(board);
        while (!gameOver) {
          //  if (totalShips > 0) {System.out.print("");// раскомментировать, чтобы увидеть расположение кораблей
          //  displayBoard(board);}
            displayBoard(playerBoard);
            System.out.println("Введите координаты для выстрела (например, A5): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            int[] coordinates = parseCoordinates(input);
            if (coordinates != null) {
                int row = coordinates[0];
                int col = coordinates[1];
                if (isValidShot(playerBoard, row, col)) {
                    char result = takeShot(board, row, col);
                    if (result == 'X') {
                        System.out.println("Попадание, корабль подбит!");
                        playerBoard[row][col] = 'X';
                        totalShips--;
                    } else if (result == 'O') {
                        System.out.println("Промах. Нужно стараться)");
                        playerBoard[row][col] = 'O';
                    }
                    if (totalShips == 0) {
                        System.out.println("Вы выиграли! Все корабли потоплены.");
                        gameOver = true;
                    }
                } else {
                    System.out.println("Неверные координаты. Попробуйте снова.");
                }
            } else {
                System.out.println("Неверный формат координат. Используйте формат, например, A5.");
            }
        }
    }

    // Метод создает пустое игровое поле
    public static char[][] createBoard(int rows, int cols) {
        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    // Метод для размещения кораблей определенной длины
    public static void placingShipsCertainLength(char[][] board) {
        Random random = new Random();
        int numRows = board.length;
        int numCols = board[0].length;

        // Расставляем один корабль длиной 4 клетки
        for (int i = 0; i < 1; i++) {
            placeShip(board, 4, random, numRows, numCols);
        }
        // Расставляем два корабля длиной 3 клетки
        for (int i = 0; i < 2; i++) {
            placeShip(board, 3, random, numRows, numCols);
        }
        // Расставляем трех корабля длиной 2 клетки
        for (int i = 0; i < 3; i++) {
            placeShip(board, 2, random, numRows, numCols);
        }
        // Расставляем четыре корабля длиной 1 клетка
        for (int i = 0; i < 4; i++) {
            placeShip(board, 1, random, numRows, numCols);
        }
    }

    // Метод для определения не соприкасаются ли корабли друг с другом на расстоянии одного игрового поля
    public static void placeShip(char[][] board, int length, Random random, int numCols, int numRows) {
        boolean placed = false;
        while (!placed) {
            int row = random.nextInt(numRows);
            int col = random.nextInt(numCols);
            int orientation = random.nextInt(2); // 0 - вертикально, 1 - горизонтально
            if (orientation == 0) {
                // Размещаем вертикально
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
                // Размещаем горизонтально
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

    // Метод отображает игровое поле
    public static void displayBoard(char[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;
        // Отображение заголовка с буквами для столбцов
        System.out.print(" ");
        System.out.print("|");
        for (int col = 0; col < numCols; col++) {
            char colLabel = (char) ('A' + col);
            System.out.print(colLabel + "|");
        }
        System.out.println();
        // Отображение игрового поля с клетками и содержимым
        for (int row = 0; row < numRows; row++) {
            System.out.print((row + 1) + "|"); // Отображение номера строки
            for (int col = 0; col < numCols; col++) {
                char cell = board[row][col];
                // Если это корабль, отображаем только символ "S"
                // Если это пустая клетка, отображаем "_"
                // Если это попадание ("X"), отображаем "X"
                // Если это промах ("O"), отображаем "O"
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

    // Метод разбирает введенные координаты (например, "A5" -> [0, 4])
    public static int[] parseCoordinates(String input) {
        input = input.trim().toUpperCase(); // Удалить лишние пробелы и преобразовать в верхний регистр
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

    // Метод проверяет, можно ли сделать выстрел в указанные координаты
    public static boolean isValidShot(char[][] board, int row, int col) {
        int numRows = board.length;
        int numCols = board[0].length;

        // Проверяем, что координаты находятся в пределах игрового поля
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return false; // Координаты выходят за пределы поля
        }

        // Проверяем, что по этим координатам еще не стреляли
        char cell = board[row][col];
        return cell != 'X' && cell != 'O'; // Вернем true, если клетка не содержит попадания ('X') и не содержит промаха ('O')
    }

    // Метод выполняет выстрел в указанные координаты и возвращает результат ('X' - попадание, 'O' - промах)
    public static char takeShot(char[][] board, int row, int col) {
        int numRows = board.length;
        int numCols = board[0].length;
        // Проверяем, что координаты находятся в пределах игрового поля
        if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
            return '_'; // Координаты выходят за пределы поля, возвращаем пробел
        }
        char cell = board[row][col];
        // Проверяем состояние клетки и обновляем ее значение
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

    // Метод подсчитывает количество кораблей на поле
    public static int countShips(char[][] board) {
        int count = 0;
        int numRows = board.length;
        int numCols = board[0].length;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (board[row][col] == 'S') {
                    count++; // Если клетка содержит корабль ('S'), увеличиваем счетчик
                }
            }
        }
        return count;
    }
}
