package ua.com.kisit.courseonlinecourse3712025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "course_has_order")
public class CourseHasOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;

    public CourseHasOrder(Courses course, Orders order) {
        this.course = course;
        this.order = order;
    }
}
