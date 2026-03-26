package systemDesign.parkingLot;

public class ParkingLot {



    public static volatile ParkingLot instance = null;

    private ParkingLot(){

    }

    public static ParkingLot getInstance(){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null){
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public ParkingTicket parkVehicle(Vehicle v){
        return null;
    }

    public void unparkVehicle(ParkingTicket ticket){

    }







}
