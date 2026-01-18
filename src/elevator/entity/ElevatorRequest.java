package elevator.entity;

import elevator.ElevatorController;
import elevator.enums.Direction;

public class ElevatorRequest {

    private int elevatorId;
    private int floor;
    private Direction requestDirection;
    private ElevatorController elevatorController;
    private boolean isInternalRequest;

    public ElevatorRequest(int elevatorId, int floor, boolean isInternalRequest,Direction requestDirection) {
        this.elevatorId = elevatorId;
        this.floor = floor;
        this.requestDirection = requestDirection;
        this.isInternalRequest = isInternalRequest;
    }


    public void execute(){
        if(isInternalRequest){
            elevatorController.requestFloor(elevatorId,floor);
        }else {
            elevatorController.requestElevator(elevatorId,floor,requestDirection);
        }
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getRequestDirection() {
        return requestDirection;
    }

    public void setRequestDirection(Direction requestDirection) {
        this.requestDirection = requestDirection;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    public void setElevatorController(ElevatorController elevatorController) {
        this.elevatorController = elevatorController;
    }

    public boolean isInternalRequest() {
        return isInternalRequest;
    }

    public void setInternalRequest(boolean internalRequest) {
        isInternalRequest = internalRequest;
    }
}
