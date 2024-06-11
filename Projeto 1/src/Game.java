import java.io.*;
import java.util.*;

public class Game extends Thread {
    private PlayerPaddle playerPaddle;
    private ComputerPaddle computerPaddle;
    private GameBall gameBall;
    private boolean running;

    public Game() {
        playerPaddle = new PlayerPaddle(1, 10, 1, 4, 1);
        computerPaddle = new ComputerPaddle(18, 10, 1, 4, 1);
        gameBall = new GameBall(10, 10, 1, 1, 1, 1);
    }

    @Override
    public void run() {
        running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            try {
                System.out.println(this);

                // Movimento do jogador
                System.out.print("Movimento do jogador (W/S): ");
                String move = scanner.nextLine().trim().toUpperCase();
                if (move.equals("W")) {
                    playerPaddle.y = Math.max(0, playerPaddle.y - 1);
                } else if (move.equals("S")) {
                    playerPaddle.y = Math.min(20 - playerPaddle.height, playerPaddle.y + 1);
                }

                // Movimento do computador (simples)
                if (gameBall.y < computerPaddle.y) {
                    computerPaddle.y = Math.max(0, computerPaddle.y - 1);
                } else if (gameBall.y > computerPaddle.y + computerPaddle.height) {
                    computerPaddle.y = Math.min(20 - computerPaddle.height, computerPaddle.y + 1);
                }

                // Movimento da bola
                gameBall.move();

                // Verificar colisões
                if (gameBall.checkCollision(playerPaddle) || gameBall.checkCollision(computerPaddle)) {
                    gameBall.reverseXDirection();
                }

                if (gameBall.y <= 0 || gameBall.y >= 20) {
                    gameBall.reverseYDirection();
                }

                // Verificar se a bola saiu do campo
                if (gameBall.x < 0 || gameBall.x > 20) {
                    running = false;
                    System.out.println("Jogo acabou! " + (gameBall.x < 0 ? "Computador" : "Jogador") + " venceu!");
                }
            } catch (Exception e) {
                System.out.println("Erro no jogo: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public void saveScore(String fileName, String score) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(score);
        writer.close();
    }

    public String loadScore(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String score = reader.readLine();
        reader.close();
        return score;
    }

    @Override
    public String toString() {
        char[][] board = new char[21][21];

        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                board[i][j] = ' ';
            }
        }

        for (int i = 0; i < playerPaddle.height; i++) {
            board[playerPaddle.y + i][playerPaddle.x] = '|';
        }

        for (int i = 0; i < computerPaddle.height; i++) {
            board[computerPaddle.y + i][computerPaddle.x] = '|';
        }

        board[gameBall.y][gameBall.x] = 'O';

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 21; i++) {
            sb.append(board[i]).append("\n");
        }

        return sb.toString();
    }
}
