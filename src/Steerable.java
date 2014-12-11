public interface Steerable
{
    abstract Direction getDirection();
    abstract void setDirection(Direction dir);
    abstract Position getPosition();
    abstract void setPosition(Position pos);

}
