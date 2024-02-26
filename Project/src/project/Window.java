package project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Window extends JFrame {
	private final GestorEvenimente ge;
	private final JButton[] b;
        private final JLabel text;
        private final JPanel panel;
        
	public Window() {
            super("Fly with us!");
            
            panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1, 5, 25));
            panel.setBackground(Color.CYAN);
            panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
            text = new JLabel("<html>This is the flying reservation app<br>Go ahead and make your choice<br>It is the seventh largest airline in America when measured by fleet size<br>Alaska Airlines is a American airline in Seatac.<html>");
            text.setBounds(20, 20, 100, 100);
            Font font = text.getFont();
            float fontSize = font.getSize()+15;
            text.setFont(font.deriveFont(fontSize)); 
            panel.add(text);
            panel.setFont(font.deriveFont(fontSize));
		String[] s = new String[] {  "Book a flight" , "Modify booking", "Cancel booking"};
		ge = new GestorEvenimente();
		b = new JButton[3];
		for (int i = 0; i < b.length; i++) {
			b[i] = new JButton(s[i]);
                        b[i].setBackground(Color.MAGENTA);
                        b[i].setForeground(Color.WHITE);                  
                        b[i].setFont(font.deriveFont(fontSize));
                        b[i].setBorder(BorderFactory.createEmptyBorder(50, 1, 50, 250));
			b[i].addActionListener(ge);
			panel.add(b[i]);
		}
		add(panel);
	}
	private class GestorEvenimente implements ActionListener {
		private JFrame f;
                @Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == b[0]) {
				f = new FlightsList();
				f.setSize(700, 618);
				f.setLocation(300,100);
				f.setVisible(true);

			} else if (e.getSource() == b[1]) {
				f = new Ticket();	
					f.setLocation(420,100);
					f.setVisible(true);
			}
			else if (e.getSource() == b[2]) {
				f = new Payment();
				f.setVisible(true);
			}	
		}
	}
}