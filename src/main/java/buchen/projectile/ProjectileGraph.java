package buchen.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class ProjectileGraph extends JComponent
{
    Projectile projectile = new Projectile(0, 0);


    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");
    @Override

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.LIGHT_GRAY);

        for (int x = 0; x < getWidth(); x += 30) {
            g.drawLine(x, 0, x, getHeight());
        }

        for (int y = 0; y < getHeight(); y += 30) {
            g.drawLine(0, y, getWidth(), y);
        }

        g.translate(30, getHeight() - 30);
        g.setColor(Color.BLACK);

        g.drawLine(0, 0, getWidth(), 0);
        g.drawLine(0, 0, 0, -(getHeight()));

        Projectile projectileCopy = new Projectile(projectile);
        projectile.setSeconds(0);

        for (int t = 0; t <= projectile.getApexTime() * 2; t++)
        {
            int currentX = (int) projectile.getX();
            int currentY = (int) projectile.getY();
            projectile.setSeconds(t + 1);
            g.drawLine(currentX, -currentY, (int) projectile.getX(), -(int) projectile.getY());
        }

        String locationCenter = "(" + FORMAT.format(projectile.getInterceptX() / 2) + ", "
                + FORMAT.format(projectile.getPeakY()) + ")";
        g.setColor(Color.BLUE);
        g.drawString(locationCenter, (int) (projectile.getInterceptX() / 2), (int) -projectile.getPeakY());
        g.fillOval((int) projectile.getInterceptX() / 2 - 5, (int) -projectile.getPeakY() - 5, 10, 10);


        String locationSeconds = "(" + FORMAT.format(projectileCopy.getX()) + ", "
                + FORMAT.format(projectileCopy.getY()) + ")";
        g.setColor(Color.RED);

        g.drawString(locationSeconds, (int) (projectileCopy.getX()) -30, (int) -projectileCopy.getY() -30);
        g.fillOval((int) projectileCopy.getX() - 5, (int) -projectileCopy.getY() - 5, 10, 10);
    }


    public void setProjectile(Projectile projectile)
    {
        this.projectile = projectile;
        //this tell operating system to call paintComponent again
        repaint();
    }
}


