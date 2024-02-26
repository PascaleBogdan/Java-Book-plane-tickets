package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Results extends JFrame{

        private FlightsAgenda fa;
	private final GestorEvenimente ge;
	private final JButton cancel;
	private final JButton[] button;
	public String[] chosen;
	public String[] codArr = new String[11];
        private final JPanel p1,p2,p3;
        private final JLabel selectText;		
	private int i;

    public Results(){
		super("Search Results");
		setLocation(150, 10);
		setLayout(new BorderLayout());

		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBorder(BorderFactory.createEmptyBorder(15,30,15,30));
		p1.setBackground(Color.MAGENTA);
                
		p2 = new JPanel();
		p2.setLayout(new GridLayout(13, 2, 10, 10));
		p2.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		p2.setBackground( Color.CYAN);
                
		p3 = new JPanel();
		p3.setLayout(new BorderLayout());
		p3.setBorder(BorderFactory.createEmptyBorder(15,30,15,30));
		p3.setBackground( Color.CYAN);


		selectText = new JLabel("Select Outbound Flight:");
                selectText.setForeground(Color.WHITE);
		p1.add(selectText);
		ge = new GestorEvenimente();		
		fa = FlightsAgenda.getInstance();
                
		String[] c;
		String searchReturned = fa.getSearchedFlights();
		c = searchReturned.split("\n");
		button= new JButton[12];
		System.out.println("getsf: --- " + fa.getSearchedFlights()+"\n----------");
	
		for (i=0; i<c.length; i++)						
		{
			JLabel flightDetailsText = new JLabel(c[i]);
			flightDetailsText.setBounds(30, 30, 100, 5);
			button[i] = new JButton("Choose flight");
                        button[i].setBackground(Color.MAGENTA);
                        button[i].setForeground(Color.WHITE); 
			button[i].addActionListener(ge);
			codArr[i] = c[i].split(" ")[0];
                        System.out.println("======cod: "+codArr[i] +"\n");
                        
                        p2.add(flightDetailsText);
			p2.add(button[i], BorderLayout.CENTER);
		}

		add(p1, BorderLayout.NORTH);
                add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		cancel = new JButton("Cancel");
		cancel.addActionListener(ge);
                cancel.setBackground(Color.MAGENTA);
                cancel.setForeground(Color.WHITE);
		p3.add(cancel, BorderLayout.SOUTH);
		
                
	}
	

    private class GestorEvenimente implements ActionListener {
		private JFrame f;

		GestorEvenimente(){
			fa = FlightsAgenda.getInstance();
		}
	
                @Override
		public void actionPerformed(ActionEvent e) {
			
			for(int i=0;i<button.length;i++)
			{
				if (e.getSource() == button[i]){
					fa.listInboundFlights();
					fa.setCodOut(codArr[i]);
					f = new InFlight();
					f.setSize(750, 460);
					f.setLocation(420,100);
					f.setVisible(true);
				}
			}
			if (e.getSource() == cancel) {
				Results.this.dispose();
			  } 
		}
	  }
}



