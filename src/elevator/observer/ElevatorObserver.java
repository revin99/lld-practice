package elevator.observer;

import elevator.entity.Elevator;
import elevator.enums.ElevatorState;

public interface ElevatorObserver {

    void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState);

    void onElevatorFloorChange(Elevator elevator, int floor);
}
