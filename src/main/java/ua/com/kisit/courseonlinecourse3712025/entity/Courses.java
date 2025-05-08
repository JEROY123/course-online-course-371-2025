package ua.com.kisit.courseonlinecourse3712025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 200)
    private String short_description;
    @Column(length = 1024)
    private String full_description;
    private String linkImage;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Customers teacher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @OneToMany(mappedBy = "course")
    private List<CourseHasOrder> courseHasOrderList;

    public Courses(String name, String short_description, String full_description, String linkImage, BigDecimal price, Customers teacher, Categories category) {
        this.name = name;
        this.short_description = short_description;
        this.full_description = full_description;
        this.linkImage = linkImage;
        this.price = price;
        this.teacher = teacher;
        this.category = category;
    }
}