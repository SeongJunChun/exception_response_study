package ex1.exception.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ex1.exception.ApiResponse;
import ex1.exception.entity.Student;
import ex1.exception.exception.CustomException;
import ex1.exception.exception.ErrorCode;
import ex1.exception.exception.data.InputRestriction;
import ex1.exception.service.StudentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MyController extends BaseController {
	private final StudentService service;

	@PostMapping("/student/{name}/{grade}")
	public ApiResponse<Student> add(
		@PathVariable("name") String name,
		@PathVariable("grade") int grade
	) {
		if(grade>5){
			throw new CustomException(ErrorCode.BAD_REQUEST,"grade  6이상 입력 할 수 없습니다.",new InputRestriction(6));
		}
		Student student = service.addStudent(name, grade);
		return makeApiResponse(student);
	}
	@GetMapping("/student/ordered")
	public ApiResponse<Student> getOrdered(){
		List<Student> students = service.getOrderedStudent();
		return makeApiResponse(students);
	}
	@GetMapping("/student/{grade}")
	public ApiResponse<Student> getSameGrade(@PathVariable("grade") int grade){
		List<Student> students = service.getGradeStudent(grade);
		return makeApiResponse(students);
	}
}
