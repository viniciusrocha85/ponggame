public abstract class Paddle extends GameObject implements Movable, Drawable, Collidable {
    protected int speed;

    public Paddle(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = speed;
    }
}
