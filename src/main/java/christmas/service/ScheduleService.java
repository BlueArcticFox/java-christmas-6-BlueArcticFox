package christmas.service;

import christmas.domain.entity.Schedule;
import java.util.List;

public interface ScheduleService {
    Long saveSchedule(Schedule schedule);
    Schedule findScheduleById(Long id);
    List<Schedule> findScheduleAll();
    void deleteScheduleAll();
}
