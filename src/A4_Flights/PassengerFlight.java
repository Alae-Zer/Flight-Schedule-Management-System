package A4_Flights;

/**
 * A passenger flight has no cargo
 */
public class PassengerFlight extends Flight {

    // TODO-A3 - Complete this class, using javadocs as a reference
    private int numPassengers;

    PassengerFlight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew, int numPassengers){
        super(flightNumber,dayOfWeek,departureTime,destination,numCrew);
        this.numPassengers=numPassengers;
    }

    @Override
    public int calculateWeight() {
        return super.calculateWeight()+(numPassengers*Common.AVERAGE_PERSON_WEIGHT);
    }
    @Override public String toDisplayReport(){
        return "Passenger Flight = "+super.toDisplayReport()+"\n\tPassengers: "+ this.numPassengers+"\n\tTotal Weight: "+Common.format(calculateWeight());
    }
    @Override public String toArchiveFormat(){
        return super.toArchiveFormat()+","+this.numPassengers;
    }

    @Override
    public String getFlightType() {
        return Common.PASSENGER;
    }

    @Override
    public boolean checkPassengers() {
        return numPassengers >= Common.MINIMUM_PASSENGERS;
    }
} // end class PassengerFlight
