package A4_Flights;

/**
 * A Training Flight has no passengers, and no cargo
 */
public class TrainingFlight extends Flight {

    TrainingFlight(String flightNumber, String dayOfWeek, int departureTime, Location destination, int numCrew){
        super(flightNumber,dayOfWeek,departureTime,destination,numCrew);
    }

    @Override
    public String getFlightType() {
        return Common.TRAINING;
    }

    @Override
    public String toDisplayReport() {
        return "Training Flight = "+super.toDisplayReport()+"\n\tTotal Weight: "+Common.format(calculateWeight());
    }

    @Override
    public boolean checkTime() {
        // Check if the departure time is within the allowed range
        return getDepartureTime() >= Common.EARLIEST_DEPARTURE && getDepartureTime() <= Common.LATEST_DEPARTURE;
    }
} // end class TrainingFlight
