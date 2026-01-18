package elevator.observer;

import elevator.entity.Elevator;
import elevator.enums.ElevatorState;

public class ElevatorDisplay implements ElevatorObserver{
    @Override
    public void onElevatorStateChange(Elevator elevator, ElevatorState elevatorState) {
        System.out.println("Elevetor state is changed to ");
    }

    @Override
    public void onElevatorFloorChange(Elevator elevator, int floor) {
        System.out.println("Elevetor floor is changed to ");

    }
}
