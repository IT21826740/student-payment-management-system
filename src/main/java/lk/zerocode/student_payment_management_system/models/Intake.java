package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "intakes")
public class Intake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int year;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    // Many-to-Many relationship with Student
    @ManyToMany(mappedBy = "intakes")
    private List<Student> students ;

    @OneToMany(mappedBy = "intake", cascade = CascadeType.ALL)
    private List<Schedule> schedules ;

}
