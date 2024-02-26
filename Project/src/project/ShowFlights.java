package project;

import java.awt.*;
import javax.swing.*;

public class ShowFlights extends JFrame {
	private final FlightsAgenda fa;
	public ShowFlights() {

		super("Show Available Flights");

		fa = FlightsAgenda.getInstance();

		String[] c;
		String meow = fa.getFlights();
		c= meow.split("\n");

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(12, 2, 10, 10));
		p.setBorder(BorderFactory.createEmptyBorder());

                for (String c1 : c) {
                JLabel text1 = new JLabel(c1);
                text1.setBounds(20, 20, 100, 10);
                p.add(text1);
            }

		add(p);
	}

}