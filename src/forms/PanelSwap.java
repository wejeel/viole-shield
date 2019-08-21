/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author WEJE
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class PanelSwap
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setContentPane(new ComplexPanel());
        f.setSize(400,400);
        f.setLocation(200,200);
        f.setVisible(true);
    }
}
  
class ComplexPanel extends JPanel
{
    CardLayout cards;
    JPanel panel;
  
    public ComplexPanel()
    {
        JButton toggle = new JButton("toggle visibility");
        toggle.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                cards.next(panel);
            }
        });
        JPanel north = new JPanel();
        north.add(toggle);
        JPanel
           red = new JPanel(),
           green = new JPanel(),
           blue = new JPanel();
        red.setBackground(Color.red);
        green.setBackground(Color.green);
        blue.setBackground(Color.blue);
        JPanel color = new JPanel(new GridLayout(0,1));
        color.add(red);
        color.add(green);
        color.add(blue);
        JLabel label = new JLabel("intentionally left blank", JLabel.CENTER);
        JPanel cover = new JPanel(new BorderLayout());
        cover.add(label);
        cards = new CardLayout();
        panel = new JPanel(cards);
        panel.add("cover", cover);
        panel.add("color", color);
        setLayout(new BorderLayout());
        add(north, "North");
        add(panel);
        setOpaque(true);  // just in case
    }
}
