package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame{

    private FlightsAgenda fa;
    private final JButton button;
    private final GestorEvenimente ge;
    private final JTextField name, cardType, cardNumber, expirationDate;
    private final JPanel p1,p2,p3;
    

    public Payment(){
        super("Payment");
        fa = FlightsAgenda.getInstance();
        ge = new GestorEvenimente();

        setSize(350,270);
        setBackground(Color.CYAN);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        p1 = new JPanel();    
        p1.add(new JLabel("Please input card details:"));
        p1.setBackground(Color.CYAN);
        
        p2 = new JPanel();
	p2.setLayout(new GridLayout(4,2,0,5)); 
        p2.setBackground(Color.CYAN);
        p2.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));

        p2.add(new JLabel("Name on card:"));
        name = new JTextField(10);
        p2.add(name);
        p2.add(new JLabel("Card type:"));
        cardType = new JTextField(10);
        p2.add(cardType);
        p2.add(new JLabel("Card number:"));
        cardNumber = new JTextField(10);
        p2.add(cardNumber);
        p2.add(new JLabel("Expiration date:"));
        expirationDate = new JTextField(10);
        p2.add(expirationDate);

        p3 = new JPanel();
        p3.setBorder(BorderFactory.createEmptyBorder(0,30,0,30));
        p3.setBackground(Color.CYAN);
        p3.add(new JLabel("You will get a seat reservation on the ticket."));
        button=new JButton("Finish payment");
        button.setBackground(Color.MAGENTA);
        button.setForeground(Color.WHITE);
        button.addActionListener(ge);  
        p3.add(button);

        add(p1);
        add(p2);
        add(p3);
    }

    private class GestorEvenimente implements ActionListener {
        private JFrame f;
        GestorEvenimente(){
			fa = FlightsAgenda.getInstance();
		}
        @Override
        public void actionPerformed(ActionEvent e){  
            String codRez;
            codRez=fa.generateRezervCod();
            int max = 10000;
            int min = 1;
            int range = max - min + 1;
            int giveSeat = (int)(Math.random()* range) + min;

            fa.reservation = new Reservation(codRez, name.getText(), cardNumber.getText(), fa.getRoundTrip(), fa.getTravelClass(), giveSeat);
            System.out.println("------------"+fa.reservation);
            fa.addReserv(fa.reservation);
            
            f = new Ticket();
            f.setSize(480, 320);
            f.setLocation(420,100);
            f.setVisible(true);
        }  
    }
 
}
