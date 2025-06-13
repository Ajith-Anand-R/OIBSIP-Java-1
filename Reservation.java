package model;

public class Reservation {
    private String pnr;
    private User user;
    private Train train;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(String pnr, User user, Train train, String classType, String dateOfJourney, String from, String to) {
        this.pnr = pnr;
        this.user = user;
        this.train = train;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    public String getPnr() {
        return pnr;
    }

    public User getUser() {
        return user;
    }

    public Train getTrain() {
        return train;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
} 