package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ticket extends JFrame{
    private FlightsAgenda fa;
    private final GestorEvenimente ge;

    JButton button;
    JPanel p0,p1,p2;
    JTextArea textRoundTrip,pname;
    

    public Ticket(){
        super("Ticket");
        fa = FlightsAgenda.getInstance();
        ge = new GestorEvenimente();
        setSize(350,270);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setBackground( Color.CYAN);


        p0 = new JPanel();    
        p0.add(new JLabel("Flight ticket"));
        p0.setBackground(Color.CYAN);
        
        p1 = new JPanel();
        p1.setBackground(Color.CYAN);
        p1.setLayout(new GridLayout(4,2));
        
        p1.add(new JLabel("Passenger name: "));
        pname= new JTextArea(fa.reservation.getName());
        pname.setBackground(Color.CYAN);
        pname.setEditable(false);
        p1.add(pname);

        p1.add(new JLabel("Outbound/inbound flight: "));
        textRoundTrip= new JTextArea(fa.reservation.getroundTrip());
        textRoundTrip.setBackground(Color.CYAN);
        textRoundTrip.setEditable(false);
        p1.add(textRoundTrip);

        p1.add(new JLabel("Travel class: "));
        JTextArea cls= new JTextArea(fa.reservation.gettheClass());
        cls.setBackground(Color.CYAN);
        cls.setEditable(false);
        p1.add(cls);

        p1.add(new JLabel("Reservation code: "));
        JTextArea cd= new JTextArea(fa.reservation.getCodReturn());
        cd.setBackground(Color.CYAN);
        cd.setEditable(false);
        p1.add(cd);

        p2 = new JPanel(); 
        p2.setBackground(Color.CYAN);
        button = new JButton("OK");
        button.setBackground(Color.MAGENTA);
        button.setForeground(Color.WHITE);
        button.addActionListener(ge);
        p2.add(button);

        add(p0);
        add(p1);
        add(p2);
    }

    private class GestorEvenimente implements ActionListener {
        GestorEvenimente(){
			fa = FlightsAgenda.getInstance();
		}
        @Override
        public void actionPerformed(ActionEvent e){  
            if (e.getSource() == button) {
				Ticket.this.dispose();
			  } 
        }  
    }
 
}
