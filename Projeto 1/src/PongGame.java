import java.io.IOException;

public class PongGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.start();

        try {
            game.join();
        } catch (InterruptedException e) {
            System.out.println("O jogo foi interrompido.");
        }

        try {
            game.saveScore("score.txt", "Pontuação final: Jogador vs Computador");
            String score = game.loadScore("score.txt");
            System.out.println("Pontuação salva: " + score);
        } catch (IOException e) {
            System.out.println("Erro ao salvar ou carregar a pontuação: " + e.getMessage());
        }
    }
}
