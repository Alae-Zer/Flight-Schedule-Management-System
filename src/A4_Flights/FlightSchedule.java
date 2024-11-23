package A4_Flights;

import java.util.ArrayList;

public class FlightSchedule {

    private final Flight[] flights;

    /**
     * Creates a new schedule based on the specified flights.
     *
     * @param flights the flights to be contained in this schedule
     */
    public FlightSchedule(Flight[] flights) {
        this.flights = flights;
    }

    /**
     * Gets all of the flights in this schedule.
     *
     * @return all of the flights in this schedule
     */
    public Flight[] getAllFlights() {
        return flights;
    }

    public Flight[] getFlightsByDestination(String locationCode) {
        ArrayList<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.toArchiveFormat().split(",")[3].equals(locationCode)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights.toArray(new Flight[0]);
    }

    private int countFlightsByDestination(String locationCode) {
        int count = 0;
        for (Flight flight : flights) {
            if (flight.toArchiveFormat().split(",")[3].equals(locationCode)) {
                count++;
            }
        }
        return count;
    }

    public Flight[] getFlightsByType(String flightType) {
        ArrayList<Flight> matchingFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getFlightType().equals(flightType)) {
                matchingFlights.add(flight);
            }
        }
        return matchingFlights.toArray(new Flight[0]);
    }

    private int countFlightsByType(String flightType) {
        int count = 0;
        for (Flight flight : flights) {
            if (flight.getFlightType().equals(flightType)) {
                count++;
            }
        }
        return count;
    }

} // end class FlightSchedule
