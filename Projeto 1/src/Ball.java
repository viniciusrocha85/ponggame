public abstract class Ball extends GameObject implements Movable, Drawable, Collidable {
    protected int xSpeed, ySpeed;

    public Ball(int x, int y, int width, int height, int xSpeed, int ySpeed) {
        super(x, y, width, height);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
}
