package elevator.strategy;

import elevator.entity.Elevator;
import elevator.entity.ElevatorRequest;
import elevator.enums.Direction;

import java.util.PriorityQueue;
import java.util.Queue;

// Scan Scheduling Strategy for handling elevator requests
public class ScanSchedulingStrategy implements SchedulingStrategy {
    @Override
    public int getNextStop(Elevator elevator) {
        // Retrieve elevator's current direction and floor
        Direction elevatorDirection = elevator.getDirection();
        int currentFloor = elevator.getCurrentFloor();
        Queue<ElevatorRequest> requests = elevator.getRequests();


        // If there are no requests, stay on the current floor
        if (requests.isEmpty())
            return currentFloor;


        // Priority queues to handle requests in up and down directions
        PriorityQueue<ElevatorRequest> upQueue = new PriorityQueue<>(); // Min-heap for upward requests
        PriorityQueue<ElevatorRequest> downQueue = new PriorityQueue<>((a, b) -> b.getFloor() - a.getFloor()); // Max-heap for downward requests


        // Categorize requests based on their relative position to the current floor
        while (!requests.isEmpty()) {
            ElevatorRequest elevatorRequest = requests.poll();
            int floor = elevatorRequest.getFloor();
            if (floor > currentFloor)
                upQueue.add(elevatorRequest);
            else
                downQueue.add(elevatorRequest);
        }


        // Handle the case when the elevator is IDLE
        if (elevatorDirection == Direction.IDLE) {
            // Determine the nearest request and set direction accordingly
            int nearestUpwardRequest =
                    upQueue.isEmpty() ? -1 : upQueue.peek().getFloor();
            int nearestDownwardRequest =
                    downQueue.isEmpty() ? -1 : downQueue.peek().getFloor();


            if (nearestUpwardRequest == -1) {
                elevator.setDirection(Direction.DOWN);
                return downQueue.poll().getFloor();
            } else if (nearestDownwardRequest == -1) {
                elevator.setDirection(Direction.UP);
                return upQueue.poll().getFloor();
            } else {
                // Choose the closest request
                if (Math.abs(nearestUpwardRequest - currentFloor)
                        < Math.abs(nearestDownwardRequest - currentFloor)) {
                    elevator.setDirection(Direction.UP);
                    return upQueue.poll().getFloor();
                } else {
                    elevator.setDirection(Direction.DOWN);
                    return downQueue.poll().getFloor();
                }
            }
        }


        // Handle movement in the UP direction
        if (elevatorDirection == Direction.UP) {
            return !upQueue.isEmpty() ? upQueue.poll().getFloor()
                    : switchDirection(elevator, downQueue);
        }
        // Handle movement in the DOWN direction
        else {
            return !downQueue.isEmpty() ? downQueue.poll().getFloor()
                    : switchDirection(elevator, upQueue);
        }
    }


    // Helper method to switch the elevator's direction when no further requests
    // exist in the current direction
    private int switchDirection(Elevator elevator, PriorityQueue<ElevatorRequest> requestsQueue) {
        elevator.setDirection(elevator.getDirection() == Direction.UP
                ? Direction.DOWN
                : Direction.UP);
        return requestsQueue.isEmpty() ? elevator.getCurrentFloor()
                : requestsQueue.poll().getFloor();
    }
}


/* SIMULATION SCENARIO : Up Request While Elevator is Moving Down
 -  - Setup:
 - - Elevator is at floor 10
 - - Elevator is moving DOWN
 - - Elevator has destinations at floors 6 and 2
 - - External UP request arrives from floor 4
 -  - System Reaction:
 - The Scan Scheduling Strategy would not assign Elevator to this request
 - because its current direction doesn't match the request direction. Instead,
 - this request would be queued. the Elevator will complete its current DOWN
 - journey to floor 2, then reverse direction and fulfill the UP request from
 - floor 4.
 */