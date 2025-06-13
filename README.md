# Online Reservation System (Java)

A console-based Online Reservation System for booking and managing train tickets, implemented in Java. This project demonstrates modular programming, user authentication, and persistent data storage using file operations.

## Features

- **User Authentication:** Secure login with user ID and password.
- **Train Reservation:** Book train tickets by entering journey details.
- **Ticket Cancellation:** Cancel booked tickets using the PNR number.
- **Persistent Storage:** All reservations are automatically saved to and loaded from a file (`reservations.txt`), ensuring data is retained between sessions.
- **Sample Data:** Preloaded users and trains for quick testing and demonstration.

## Project Structure

```
src/
  Main.java
  model/
    User.java
    Train.java
    Reservation.java
  service/
    AuthService.java
    ReservationService.java
    CancellationService.java
  db/
    Database.java
  util/
    InputUtil.java
    ReservationFileUtil.java
  reservations.txt
  lib/
    gson-2.10.1.jar
```

## Data Persistence

- **File Used:** `reservations.txt` (located in the `src` directory)
- **How It Works:**
  - On startup, the application loads all existing reservations from `reservations.txt` using the `ReservationFileUtil` utility.
  - When a reservation is made or cancelled, the updated list is saved back to the file, ensuring all changes are persistent.
  - The file is managed automatically; no manual editing is required.

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Command-line terminal

### Setup & Run

1. **Clone or Download the Repository**
2. **Navigate to the `src` Directory:**
   ```sh
   cd src
   ```
3. **Compile the Java Files:**
   ```sh
   javac -cp ".;lib/gson-2.10.1.jar" model/*.java service/*.java db/*.java util/*.java Main.java
   ```
4. **Run the Application:**
   ```sh
   java -cp ".;lib/gson-2.10.1.jar" Main
   ```
   > **Note:** On Unix-based systems, replace `;` with `:` in the classpath.

## Usage

- **Login:** Enter your user ID and password (default users: `user1`/`pass1`, `user2`/`pass2`).
- **Book Ticket:** Provide journey details to reserve a seat.
- **Cancel Ticket:** Enter your PNR to cancel a reservation.
- **Exit:** Quit the application at any time.

## File Descriptions

- `Main.java` — Entry point; handles user interaction and menu navigation.
- `model/` — Data models for User, Train, and Reservation.
- `service/` — Business logic for authentication, reservation, and cancellation.
- `db/Database.java` — In-memory data storage, initialization, and triggers file-based persistence.
- `util/` — Utility classes for input handling and file operations (including reading/writing reservations).
- `reservations.txt` — Stores reservation data persistently; managed automatically by the application.
- `lib/gson-2.10.1.jar` — Library for JSON serialization (if used).

## Customization

- Add more users or trains by editing `Database.java`.
- Extend features (e.g., search trains, view reservations) by adding new service classes.
