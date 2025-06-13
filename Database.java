package db;

import java.util.ArrayList;
import java.util.List;
import model.User;
import model.Train;
import model.Reservation;
import util.ReservationFileUtil;

public class Database {
    public static List<User> users = new ArrayList<>();
    public static List<Train> trains = new ArrayList<>();
    public static List<Reservation> reservations = new ArrayList<>();

    static {
        // Sample users
        users.add(new User("user1", "pass1"));
        users.add(new User("user2", "pass2"));
        // Sample trains
        trains.add(new Train("1001", "Express A"));
        trains.add(new Train("1002", "Express B"));
        trains.add(new Train("1003", "Express C"));
        // Load reservations from file
        reservations.addAll(ReservationFileUtil.loadReservations(users, trains));
    }

    public static void saveReservations() {
        ReservationFileUtil.saveReservations(reservations);
    }
} 