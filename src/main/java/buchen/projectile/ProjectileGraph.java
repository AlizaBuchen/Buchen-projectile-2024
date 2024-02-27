package buchen.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent
{
    Projectile projectile = new Projectile(0, 0);

    @Override

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.translate(0, getHeight());
        g.setColor(Color.BLACK);

        for (int t = 0; t <= projectile.getApexTime() * 2; t++)
        {
            int currentX = (int) projectile.getX()
            int currentY = (int) projectile.getY();
            projectile.setSeconds(t);
            g.drawLine(currentX, -currentY, (int) projectile.getX(), -(int) projectile.getY());
        }
        g.setColor(Color.BLUE);
        g.fillOval((int)projectile.getInterceptX() / 2, (int) -projectile.getPeakY(), 15, 15);
    }

    public void setProjectile(Projectile projectile)
    {
        this.projectile = projectile;
        //this tell operating system to call paintComponent again
        repaint();
    }
}


