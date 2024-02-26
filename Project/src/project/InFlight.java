package project;
import java.awt.*;
import javax.swing.*;  
import java.awt.event.*; 
public class InFlight extends JFrame {
    private final JLabel lb;  
    private final JCheckBox[] cb;  
    private final String[] codArr = new String[11];
    private final JButton b;  
    private FlightsAgenda fa;
    private final GestorEvenimente ge;
    private final ButtonGroup checkBoxGroup;          //ca sa bifezi maxim o casuta
    
    public InFlight(){  
        super("Inbound Flight");
        setLocation(150, 10);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 
         getContentPane().setBackground(Color.CYAN);
        lb=new JLabel("Choose Return Flight:"); 
        lb.setForeground(Color.BLACK);
        lb.setFont(lb.getFont().deriveFont(20.0f));
        lb.setBounds(50,50,300,20);
        add(lb);

        fa = FlightsAgenda.getInstance();
		String[] inf;
		String inbFlights = fa.getInboundFlights();
        checkBoxGroup = new ButtonGroup();
        ge = new GestorEvenimente();
		inf= inbFlights.split("\n");
        cb = new JCheckBox[inf.length];        
        for (int i=0; i<inf.length; i++)						
		{
			cb[i]  = new JCheckBox("Flight: "+inf[i]);  
                        cb[i].setBackground(Color.CYAN);
            checkBoxGroup.add(cb[i]);
            codArr[i] = inf[i].split(" ")[0]; System.out.println("cod in inbound === "+codArr[i]);
            add(cb[i]);
		}
        b=new JButton("Choose flight");  
        b.setBackground(Color.MAGENTA);
        b.setForeground(Color.WHITE);
        b.setBounds(100,25,80,30);  
        b.addActionListener(ge);  
        add(b);  

        setVisible(true);  
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);  
    }  
 private class GestorEvenimente implements ActionListener {
        private JFrame f;

        GestorEvenimente(){
			fa = FlightsAgenda.getInstance();
		}

        @Override
        public void actionPerformed(ActionEvent e){  
            for(int i=0;i<cb.length;i++)
            {
                if (cb[i].isSelected()){
                   
                    fa.setCodIn(codArr[i]);
                    fa.setRoundTrip();
                    f = new ClassType();
                    f.setSize(650, 420);
					f.setLocation(420,100);
					f.setVisible(true);
                    System.out.println("coduri alese: "+fa.getRoundTrip());
                }
            }
        }  
    }
    
}