package frontendservice.service;

import frontendservice.coursegateway.Course;
import frontendservice.data.CourseData;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourseMapper {
    List<CourseData> toCourseData(List<Course> allCourses);
}
