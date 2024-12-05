package frontendservice.controller;

import frontendservice.data.CourseData;
import frontendservice.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CoursesController {

    private final CourseService courseService;

    @QueryMapping
    public List<CourseData> courses() {
        return courseService.findAllCourses();
    }
}
