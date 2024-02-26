package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FlightsList extends JFrame {
	private FlightsAgenda fa;
	private final GestorEvenimente ge;
        private final JPanel p1,p2;
        private JLabel flightDetailsText;
        
	private final JButton goSearch;
	private JButton cancel;
	private final JButton[] b;
        private int i;
	public FlightsList() {
            
		super("Flights Agenda");
		setLocation(150, 10);
		setLayout(new BorderLayout());
		p1 = new JPanel();               
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.CYAN);
		p1.setBorder(BorderFactory.createEmptyBorder(15,30,15,30));
                
		p2 = new JPanel();                      
		p2.setLayout(new GridLayout(13, 2, 10, 10));
                p2.setBackground(Color.CYAN);     
               	p2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
                
		ge = new GestorEvenimente();
		goSearch = new JButton("Search for a flight");
                goSearch.setBackground(Color.MAGENTA);
		goSearch.addActionListener(ge);
                goSearch.setForeground(Color.WHITE);
		p1.add(goSearch, BorderLayout.CENTER);
                
		fa = FlightsAgenda.getInstance();
		String[] c;
		String meow = fa.getFlights();
		c= meow.split("\n");
		b= new JButton[12];
	
		for (i=0; i<c.length; i++)						
		{
			flightDetailsText = new JLabel(c[i]);
			flightDetailsText.setBounds(20, 20, 100, 5);
			b[i] = new JButton("Choose flight");
                        b[i].setBackground(Color.MAGENTA);
                        b[i].setForeground(Color.WHITE);
                        p2.add(flightDetailsText);
			p2.add(b[i], BorderLayout.CENTER);
                        b[i].addActionListener((ActionEvent e) -> {
                        });
                      
                
             
                        add(p1, BorderLayout.CENTER);
                        add(p2, BorderLayout.SOUTH);

                        cancel = new JButton("Cancel");
                        cancel.addActionListener(ge);
                        p2.add(cancel, BorderLayout.SOUTH);
                        cancel.setBackground(Color.MAGENTA);
                        cancel.setForeground(Color.WHITE);
                        
                        /*JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        scrollPane.setPreferredSize(new Dimension(600, 600));
                        this.add(scrollPane);
                        */
                }
                           
                for(i = 0;i<12;i++){
                    b[i].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent ae){
                            dispose();
                            ClassType ClassType = new ClassType();
                            ClassType.setSize(850,290);
                            ClassType.setVisible(true);
                        }
                    });
                
                /*JScrollPane scrollPane = new JScrollPane(p2,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setPreferredSize(new Dimension(600, 600));
                this.add(scrollPane); */
                
                }
        }
        
        
private class GestorEvenimente implements ActionListener {

		private JFrame f;

		GestorEvenimente(){
			fa = FlightsAgenda.getInstance();
		}
	
                @Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == cancel) {
				FlightsList.this.dispose();
			  } 

			if (e.getSource() == goSearch) {
				f = new SearchForFlights();
				f.setSize(700, 300);
				f.setLocation(420,420);
				f.setVisible(true);
			}
		}

	  }
}

