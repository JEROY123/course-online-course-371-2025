package ua.com.kisit.courseonlinecourse3712025.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "learning_archive")
public class LearningArchive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date finishedDate;
    private int courseGrade;

    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Courses course;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Customers student;

    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    private Customers teacher;
}
