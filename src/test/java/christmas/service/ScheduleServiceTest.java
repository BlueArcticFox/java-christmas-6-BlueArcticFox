package christmas.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import christmas.domain.entity.Schedule;
import christmas.repository.MemoryScheduleRepository;
import christmas.repository.Repository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScheduleServiceTest {
    private static Repository scheduleRepository;
    private static ScheduleService scheduleService;

    @BeforeEach
    void setup() {
        scheduleRepository = new MemoryScheduleRepository();
        scheduleService = new ScheduleServiceImpl(scheduleRepository);
    }

    @DisplayName("save에 따른 ID 반환 테스트")
    @Test
    void saveSchedule() {
        Schedule schedule = Schedule.create(null, null, null);
        assertEquals(scheduleService.saveSchedule(schedule), 1);
        assertEquals(scheduleService.saveSchedule(schedule), 2);
    }

    @DisplayName("findScheduleById 테스트")
    @Test
    void findByIdSchedule() {
        Schedule schedule1 = Schedule.create(null, null, null);
        Schedule schedule2 = Schedule.create(null, null, null);
        Long id1 = scheduleService.saveSchedule(schedule1);
        Long id2 = scheduleService.saveSchedule(schedule2);
        Schedule expected1 = scheduleService.findScheduleById(id1);
        Schedule expected2 = scheduleService.findScheduleById(id2);
        assertEquals(expected1, schedule1);
        assertEquals(expected2, schedule2);
    }

    @DisplayName("findScheduleAll 테스트")
    @Test
    void findAllSchedule() {
        Schedule schedule1 = Schedule.create(null, null, null);
        Schedule schedule2 = Schedule.create(null, null, null);
        List<Schedule> actually = List.of(schedule1, schedule2);
        Long id1 = scheduleService.saveSchedule(schedule1);
        Long id2 = scheduleService.saveSchedule(schedule2);
        List expected = scheduleService.findScheduleAll();
        assertEquals(actually, expected);
    }
}
