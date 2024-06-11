public class GameBall extends Ball {
    public GameBall(int x, int y, int width, int height, int xSpeed, int ySpeed) {
        super(x, y, width, height, xSpeed, ySpeed);
    }

    @Override
    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    @Override
    public void draw() {
        System.out.println("Ball at (" + x + ", " + y + ")");
    }

    @Override
    public boolean checkCollision(GameObject other) {
        return super.checkCollision(other);
    }

    public void reverseXDirection() {
        xSpeed *= -1;
    }

    public void reverseYDirection() {
        ySpeed *= -1;
    }
}