package afvink6;

import afvink6.Translator.NotAnAA;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class AA extends JFrame implements ActionListener {
    private JTextField inSeq;
    private JLabel sequence;
    private JPanel percentage; 
    private JButton translate; 

    
    public static void main(String[] args) {
       AA frame = new AA();
       frame.setSize(500, 300);
       frame.createGUI();
       frame.show();
    }

    private void createGUI() {
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       Container window = getContentPane();
       window.setLayout(new FlowLayout());
       window.setBackground(Color.pink);
        sequence = new JLabel();
        inSeq = new JTextField();
        translate = new JButton();
        percentage = new JPanel();
        
        sequence.setText("Sequentie");
        translate.setText("Analyseer");
        translate.setBackground(Color.WHITE);
        
        inSeq.setPreferredSize(new Dimension(200,100));
        translate.setPreferredSize(new Dimension(100,25));
        percentage.setPreferredSize(new Dimension(400,100));
        
        window.add(sequence);
        window.add(inSeq);
        window.add(translate);
        window.add(percentage);
        
        translate.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {                                          
       if (event.getSource() == translate) {
        String sequentie = inSeq.getText().toUpperCase();
        System.out.println(sequentie);
        
        try{
             //percentage uitrekenen van Polair en Apolair
          int PerP = Translator.Polair(sequentie);
          System.out.println(PerP);
          int PerA = Translator.Apolair(sequentie);
          System.out.println(PerA);
          int Totaal = PerA+PerP;
          int PercP = 100/Totaal*PerP;
          System.out.println(PercP);
          int PercA = 100/Totaal*PerA;
          System.out.println(PercA);
          //grafiek uittekenen, cyan is polair, magenta is apolair
          Graphics paper = percentage.getGraphics();
          paper.clearRect(0, 0, 400, 100);
          paper.setColor(Color.CYAN);
          paper.fillRect(0, 0, PercP*4, 50);
          paper.setColor(Color.black);
          paper.drawString("Polair"+PercP+"%",Math.round(PercP*4), 25);
          paper.setColor(Color.MAGENTA);
          paper.fillRect(0, 50, PercA*4, 50);
          paper.setColor(Color.black);
          paper.drawString("Apolair"+PercA+"%",Math.round(PercA*4), 75);
          
         }  catch (NotAnAA err) {
            System.out.println("Dit is geen aminozuur");
      
         }
        }
    }

}