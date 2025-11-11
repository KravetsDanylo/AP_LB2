package Train;

public class Train {
    private String destination;
    private int number;
    private String shippingTime; // hh:mm
    private int genSeat;
    private int compartmentSeat;
    private int reservedSeat;
    private int luxeSeat;

    public Train(String destination, int number, String shippingTime, int genSeat, int compartmentSeat, int reservedSeat, int luxeSeat) {
        this.destination = destination;
        this.number = number;
        this.shippingTime = shippingTime;
        this.genSeat = genSeat;
        this.compartmentSeat = compartmentSeat;
        this.reservedSeat = reservedSeat;
        this.luxeSeat = luxeSeat;
        if(!validTime(shippingTime)){
            System.out.println("Некоректний час");
            this.shippingTime = "00:00";
        }
    }

    public String getDestination() {return destination;}

    public int getNumber() {return number;}

    public String getShippingTime() {return shippingTime;}

    public int getGenSeat() {return genSeat;}

    public int getCompartmentSeat() {return compartmentSeat;}

    public int getReservedSeat() {return reservedSeat;}

    public int getLuxeSeat() {return luxeSeat;}


    public void setDestination(String destination) {this.destination = destination;}

    public void setNumber(int number) {this.number = number;}

    public void setShippingTime(String shippingTime) {this.shippingTime = shippingTime;}

    public void setGenSeat(int genSeat) {this.genSeat = genSeat;}

    public void setCompartmentSeat(int compartmentSeat) {this.compartmentSeat = compartmentSeat;}

    public void setReservedSeat(int reservedSeat) {this.reservedSeat = reservedSeat;}

    public void setLuxeSeat(int luxeSeat) {this.luxeSeat = luxeSeat;}

    public boolean validTime(String time){
        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);
        return hour > 0 && hour < 24 && minute > 0 && minute < 60;
    }

    @Override
    public String toString(){
        return "Пункт призначення: " + this.destination +
                "\nНомер: " + this.number +
                "\nЧас відправлення: " + this.shippingTime +
                "\nЗагальна кількість місць: " + this.genSeat +
                "\nКількість місць купе: " + this.compartmentSeat +
                "\nКількість місць плацкарту:" + this.reservedSeat +
                "\nКількість люкс місць: " + this.luxeSeat;
    }

}
