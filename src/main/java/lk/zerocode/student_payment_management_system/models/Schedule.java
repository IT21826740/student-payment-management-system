package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name= "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private LocalDate date;

    private LocalTime time;

    @OneToMany(mappedBy = "schedule")
    private List<Attendance> attendance;

    @ManyToOne
    @JoinColumn(name = "intake_id", nullable = false)
    private Intake intake;

}
