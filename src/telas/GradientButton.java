/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpath.telas;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class GradientButton extends JButton {
    private Color color1 = new Color(50, 50, 50);
    private Color color2 = new Color(85, 85, 85);

    public GradientButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setForeground(Color.WHITE); 
        setFocusPainted(false);
        setFont(getFont().deriveFont(Font.BOLD));
        
    }

    public void setGradient(Color c1, Color c2) {
        this.color1 = c1;
        this.color2 = c2;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
        g2.setPaint(gp);

        
        
         g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20); // <- margem de 1px
        super.paintComponent(g); 
        g2.dispose();
    }
}