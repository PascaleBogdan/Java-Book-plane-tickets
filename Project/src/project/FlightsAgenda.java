package project;

import java.util.*;
import java.io.*;

public class FlightsAgenda {
	private TreeSet<Flights> ts, tsSearched, tsInbound, tsRoundTrip;
	private TreeSet<Reservation> tsReserv;
	private BufferedReader br;
	private PrintWriter pw;
	private String l, codOut, codIn;
	private Flights flight;
	public Reservation reservation;
	private static FlightsAgenda instance;
	public boolean success=false;
	private String returnDate;
	private String travelClass; 
        
	private FlightsAgenda() {
		File f = new File("flights.txt");
		ts = new TreeSet<>();
		tsRoundTrip = new TreeSet<>();
		tsReserv = new TreeSet<>();
		String[] s;		
		if (f.exists()) {
			try {
				br = new BufferedReader(new FileReader(f));
				while ((l = br.readLine()) != null) {
					s = l.split(" ");		
					flight = new Flights(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7]);
					ts.add(flight);
				}
			} catch (IOException ioe) {
			}
		} else
			System.out.println("File flights.txt doesn't exist.");
	}
	public void setReturnDate(String newRetDate){
		this.returnDate = newRetDate;
	}
	public String getFlights() {
		System.out.println("--=====-"+tsReserv);
		String rez = "";
		Iterator<Flights> it = ts.iterator();
		while (it.hasNext())
			rez += it.next() + "\n";
		return rez;
	}
	public String getSearchedFlights() {
		String rez = "";
		Iterator<Flights> it = tsSearched.iterator();
		while (it.hasNext())
			rez += it.next() + "\n";
		return rez;
	}
	public TreeSet<Flights> getSearchedFlightsTS() {
		return tsSearched;
	}
	public String getInboundFlights() {
		String rez = "";
		Iterator<Flights> it = tsInbound.iterator();
		while (it.hasNext())
			rez += it.next() + "\n";
		return rez;
	}
	public void setCodOut(String cod){
		this.codOut = cod;
	}
	public void setCodIn(String cod){
		this.codIn = cod;
	}
	public void setRoundTrip() {
		for (Flights f : ts)
		{
			if (codOut.equals(f.getCod()))
				{tsRoundTrip.add(f); }
			if (codIn.equals(f.getCod()))
				tsRoundTrip.add(f);
		}			
	}
	public String getRoundTrip() {				
		String rez = "";
		Iterator<Flights> it = tsRoundTrip.iterator();
		while (it.hasNext())
			rez += it.next() + "\n";
		return rez;
	}

	public String findFlightCod(String cod) {
		for (Flights f : ts)
			if (cod.equals(f.getCod()))
				return f.toString();
		return "There is no flight with this code: " + cod;
	}

	
	public boolean findSearchedFlight(String searched) {
		tsSearched = new TreeSet<>();
		String iterator;
		String[] ss;
		int i=0;
		ss=searched.split(" ");	//"from(ss[0]) to(ss[1]) dept(ss[2]) return(ss[3])" //System.out.println("entered findSearchedFlight:" +ss[0]+" "+ss[1]+" "+ss[2]+" "+ss[3]);  
		this.success=false;

		for (Flights fOut : ts)		//----outbound----
		{			
			iterator = fOut.getDepart() +" "+ fOut.getArrival() +" "+ fOut.getDate(); //System.out.println("iterator for1: "+iterator+". ");	 
			if ( (ss[0] +" "+ ss[1] +" "+ ss[2]).equals(iterator) )
			{
				tsSearched.add(fOut);
				this.success = true;
				i++;
			}	
		}
		if(this.success == true) {
			System.out.println("tsSearched:\n"+getSearchedFlights()+"----\n");
			return true;
		}
		return false;
	}


	public boolean listInboundFlights() {
		tsInbound = new TreeSet<>();
		String iterator;
		int i=0;

		for (Flights fIn : ts)		//----inbound----
		{			
			iterator = fIn.getDate(); 
			if ( returnDate.equals(iterator) )
			{
				tsInbound.add(fIn);
				this.success = true;
				i++;
			}	
		}							//System.out.println("inbo flights\n"+getInboundFlights());
		if(this.success == true) {
			return true;
		}
		return false;
	}

	public void setTravelClass(String x){
		this.travelClass = x;
	}

	public String getTravelClass() {
        return travelClass;
    }

	public void addReserv(Reservation r){
		tsReserv.add(r);
	}
	public String generateRezervCod(){
            int max = 10000;
            int min = 1;
            int range = max - min + 1;
                int cod = (int)(Math.random() * range) + min;
             
		if(tsReserv.isEmpty())
		{
			return String.valueOf(cod);
		} else {
			String x = tsReserv.last().getCodReturn();
			cod = Integer.parseInt(x)+1;
			return String.valueOf(cod);
		}
                
	}
	public void salveaza() {
		try {
			pw = new PrintWriter(new FileWriter("fise.txt"));
			for (Flights f : ts)
				pw.println(f);
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static FlightsAgenda getInstance() {
		if (instance == null)
		instance = new FlightsAgenda();
		return instance;
	}

  
    }

