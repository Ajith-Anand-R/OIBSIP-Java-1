package service;

import db.Database;
import model.Reservation;
import model.Train;
import model.User;
import util.InputUtil;

import java.util.UUID;

public class ReservationService {
    public void makeReservation(User user) {
        System.out.println("\n--- Reservation Form ---");
        // List available trains
        System.out.println("Available Trains:");
        for (int i = 0; i < Database.trains.size(); i++) {
            Train t = Database.trains.get(i);
            System.out.println((i + 1) + ". " + t.getTrainNumber() + " - " + t.getTrainName());
        }
        int trainChoice = InputUtil.readInt("Select train (number): ") - 1;
        if (trainChoice < 0 || trainChoice >= Database.trains.size()) {
            System.out.println("Invalid train selection.\n");
            return;
        }
        Train selectedTrain = Database.trains.get(trainChoice);
        String classType = InputUtil.readString("Enter class type (e.g., Sleeper, AC): ");
        String dateOfJourney = InputUtil.readString("Enter date of journey (YYYY-MM-DD): ");
        String from = InputUtil.readString("From: ");
        String to = InputUtil.readString("To: ");
        String pnr = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        Reservation reservation = new Reservation(pnr, user, selectedTrain, classType, dateOfJourney, from, to);
        Database.reservations.add(reservation);
        Database.saveReservations();
        System.out.println("Reservation successful! Your PNR: " + pnr + "\n");
    }
} 