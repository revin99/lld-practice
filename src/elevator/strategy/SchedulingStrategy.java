package elevator.strategy;

import elevator.entity.Elevator;

public interface SchedulingStrategy {

    int getNextStop(Elevator elevator);
}
