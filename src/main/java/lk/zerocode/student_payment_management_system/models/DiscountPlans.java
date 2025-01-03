package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "discount_plans")
public class DiscountPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private float percentage;

    private List<String> requirement;

    public DiscountPlans() {
    }

    public DiscountPlans(Long id, String title, float percentage, List<String> requirement) {
        this.id = id;
        this.title = title;
        this.percentage = percentage;
        this.requirement = requirement;
    }
}
