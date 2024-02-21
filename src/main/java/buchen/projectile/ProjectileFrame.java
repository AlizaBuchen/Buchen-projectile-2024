package buchen.projectile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame
{
    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        JLabel yLabel = new JLabel("Y");
        JLabel peakYLabel = new JLabel ("Peak Y");
        JLabel interceptXLabel = new JLabel("Intercept X");
        setLayout(new GridLayout(8, 2));
        JSlider angleField = new JSlider(JSlider.HORIZONTAL, 0, 90, 45);
        angleField.setMajorTickSpacing(10);
        angleField.setMinorTickSpacing(5);
        angleField.setPaintTicks(true);
        angleField.setPaintLabels(true);
        JTextField velocityField = new JTextField();
        JTextField secondsField = new JTextField();
        JLabel x = new JLabel();
        JLabel y = new JLabel();
        JLabel yPeak = new JLabel();
        JLabel xIntercept = new JLabel();
        JButton calculateButton = new JButton("Calculate");

        add(velocityLabel);
        add(velocityField);
        add(angleLabel);
        add(angleField);
        add(secondsLabel);
        add(secondsField);

        add(xLabel);
        add(x);
        add(yLabel);
        add(y);
        add(peakYLabel);
        add(yPeak);
        add(interceptXLabel);
        add(xIntercept);
        add(new JLabel());
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateProjectile(velocityField, secondsField, angleField, x, y, yPeak, xIntercept);
            }
        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener()
        {
            @Override
            public void update(DocumentEvent e)
            {
                {
                    updateProjectile(velocityField, secondsField, angleField, x, y, yPeak, xIntercept);
                }
            }
        });
        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener()
        {
            @Override
            public void update(DocumentEvent e) {
                updateProjectile(velocityField, secondsField, angleField, x, y, yPeak, xIntercept);
            }
        });

        angleField.addChangeListener(e -> updateProjectile(velocityField, secondsField, angleField, x, y, yPeak, xIntercept));
    }

    private void updateProjectile(JTextField velocityField, JTextField secondsField, JSlider angleField, JLabel x, JLabel y, JLabel yPeak, JLabel xIntercept)
    {
            Projectile projectile = new Projectile(
                    Double.parseDouble(velocityField.getText()),
                    angleField.getValue()
            );
            projectile.setSeconds(
                    Double.parseDouble(secondsField.getText())
            );
            x.setText(Double.toString(projectile.getX()));
            y.setText(Double.toString(projectile.getY()));
            yPeak.setText(Double.toString(projectile.getPeakY()));
            xIntercept.setText(Double.toString(projectile.getInterceptX()));
    }
}