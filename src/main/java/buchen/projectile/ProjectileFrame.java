package buchen.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileFrame extends JFrame
{
    private final JSlider velocityField;
    private final JTextField secondsField;
    private final JSlider angleField;
    private final JLabel valX;
    private final JLabel valY;
    private final JLabel peakY;
    private final JLabel interceptX;
    private final JLabel angleVal;
    private final JLabel velocityVal;
    private final ProjectileGraph graph = new ProjectileGraph();

    public ProjectileFrame()
    {
        setSize(900, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        //tell the JFrame to use this JPanel
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(10, 2));
        angleField = new JSlider(JSlider.HORIZONTAL, 0, 90, 31);
        angleField.setMajorTickSpacing(10);
        angleField.setMinorTickSpacing(5);
        angleField.setPaintTicks(true);
        angleField.setPaintLabels(true);
        velocityField = new JSlider(JSlider.HORIZONTAL, 0, 100, 65);
        velocityField.setMajorTickSpacing(10);
        velocityField.setMinorTickSpacing(5);
        velocityField.setPaintTicks(true);
        velocityField.setPaintLabels(true);
        JLabel velocityLabel = new JLabel("Velocity");
        west.add(velocityLabel);
        west.add(velocityField);
        JLabel valVelocity = new JLabel();
        west.add(valVelocity);
        velocityVal = new JLabel();
        west.add(velocityVal);
        JLabel angleLabel = new JLabel("Angle");
        west.add(angleLabel);
        west.add(angleField);
        JLabel valAngle = new JLabel();
        west.add(valAngle);
        angleVal = new JLabel();
        west.add(angleVal);
        JLabel secondsLabel = new JLabel("Seconds");
        west.add(secondsLabel);
        secondsField = new JTextField();
        secondsField.setText("2.7");
        west.add(secondsField);
        JLabel labelX = new JLabel("X");
        west.add(labelX);
        valX = new JLabel();
        west.add(valX);
        JLabel labelY = new JLabel("Y");
        west.add(labelY);
        valY = new JLabel();
        west.add(valY);
        JLabel peakLabelY = new JLabel("Peak Y");
        west.add(peakLabelY);
        peakY = new JLabel();
        west.add(peakY);
        JLabel interceptLabelX = new JLabel("Intercept X");
        west.add(interceptLabelX);
        interceptX = new JLabel();
        west.add(interceptX);
        west.add(new JLabel());

        velocityField.addChangeListener(e ->
                updateProjectile());

        secondsField.getDocument().addDocumentListener(
                (SimpleDocumentListener) e -> updateProjectile());

        angleField.addChangeListener(e ->
                updateProjectile());

        main.add(graph, BorderLayout.CENTER);
    }

    private void updateProjectile()
    {
        Projectile projectile = new Projectile(
                angleField.getValue(),
                velocityField.getValue()
        );
        projectile.setSeconds(
                Double.parseDouble(secondsField.getText())
        );
        valX.setText(Double.toString(projectile.getX()));
        valY.setText(Double.toString(projectile.getY()));
        angleVal.setText(Double.toString(angleField.getValue()));
        velocityVal.setText(Double.toString(velocityField.getValue()));
        peakY.setText(Double.toString(projectile.getPeakY()));
        interceptX.setText(Double.toString(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }
}