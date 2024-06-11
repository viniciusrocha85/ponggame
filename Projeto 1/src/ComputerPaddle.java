public class ComputerPaddle extends Paddle {
    public ComputerPaddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }

    @Override
    public void move() {
        // Lógica de movimento do computador
    }

    @Override
    public void draw() {
        System.out.println("ComputerPaddle at (" + x + ", " + y + ")");
    }

    @Override
    public boolean checkCollision(GameObject other) {
        return super.checkCollision(other);
    }
}
