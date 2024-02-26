package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClassType extends JFrame{
    private final ButtonGroup checkBoxes;
    private final JCheckBox cb1,cb2,cb3; 
    private FlightsAgenda fa;
    private final GestorEvenimente ge;
    private int pretE=400;
    private int pretB=1400;
    private int pretF=2800;

    private final JButton payment;
    private final JPanel p1,p2,p3;
    private final JTextArea textRoundTrip;
    private final JLabel textFlight,textClass;
    private final JLabel textEc, textBs, textFr;  

    public ClassType(){
        super("Choose Your Class");
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS ));

        fa = FlightsAgenda.getInstance();
        ge = new GestorEvenimente();
        

		p1 = new JPanel();
		p1.setLayout(new BorderLayout(30, -2));
		p1.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
		p1.setBackground(Color.CYAN);
		p2 = new JPanel();
		p2.setLayout(new GridLayout(3,3,10,10));
		p2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		p2.setBackground(Color.CYAN);
		p3 = new JPanel();
		p3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		p3.setBackground(Color.CYAN);


        textRoundTrip= new JTextArea(fa.getRoundTrip());
        textRoundTrip.setEditable(false);
        textFlight = new JLabel("Your flight:");
        textClass = new JLabel("Select your Class:");
        textFlight.setForeground(Color.BLACK);
        textClass.setForeground(Color.BLACK);
        p1.add(textFlight, BorderLayout.NORTH);
        p1.add(textRoundTrip, BorderLayout.CENTER);
        p1.add(textClass, BorderLayout.SOUTH);
        textRoundTrip.setBackground(Color.CYAN);
        
        checkBoxes = new ButtonGroup();
        cb1 = new JCheckBox("Economy class      ||  price: "+pretE+" €");
        cb2 = new JCheckBox("Bussiness class    ||  price: "+pretB+" €");
        cb3 = new JCheckBox("First class        ||  price: "+pretF+" €");
        textEc = new JLabel(">>> budget friendly travel");
        cb1.setForeground(Color.WHITE);
        cb1.setBackground(Color.MAGENTA);
        textBs = new JLabel("<html>>>> flatbed seating fully dedicated cabin, access to airport lounges,</br> dedicated check-in and faster security lines.</html>");
        cb2.setForeground(Color.WHITE);
        cb2.setBackground(Color.MAGENTA);
        textFr = new JLabel("<html>>>> A First ticket gets you our highest level of service on our flights</html>");
        cb3.setForeground(Color.WHITE);
        cb3.setBackground(Color.MAGENTA);
        
        checkBoxes.add(cb1);
        checkBoxes.add(cb2);
        checkBoxes.add(cb3);

        p2.add(cb1);
        p2.add(textEc);
        p2.add(cb2);
        p2.add(textBs);
        p2.add(cb3);
        p2.add(textFr);

        payment=new JButton("Proceed to payment");  
        payment.setBackground(Color.MAGENTA);
        payment.setForeground(Color.WHITE);
        payment.addActionListener(ge);  
        p3.add(payment);

        add(p1); add(p2); add(p3);
    }

    private class GestorEvenimente implements ActionListener {
        private JFrame f;

        GestorEvenimente(){
			fa = FlightsAgenda.getInstance();
		}

        @Override
        public void actionPerformed(ActionEvent e){  

            if(cb1.isSelected()) fa.setTravelClass("economy");
            if(cb2.isSelected()) fa.setTravelClass("bussiness");
            if(cb3.isSelected()) fa.setTravelClass("first");
         
            f = new Payment();
            f.setSize(480, 320);
            f.setLocation(420,100);
            f.setVisible(true);
        }  
    }

}