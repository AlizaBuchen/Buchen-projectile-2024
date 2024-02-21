package buchen.projectile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame
{
    private JTextField velocityField;
    private JTextField secondsField;
    private JSlider angleField;
    private JLabel x;
    private JLabel y;
    private JLabel peakY;
    private JLabel interceptX;

    public ProjectileFrame()
    {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));
        angleField = new JSlider(JSlider.HORIZONTAL, 0, 90, 45);
        angleField.setMajorTickSpacing(10);
        angleField.setMinorTickSpacing(5);
        angleField.setPaintTicks(true);
        angleField.setPaintLabels(true);
        velocityField = new JTextField();
        JLabel velocityLabel = new JLabel("Velocity");
        add(velocityLabel);
        add(velocityField);
        JLabel angleLabel = new JLabel("Angle");
        add(angleLabel);
        add(angleField);
        JLabel secondsLabel = new JLabel("Seconds");
        add(secondsLabel);
        secondsField = new JTextField();
        add(secondsField);
        JLabel labelX = new JLabel("X");
        add(labelX);
        x = new JLabel();
        add(x);
        JLabel labelY = new JLabel("Y");
        add(labelY);
        y = new JLabel();
        add(y);
        JLabel peakLabelY = new JLabel("Peak Y");
        add(peakLabelY);
        peakY = new JLabel();
        add(peakY);
        JLabel interceptLabelX = new JLabel("Intercept X");
        add(interceptLabelX);
        interceptX = new JLabel();
        add(interceptX);
        add(new JLabel());
        JButton calculateButton = new JButton("Calculate");
        add(calculateButton);

        calculateButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                updateProjectile();
            }
        });

        velocityField.getDocument().addDocumentListener(new SimpleDocumentListener()
        {
            @Override
            public void update(DocumentEvent e)
            {
                {
                    updateProjectile();
                }
            }
        });
        secondsField.getDocument().addDocumentListener(new SimpleDocumentListener()
        {
            @Override
            public void update(DocumentEvent e) {
                updateProjectile();
            }
        });

        angleField.addChangeListener(e ->
                updateProjectile());
    }

    private void updateProjectile()
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
            peakY.setText(Double.toString(projectile.getPeakY()));
            interceptX.setText(Double.toString(projectile.getInterceptX()));
    }
}