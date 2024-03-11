package model;
import java.util.ArrayList;
import java.util.Scanner;

public class RoomSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("Single", 1, 50));
        rooms.add(new Room("Double", 2, 80));
        rooms.add(new Room("Suite", 4, 150));

        boolean selected = false;
        while (!selected) {
            System.out.println("Enter the number of people: ");
            int numOfPeople = scanner.nextInt();
            System.out.println("Enter the budget: ");
            int budget = scanner.nextInt();

            ArrayList<Room> suitableRooms = findSuitableRooms(rooms, numOfPeople, budget);
            if (suitableRooms.isEmpty()) {
                System.out.println("No suitable rooms found. Do you want to try again? (YES/NO)");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("NO")) {
                    break;
                }
            } else {
                System.out.println("Suitable rooms found:");
                for (Room room : suitableRooms) {
                    System.out.println(room);
                }
                System.out.println("Do you want to select this option? (YES/NO)");
                String choice = scanner.next();
                if (choice.equalsIgnoreCase("YES")) {
                    selected = true;
                }
            }
        }
        scanner.close();
    }

    public static ArrayList<Room> findSuitableRooms(ArrayList<Room> rooms, int numOfPeople, int budget) {
        ArrayList<Room> suitableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.capacity == numOfPeople && room.price <= budget) {
                suitableRooms.add(room);
            }
        }
        return suitableRooms;
    }

    static class Room {
        String type;
        int capacity;
        int price;

        public Room(String type, int capacity, int price) {
            this.type = type;
            this.capacity = capacity;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Type: " + type + ", Capacity: " + capacity + ", Price: $" + price;
        }
    }
}

