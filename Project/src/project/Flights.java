package project;

public class Flights implements Comparable<Flights> {
    private String number, date, depart, departureHour, arrival, arrivalHour, pilot, copilot;
    private int noseats;
    
    public Flights(String cod, String date, String depart, String departureHour, String arrival, String arrivalHour, String pilot, String copilot) {
        this.number = cod;
        this.date = date;
        this.depart = depart;
        this.departureHour = departureHour;
        this.arrival = arrival;
        this.arrivalHour = arrivalHour;  
        this.pilot = pilot;
        this.copilot = copilot;
    }
    public int getNoSeats(){
        return noseats;
    }
    public void modNoSeats(int mod){
        noseats=mod;
    }
    public String getCod() {
        return number;
    }
    public String getDate() {
        return date;
    }
    public String getDepart() {
        return depart;
    }
    public String getDepH() {
        return departureHour;
    }
    public String getArrival() {
        return arrival;
    }
    public String getArrH() {
        return arrivalHour;
    }
    public String getPilot(){
        return pilot;
    }
    public String getCopilot(){
        return copilot;
    }

    public String toString() {
        return number+" "+date+" from: "+depart+" to: "+arrival+"; depart: "+departureHour+"; arrive: "+arrivalHour+"; pilot: "+pilot+"; copilot: "+copilot;
    }

    public int compareTo(Flights o) {
        return (number).compareTo(o.getCod());
    }

}