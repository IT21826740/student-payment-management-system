package lk.zerocode.student_payment_management_system.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Data
public class PaymentPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String amount;

    @ElementCollection
    private List<String> requirements;

    @ManyToMany(mappedBy = "paymentPlans") // Referencing the field in Fee
    private List<Fee> fees;

    public PaymentPlans() {
    }

    public PaymentPlans(Long id, String title, String amount, List<String> requirements) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.requirements = requirements;
    }
}
