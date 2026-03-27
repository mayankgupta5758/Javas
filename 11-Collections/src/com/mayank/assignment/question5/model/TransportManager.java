package com.mayank.assignment.question5.model;

import java.util.*;
public class TransportManager {
    private Set<Passenger> passengers = new HashSet<>();
    private Map<Integer, List<Passenger>> routeMap = new HashMap<>();
    private Queue<Integer> waitingQueue = new LinkedList<>();

    private Passenger findPassenger(int id) throws PassengerNotFoundException {
        for (Passenger p : passengers) {
            if (p.getPassengerId() == id) {
                return p;
            }
        }
        throw new PassengerNotFoundException("Passenger not found");
    }

    public void registerPassenger(Passenger p) {
        if (passengers.add(p)) {
            if (!routeMap.containsKey(p.getRouteNumber())) {
                routeMap.put(p.getRouteNumber(), new ArrayList<>());
            }
            routeMap.get(p.getRouteNumber()).add(p);
            System.out.println("Passenger registered");
        } else {
            System.out.println("Duplicate passenger!");
        }
    }

    public void displayAll() throws EmptyDataException {
        if (passengers.isEmpty())
            throw new EmptyDataException("No passengers available");
        for (Passenger p : passengers) {
            System.out.println(p);
        }
    }

    public void displayByRoute(int route) throws EmptyDataException {
        if (!routeMap.containsKey(route))
            throw new EmptyDataException("No passengers for this route");
        for (Passenger p : routeMap.get(route)) {
            System.out.println(p);
        }
    }

    public void sortByName() throws EmptyDataException {
        if (passengers.isEmpty())
            throw new EmptyDataException("No passengers");
        List<Passenger> list = new ArrayList<>(passengers);
        Collections.sort(list, new Comparator<Passenger>() {
            public int compare(Passenger p1, Passenger p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        for (Passenger p : list) {
            System.out.println(p);
        }
    }

    public void sortByRoute() throws EmptyDataException {
        if (passengers.isEmpty())
            throw new EmptyDataException("No passengers");
        List<Passenger> list = new ArrayList<>(passengers);
        Collections.sort(list, new Comparator<Passenger>() {
            public int compare(Passenger p1, Passenger p2) {
                return p1.getRouteNumber() - p2.getRouteNumber();
            }
        });

        for (Passenger p : list) {
            System.out.println(p);
        }
    }

    public void addToWaiting(int id) throws PassengerNotFoundException {
        Passenger p = findPassenger(id);
        if (p.getStatus() == PassengerStatus.REGISTERED) {
            waitingQueue.offer(id);
            p.setStatus(PassengerStatus.IN_QUEUE);
            System.out.println("Passenger added to queue");
        } 
        else if (p.getStatus() == PassengerStatus.IN_QUEUE) {
            System.out.println("Already in queue");
        } 
        else {
            System.out.println("Already boarded");
        }
    }

    public void processBoarding() throws PassengerNotFoundException {
        if (waitingQueue.isEmpty()) {
            System.out.println("No passengers in queue");
            return;
        }

        int id = waitingQueue.poll();
        Passenger p = findPassenger(id);
        p.setStatus(PassengerStatus.BOARDED);
        System.out.println("Passenger boarded: " + p.getName());
    }
    public void showWaitingPassengers() {
        for (Passenger p : passengers) {
            if (p.getStatus() == PassengerStatus.IN_QUEUE) {
                System.out.println(p);
            }
        }
    }

    public void showBoardedPassengers() {
        for (Passenger p : passengers) {
            if (p.getStatus() == PassengerStatus.BOARDED) {
                System.out.println(p);
            }
        }
    }

    public void removePassenger(int id) throws PassengerNotFoundException {
        Iterator<Passenger> it = passengers.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Passenger p = it.next();
            if (p.getPassengerId() == id) {
                it.remove(); 
                routeMap.get(p.getRouteNumber()).remove(p);
                found = true;
                System.out.println("Passenger removed");
                break;
            }
        }

        if (!found)
            throw new PassengerNotFoundException("Passenger not found");
    }
}