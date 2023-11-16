package christmas.service;

import christmas.domain.entity.Schedule;
import christmas.repository.Repository;
import java.util.List;

public class ScheduleServiceImpl implements ScheduleService {
    private final Repository scheduleRepository;

    public ScheduleServiceImpl(Repository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Long saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule findScheduleById(Long id) {
        return (Schedule) scheduleRepository.findById(id).get();
    }

    @Override
    public List<Schedule> findScheduleAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public void deleteScheduleAll() {
        scheduleRepository.deleteAll();
    }
}
