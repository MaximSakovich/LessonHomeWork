package homeWork13;

import java.util.Random;
import java.util.Scanner;

public class Batt {

        public static int numRows = 9;
        public static int numCols = 9;

        public static void main(String[] args) {
            char[][] board = createBoard(numRows, numCols);
            placingShipsCertainLength(board);
            char[][] playerBoard = createBoard(numRows, numCols);
            int totalShips = countShips(board);

            System.out.println("Добро пожаловать в игру Морской Бой!");
            Scanner scanner = new Scanner(System.in);

            while (totalShips > 0) {
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
                    System.out.println("Промах. Нужно стараться :)");
                    playerBoard[row][col] = 'O';
                }
            }

            System.out.println("Вы выиграли! Все корабли потоплены.");
        }

        public static char[][] createBoard(int rows, int cols) {
            char[][] board = new char[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    board[i][j] = ' ';
                }
            }
            return board;
        }

        public static void placingShipsCertainLength(char[][] board) {
            Random random = new Random();
            int[] shipLengths = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

            for (int length : shipLengths) {
                placeShip(board, length, random);
            }
        }

        public static void placeShip(char[][] board, int length, Random random) {
            boolean placed = false;

            while (!placed) {
                int row = random.nextInt(numRows);
                int col = random.nextInt(numCols);
                int orientation = random.nextInt(2); // 0 - вертикально, 1 - горизонтально

                if (orientation == 0) {
                    if (row + length <= numRows) {
                        boolean canPlace = true;

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
                                board[i][col] = 'S';
                            }
                            placed = true;
                        }
                    }
                } else {
                    if (col + length <= numCols) {
                        boolean canPlace = true;

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
                                board[row][j] = 'S';
                            }
                            placed = true;
                        }
                    }
                }
            }
        }

        public static void displayBoard(char[][] board) {
            System.out.print("  ");
            for (int col = 0; col < numCols; col++) {
                char colLabel = (char) ('A' + col);
                System.out.print(colLabel + " ");
            }
            System.out.println();

            for (int row = 0; row < numRows; row++) {
                System.out.print((row + 1) + " ");
                for (int col = 0; col < numCols; col++) {
                    char cell = board[row][col];
                    switch (cell) {
                        case 'S':
                        case 'X':
                        case 'O':
                            System.out.print(cell + " ");
                            break;
                        default:
                            System.out.print("_ ");
                    }
                }
                System.out.println();
            }
        }

        public static int[] parseCoordinates(String input) {
            input = input.trim().toUpperCase();
            if (input.length() != 2) {
                return null;
            }
            char colChar = input.charAt(0);
            int row;

            if (colChar < 'A' || colChar >= ('A' + numCols)) {
                return null;
            }

            try {
                row = Integer.parseInt(input.substring(1)) - 1;
            } catch (NumberFormatException e) {
                return null;
            }

            if (row < 0 || row >= numRows) {
                return null;
            }

            return new int[]{row, colChar - 'A'};
        }

        public static boolean isValidShot(char[][] board, int row, int col) {
            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                return false;
            }
            char cell = board[row][col];
            return cell != 'X' && cell != 'O';
        }

        public static char takeShot(char[][] board, int row, int col) {
            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                return '_';
            }
            char cell = board[row][col];

            if (cell == 'S') {
                board[row][col] = 'X';
                return 'X';
            } else if (cell == ' ') {
                board[row][col] = 'O';
                return 'O';
            } else {
                return cell;
            }
        }

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