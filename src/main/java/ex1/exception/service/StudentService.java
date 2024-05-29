package ex1.exception.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ex1.exception.entity.Student;
import ex1.exception.repository.StudentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {
	private final StudentRepository studentRepository;
	public Student addStudent(String name, int grade){
		Student student = new Student(name, grade);
		studentRepository.addStudent(student);
		return student;
	}
	public List<Student> getOrderedStudent(){
		return studentRepository.getSorted();
	}
	public List<Student> getGradeStudent(int grade){
		return studentRepository.getBy(grade);
	}
}
