package frontendservice.service;

import frontendservice.coursegateway.CourseClient;
import frontendservice.data.CourseData;
import frontendservice.employeesgateway.EmployeeClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseClient courseClient;

    private final EmployeeClient employeeClient;

    private final CourseMapper courseMapper;

    public List<CourseData> findAllCourses() {
        return courseMapper.toCourseData(courseClient.findAllCourses());
    }
}
