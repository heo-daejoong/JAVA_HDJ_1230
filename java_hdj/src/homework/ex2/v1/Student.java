package homework.ex2.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

//getter, setter, toString, equals등을 제공
@Data
public class Student {

	private int grade, classNum, num;
	private String name;
	
	//학생 개인의 성적을 담고 있는 배열
	public List<SubjectScore> list;

	public Student(int grade, int classNum, int num, String name) {
		
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		list = new ArrayList<SubjectScore>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	
	
	//equals를 오버라이딩, 학년, 반, 번호를 이용
}
