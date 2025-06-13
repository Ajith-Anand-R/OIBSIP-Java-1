package service;

import db.Database;
import model.Reservation;
import model.User;
import util.InputUtil;

public class CancellationService {
    public void cancelReservation(User user) {
        System.out.println("\n--- Cancellation Form ---");
        String pnr = InputUtil.readString("Enter PNR number: ");
        Reservation found = null;
        for (Reservation r : Database.reservations) {
            if (r.getPnr().equalsIgnoreCase(pnr) && r.getUser().getUserId().equals(user.getUserId())) {
                found = r;
                break;
            }
        }
        if (found == null) {
            System.out.println("No reservation found for the given PNR and user.\n");
            return;
        }
        System.out.println("Reservation Details:");
        System.out.println("PNR: " + found.getPnr());
        System.out.println("Train: " + found.getTrain().getTrainNumber() + " - " + found.getTrain().getTrainName());
        System.out.println("Class: " + found.getClassType());
        System.out.println("Date: " + found.getDateOfJourney());
        System.out.println("From: " + found.getFrom());
        System.out.println("To: " + found.getTo());
        String confirm = InputUtil.readString("Confirm cancellation? (yes/no): ");
        if (confirm.equalsIgnoreCase("yes")) {
            Database.reservations.remove(found);
            Database.saveReservations();
            System.out.println("Reservation cancelled successfully.\n");
        } else {
            System.out.println("Cancellation aborted.\n");
        }
    }
} 