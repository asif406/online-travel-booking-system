import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Flight Class
class Flight {
    private String flightNumber;
    private String departure;
    private String destination;
    private double price;

    public Flight(String flightNumber, String departure, String destination, double price) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber + ", Departure: " + departure + ", Destination: " + destination + ", Price: $" + price;
    }
}

// Hotel Class
class Hotel {
    private String hotelName;
    private String location;
    private double pricePerNight;

    public Hotel(String hotelName, String location, double pricePerNight) {
        this.hotelName = hotelName;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getLocation() {
        return location;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public String toString() {
        return "Hotel: " + hotelName + ", Location: " + location + ", Price per Night: $" + pricePerNight;
    }
}

// Booking Class
class Booking {
    private String customerName;
    private Flight flight;
    private Hotel hotel;
    private int numberOfNights;

    public Booking(String customerName, Flight flight, Hotel hotel, int numberOfNights) {
        this.customerName = customerName;
        this.flight = flight;
        this.hotel = hotel;
        this.numberOfNights = numberOfNights;
    }

    public double calculateTotalCost() {
        return flight.getPrice() + (hotel.getPricePerNight() * numberOfNights);
    }

    @Override
    public String toString() {
        return "Booking for " + customerName + ":\n" + flight + "\n" + hotel + "\nTotal Cost: $" + calculateTotalCost();
    }
}

// BookingSystem Class (Main System)
public class BookingSystem {
    private List<Flight> availableFlights = new ArrayList<>();
    private List<Hotel> availableHotels = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public BookingSystem() {
        // Initialize with some sample data
        availableFlights.add(new Flight("AA123", "New York", "London", 500.00));
        availableFlights.add(new Flight("BA456", "Los Angeles", "Paris", 700.00));
        availableFlights.add(new Flight("UA789", "Chicago", "Tokyo", 800.00));

        availableHotels.add(new Hotel("Hilton", "London", 150.00));
        availableHotels.add(new Hotel("Marriott", "Paris", 200.00));
        availableHotels.add(new Hotel("Sheraton", "Tokyo", 180.00));
    }

    public void displayAvailableFlights() {
        System.out.println("Available Flights:");
        for (Flight flight : availableFlights) {
            System.out.println(flight);
        }
    }

    public void displayAvailableHotels() {
        System.out.println("Available Hotels:");
        for (Hotel hotel : availableHotels) {
            System.out.println(hotel);
        }
    }

    public void makeBooking() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Select a flight by number:");
        displayAvailableFlights();
        System.out.print("Enter flight number: ");
        String flightNumber = scanner.nextLine();

        Flight selectedFlight = null;
        for (Flight flight : availableFlights) {
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight == null) {
            System.out.println("Invalid flight number.");
            return;
        }

        System.out.println("Select a hotel by name:");
        displayAvailableHotels();
        System.out.print("Enter hotel name: ");
        String hotelName = scanner.nextLine();

        Hotel selectedHotel = null;
        for (Hotel hotel : availableHotels) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            System.out.println("Invalid hotel name.");
            return;
        }

        System.out.print("Enter number of nights: ");
        int numberOfNights = scanner.nextInt();

        Booking booking = new Booking(name, selectedFlight, selectedHotel, numberOfNights);
        bookings.add(booking);
        System.out.println("Booking successful!\n" + booking);
    }

    public void viewBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }

    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Travel Booking System ---");
            System.out.println("1. View Available Flights");
            System.out.println("2. View Available Hotels");
            System.out.println("3. Make a Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (option) {
                case 1:
                    system.displayAvailableFlights();
                    break;
                case 2:
                    system.displayAvailableHotels();
                    break;
                case 3:
                    system.makeBooking();
                    break;
                case 4:
                    system.viewBookings();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

    }
}
