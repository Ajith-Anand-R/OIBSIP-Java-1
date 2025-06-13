package util;

import model.Reservation;
import model.Train;
import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationFileUtil {
    private static final String FILE_NAME = "reservations.txt";

    public static void saveReservations(List<Reservation> reservations) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Reservation r : reservations) {
                writer.println(r.getPnr() + "," +
                        r.getUser().getUserId() + "," +
                        r.getTrain().getTrainNumber() + "," +
                        r.getTrain().getTrainName() + "," +
                        r.getClassType() + "," +
                        r.getDateOfJourney() + "," +
                        r.getFrom() + "," +
                        r.getTo());
            }
        } catch (IOException e) {
            System.out.println("Error saving reservations: " + e.getMessage());
        }
    }

    public static List<Reservation> loadReservations(List<User> users, List<Train> trains) {
        List<Reservation> reservations = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) return reservations;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", -1);
                if (parts.length != 8) continue;
                String pnr = parts[0];
                String userId = parts[1];
                String trainNumber = parts[2];
                String trainName = parts[3];
                String classType = parts[4];
                String dateOfJourney = parts[5];
                String from = parts[6];
                String to = parts[7];
                User user = null;
                for (User u : users) {
                    if (u.getUserId().equals(userId)) {
                        user = u;
                        break;
                    }
                }
                Train train = null;
                for (Train t : trains) {
                    if (t.getTrainNumber().equals(trainNumber)) {
                        train = t;
                        break;
                    }
                }
                if (user != null && train != null) {
                    reservations.add(new Reservation(pnr, user, train, classType, dateOfJourney, from, to));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading reservations: " + e.getMessage());
        }
        return reservations;
    }
} 