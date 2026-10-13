class Booking {
    private String customerName;
    private String movieName;
    private double ticketPrice;
    private int numberOfTickets;
    private double totalAmount;
    private double discount;
    private double finalAmount;
    private boolean bookingStatus;

    public Booking(String customerName, String movieName, double ticketPrice, int numberOfTickets) {
        this.customerName = customerName.toUpperCase();
        this.movieName = movieName.toUpperCase();
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    public Booking(String customerName, String movieName, int numberOfTickets) {
        this(customerName, movieName, 200.0, numberOfTickets);
    }

    public Booking(String customerName, String movieName) {
        this(customerName, movieName, 200.0, 1);
    }

    public void bookTickets(double ticketPrice, int numberOfTickets) {
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    public void bookTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        processBooking();
    }

    private void processBooking() {
        if (numberOfTickets <= 0) {
            bookingStatus = false;
            totalAmount = 0;
            discount = 0;
            finalAmount = 0;
        } else {
            bookingStatus = true;
            totalAmount = ticketPrice * numberOfTickets;
            if (numberOfTickets >= 5) {
                discount = totalAmount * 0.10;
            } else {
                discount = 0;
            }
            finalAmount = totalAmount - discount;
        }
    }

    public void displayBooking() {
        System.out.printf("Customer Name      : %s%n", customerName);
        System.out.printf("Movie Name         : %s%n", movieName);
        System.out.printf("Ticket Price       : Rs. %.2f%n", ticketPrice);
        System.out.printf("Number of Tickets  : %d%n", numberOfTickets);
        System.out.println();
        System.out.println("Booking Status     : " + (bookingStatus ? "Booking Successful" : "Booking Failed"));
        System.out.printf("Total Amount       : Rs. %.2f%n", totalAmount);
        System.out.printf("Discount           : Rs. %.2f%n", discount);
        System.out.printf("Final Amount       : Rs. %.2f%n", finalAmount);
        System.out.println();
    }

    public static void verifyCustomer(Booking b1, Booking b2) {
        if (b1.customerName.equals(b2.customerName)) {
            System.out.println("Customer Verification: Names Match");
        } else {
            System.out.println("Customer Verification: Names Do Not Match");
        }
        System.out.println("=======================================");
    }
}

public class CinemaTicketBookingSystem {
    public static void main(String[] args) {
        System.out.println("========== CINEMA TICKET BOOKING ==========");

        Booking b1 = new Booking("Sneha", "Avatar", 200.0, 5);
        b1.displayBooking();

        Booking b2 = new Booking("Arjun", "Avatar");
        b2.bookTickets(2);
        b2.displayBooking();

        Booking b3 = new Booking("Sneha", "Avatar", 200.0, 5);
        Booking.verifyCustomer(b1, b3);
    }
}
