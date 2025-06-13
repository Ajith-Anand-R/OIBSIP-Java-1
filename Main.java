import model.User;
import service.AuthService;
import service.ReservationService;
import service.CancellationService;
import util.InputUtil;

public class Main {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        ReservationService reservationService = new ReservationService();
        CancellationService cancellationService = new CancellationService();

        System.out.println("=== Online Reservation System ===");
        boolean loggedIn = false;
        User currentUser = null;
        while (!loggedIn) {
            String userId = InputUtil.readString("Enter User ID: ");
            String password = InputUtil.readString("Enter Password: ");
            currentUser = authService.login(userId, password);
            if (currentUser != null) {
                loggedIn = true;
                System.out.println("Login successful!\n");
            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }
        boolean running = true;
        while (running) {
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Exit");
            int choice = InputUtil.readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    reservationService.makeReservation(currentUser);
                    break;
                case 2:
                    cancellationService.cancelReservation(currentUser);
                    break;
                case 3:
                    running = false;
                    System.out.println("Thank you for using the Online Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
} 