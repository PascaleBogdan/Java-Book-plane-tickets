package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SearchForFlights extends JFrame {
    private final GestorEvenimente ge;
    private FlightsAgenda fa;
    private final JTextArea ta;
    private final JTextField from, to, departureDate, rt;
    private final JButton search, showList;
    public String returnDate;
    JPanel panel; 

    public SearchForFlights() {
        super("Seach for a flight");

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBackground(Color.CYAN);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        panel.add(new JLabel("From:"));
        from = new JTextField(10);
        panel.add(from);
        panel.add(new JLabel("To"));
        to = new JTextField(10);
        panel.add(to);
        panel.add(new JLabel("Departure date:"));
        departureDate = new JTextField(10);
        panel.add(departureDate);
        panel.add(new JLabel("Return date:"));
        rt = new JTextField(10);
        panel.add(rt);

        ge = new GestorEvenimente();
        showList = new JButton("List available flights");
	showList.addActionListener(ge);
	panel.add(showList, BorderLayout.CENTER);
       
        search = new JButton("Search flights");
        search.addActionListener(ge);
        panel.add(search);

        add(panel,BorderLayout.NORTH);

        ta = new JTextArea(10, 50);
        add(ta);
	setSize(300, 200);
	setLocation(300, 300);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public String getReturnDate(){
        return this.returnDate;
    }

    private class GestorEvenimente implements ActionListener {
        private Frame f;

        GestorEvenimente() {
            fa = FlightsAgenda.getInstance();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == search) {
                String searchInput = from.getText() + " " + to.getText() + " " + departureDate.getText() + " " + rt.getText();

                if(fa.findSearchedFlight(searchInput)) 
                {
                    ta.setText("Flight(s) found!");
                    returnDate = rt.getText(); 
                    fa.setReturnDate(returnDate);
                    f = new Results();
				    f.setSize(830, 618);
				    f.setLocation(300,100);
				    f.setVisible(true);
                    
                }
                ta.setText("No flights found for this search...");
                departureDate.setText("");
                rt.setText("");
            }

            if (e.getSource() == showList) {
                f = new ShowFlights();
				f.setSize(480, 320);
				f.setLocation(420,100);
				f.setVisible(true);
            }

        }
    }
}