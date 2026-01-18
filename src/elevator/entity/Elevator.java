package elevator.entity;

import elevator.enums.Direction;
import elevator.enums.ElevatorState;
import elevator.observer.ElevatorObserver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private ElevatorState elevatorState;
    private List<ElevatorObserver> observers;
    private Queue<ElevatorRequest> requests;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor=1;
        this.direction=Direction.IDLE;
        this.elevatorState=ElevatorState.IDLE;
        this.observers=new ArrayList<>();
        this.requests=new LinkedList<>();
    }

    public void addObserver(ElevatorObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ElevatorObserver observer){
        observers.remove(observer);
    }

    private void notifyStateChange(ElevatorState elevatorState){
        for(ElevatorObserver observer: observers){
            observer.onElevatorStateChange(this,elevatorState);
        }
    }

    private void notifyFloorChange(int floor){
        for(ElevatorObserver observer: observers){
            observer.onElevatorFloorChange(this,floor);
        }
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
        notifyStateChange(elevatorState);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void addRequest(ElevatorRequest elevatorRequest) {
        // Avoid duplicate requests
        if (!requests.contains(elevatorRequest)) {
            requests.add(elevatorRequest);
        }

        int requestedFloor = elevatorRequest.getFloor();
        // If elevator is idle, determine direction and start moving
        if (elevatorState == ElevatorState.IDLE && !requests.isEmpty()) {
            if (requestedFloor > currentFloor) {
                direction = Direction.UP;
            } else if (requestedFloor < currentFloor) {
                direction = Direction.DOWN;
            }
            setElevatorState(ElevatorState.MOVING);
        }
    }

    // Move the elevator to the next stop as decided by the scheduling strategy
    public void moveToNextStop(int nextStop) {
        // Only move if the elevator is currently in the MOVING state
        if (elevatorState != ElevatorState.MOVING)
            return;

        while (currentFloor != nextStop) {
            // Update floor based on direction
            if (direction == Direction.UP) {
                currentFloor++;
            } else {
                currentFloor--;
            }
            // Notify observers about the floor change
            notifyFloorChange(currentFloor);
            // Complete arrival once the target floor is reached
            if (currentFloor == nextStop) {
                completeArrival();
                return;
            }
        }
    }


    // Handle the elevator's arrival at a destination floor
    private void completeArrival() {
        // Stop the elevator and notify observers
        setElevatorState(ElevatorState.STOPPED);

        // Remove the current floor from the requests queue
        for(ElevatorRequest request:requests){
            if(request.getFloor()==currentFloor) {requests.remove(request); break;}
        }

        // If no more requests, set state to IDLE
        if (requests.isEmpty()) {
            direction = Direction.IDLE;
            setElevatorState(ElevatorState.IDLE);
        } else {
            // Otherwise, continue moving after a brief stop
            setElevatorState(ElevatorState.MOVING);
        }
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public List<ElevatorObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<ElevatorObserver> observers) {
        this.observers = observers;
    }

    public Queue<ElevatorRequest> getRequests() {
        return requests;
    }

    public void setRequests(Queue<ElevatorRequest> requests) {
        this.requests = requests;
    }

    // Get a list of all destination floors for display purposes
    public List<ElevatorRequest> getDestinationFloors() {
        return new ArrayList<>(requests);
    }

}
