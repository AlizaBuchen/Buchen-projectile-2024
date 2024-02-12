package buchen.projectile;

public class Projectile {
    private static final double GRAVITY = 9.8;
    private final double velocity;
    private final double radians;
    private double angle;
    private double seconds;

    public Projectile(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
        this.radians = Math.toRadians(angle);
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }

    public double getX() {
        return Math.cos(radians) * velocity * seconds;
    }

    public double getY() {
        return Math.sin(radians) * velocity * seconds - (0.5 * GRAVITY * seconds * seconds);
    }

    /**
     * @return time when projectile is at its highest point
     */
    public double getApexTime() {
        return (velocity * Math.sin(radians)) / GRAVITY;
    }

    /**
     * @return highest Y value of the Projectile
     * Documentation: https://byjus.com/question-answer/the-maximum-height-of-projectile-formula-is/
     */
    public double getPeakY() {
        return (velocity * Math.sin(radians)) * (velocity * Math.sin(radians)) / (GRAVITY * 2);
    }
}