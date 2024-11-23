package A4_Flights;

/**
 * Flight - a nonstop flight departing from the home airport
 * Flight is the parent class for Training, Cargo, and Passenger Flights
 */
public abstract class Flight implements PolicyRules {

    private String dayOfWeek;
    private int departureTime;
    private Location destination;
    private String flightNumber;
    private int numCrew;

    Flight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew){
        this.flightNumber=flightNumber;
        this.dayOfWeek=dayOfWeek;
        this.departureTime=departureTime;
        this.destination=destination;
        this.numCrew=numCrew;
    }
    public abstract String getFlightType();
    
    public int calculateWeight() {

        return numCrew*Common.AVERAGE_PERSON_WEIGHT;
    }

    public String toDisplayReport() {
        return this.flightNumber+", Day ="+this.dayOfWeek+", Time = "+this.departureTime +
                "\n\tDestination: "+this.destination.getLocationCode()+" ("+this.destination.getCity()+", "+this.destination.getCountry()+"), region "+this.destination.getRegion()+
                "\n\tNumber of Crew: "+this.numCrew;
    }

    public String toArchiveFormat() {
        return this.flightNumber+","+this.dayOfWeek+","+this.departureTime+","+this.destination.getLocationCode()+","+this.numCrew;
    }
    public int getDepartureTime() {
        // this is the easiest way to access the departuretime :)
        return this.departureTime;
    }

    @Override
    public boolean checkCrew() {
        return numCrew >= Common.MINIMUM_CREW;
    }

    @Override
    public boolean checkTime() {
        // This will be overridden in TrainingFlight
        return true;
    }

    @Override
    public boolean checkWeight() {
        return calculateWeight() <= Common.MAXIMUM_WEIGHT;
    }

    @Override
    public boolean checkPassengers() {
        // This will be overridden in PassengerFlight
        return true;
    }

} // end class Flight















