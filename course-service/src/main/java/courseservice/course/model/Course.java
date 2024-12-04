package courseservice.course.model;

import courseservice.course.dto.CreateCourseCommand;
import courseservice.course.dto.EnrollCommand;
import courseservice.course.dto.EnrollmentResult;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @Lob
    private String syllabus;

    @Column(name = "attendee_limit")
    private int limit;

    @ElementCollection
    private List<Long> enrolledEmployees;

    @ElementCollection
    private List<Long> completedEmployees;

    public static Course announceCourse(CreateCourseCommand command) {
        var course = new Course();
        course.setName(command.name());
        course.setDescription(command.description());
        course.setSyllabus(command.syllabus());
        course.setLimit(command.limit());
        return course;
    }

    public EnrollmentResult enroll(EnrollCommand command) {
        if (alreadyEnrolled(command)) {
            return EnrollmentResult.successful();
        }
        if (isFull()) {
            return EnrollmentResult.unsuccessful();
        }
        else {
            enrolledEmployees.add(command.getEmployeeId());
            return EnrollmentResult.successful();
        }
    }

    private boolean alreadyEnrolled(EnrollCommand command) {
        return enrolledEmployees.contains(command.getEmployeeId());
    }

    private boolean isFull() {
        return enrolledEmployees.size() >= limit;
    }

}
