package info.jsjackson.springboot.swagger.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/students")
@Api(value = "Student Resource REST Endpoint", description = "Shows the student info")
public class StudentResource {

    @GetMapping
    public List<Student> getStudents() {

        return Arrays.asList(
                new Student("John", 3000L),
                new Student("Paul", 1500L)
        );
    }

    @GetMapping("/{studentName}")
    public Student getStudent(@PathVariable("studentName") final String studentName)
    {
        return new Student(studentName, 1000L);
    }


    private class Student {

        @ApiModelProperty(notes = "name of Student")
        private String studentName;

        @ApiModelProperty(notes = "the Student score")
        private Long score;

        public Student(String studentName, Long score) {
            this.studentName = studentName;
            this.score = score;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public Long getScore() {
            return score;
        }

        public void setScore(Long score) {
            this.score = score;
        }
    }
}
