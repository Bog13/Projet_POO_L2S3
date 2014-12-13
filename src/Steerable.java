/**
 * Element possedant une direction et une position pouvant changer 
 * @author Sylvain DUMONTET
 * @author Berenger OSSETE GOMBE
 */
public interface Steerable
{
    abstract Direction getDirection();
    abstract void setDirection(Direction dir);
    abstract Position getPosition();
    abstract void setPosition(Position pos);

}
