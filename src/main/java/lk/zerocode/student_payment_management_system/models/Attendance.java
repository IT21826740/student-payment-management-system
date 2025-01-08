package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "attend_date" , nullable = false)
    private LocalDate attendDate;

    @Column(name = "attend_time")
    private LocalTime attendTime;

    @Column(name = "qr_ code", nullable = false)
    private String qrCode;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @OneToOne
    private FreeAccess freeAccess;

}
