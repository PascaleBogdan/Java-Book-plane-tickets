package project;

public class Reservation implements Comparable<Reservation> {

    private String codReturn, name, cardNo, roundTrip, Class;
    int seat;

    public Reservation(String codReturn, String name, String cardNo, String roundTrip, String Class, int seat) {
        this.codReturn = codReturn;
        this.name = name;
        this.cardNo = cardNo;
        this.roundTrip = roundTrip;
        this.Class = Class;
        this.seat = seat;
    }

    public String getCodReturn() {
        return codReturn;
    }
    public void setCodR(String codR) {
        this.codReturn = codR;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCardNo() {
        return cardNo;
    }
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
    public String getroundTrip() {
        return roundTrip;
    }
    public void setroundTrip(String roundTrip) {
        this.roundTrip = roundTrip;
    }
    public String gettheClass() {
        return Class;
    }
    public void setClass(String Class) {
        this.Class = Class;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    @Override
    public String toString() {
        return "Reservation{" + "codR=" + codReturn + ", name=" + name + ", card=" + cardNo + ", roundTrip=" + roundTrip + ", tClass=" + Class + ", seat=" + seat + '}';
    }
    @Override
    public int compareTo(Reservation o) {
        return (codReturn).compareTo(o.getCodReturn());
    }
}
