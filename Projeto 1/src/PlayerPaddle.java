public class PlayerPaddle extends Paddle {
    public PlayerPaddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
    }

    @Override
    public void move() {
    }

    @Override
    public void draw() {
        System.out.println("PlayerPaddle at (" + x + ", " + y + ")");
    }

    @Override
    public boolean checkCollision(GameObject other) {
        return super.checkCollision(other);
    }
}
