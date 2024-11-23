package A4_Flights;

/**
 * Cargo inherits from Flight
 * Cargo flights have crew, cargo, but no passengers
 */
public class CargoFlight extends Flight {

    // TODO-A2 - Complete this class, using javadocs as a reference
    private int cargoWeight;

    CargoFlight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew, int cargoWeight){
        super(flightNumber,dayOfWeek, departureTime,destination,numCrew);

        this.cargoWeight=cargoWeight;

    }
    @Override
    public String getFlightType() {
        return Common.CARGO;
    }
    @Override public int calculateWeight(){
        return super.calculateWeight()+this.cargoWeight;
    }
    public double getCargoWeight(){
        return 0.0;
    }
    @Override public String toDisplayReport(){
        return "Cargo Flight = "+super.toDisplayReport()+"\n\tCargo Weight: "+ Common.format(this.cargoWeight)+"\n\tTotal Weight: "+Common.format(calculateWeight());
    }
    @Override public String toArchiveFormat(){
        return super.toArchiveFormat()+","+this.cargoWeight;
    }

    @Override
    public boolean checkPassengers() {
        // No passengers in Cargo flights, so always true
        return true;
    }
    public boolean checkWeight() {
        return calculateWeight() <= Common.MAXIMUM_WEIGHT;
    }

} // end class CargoFlight
