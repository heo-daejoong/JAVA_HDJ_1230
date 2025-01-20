package homework.ex2.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

//getter, setter, toString, equals등을 제공
@Data
public class Student implements Serializable{

	private static final long serialVersionUID = -551090066386724638L;
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
	public void print() {
		System.out.println("-----------------");
		System.out.println(grade + "학년 " + classNum + "반 " + num + "번 " + name);
		System.out.println("-----------------");
		if(list.size() == 0) {
			System.out.println("등록된 성적이 없습니다.");
			return;
		}
		for(SubjectScore score : list) {
			System.out.println(score);
		}
	}

	public void update(Student newStd) {
		if(newStd == null) {
			return;
		}
		grade = newStd.grade;
		classNum = newStd.classNum;
		num = newStd.num;
		name = newStd.name;
		
	}

	public boolean insertScore(SubjectScore subjectScore) {
		if(list.contains(subjectScore)) {
			return false;
		}
		list.add(subjectScore);
		return true;
	}

	public void printScore(Subject subject) {
		int index = list.indexOf(new SubjectScore(subject, 0));
		if(index < 0) {
			System.out.println("일치하는 성적이 없습니다.");
			return;
		}
		System.out.println(list.get(index));
	}

	public boolean updateScore(Subject subject, SubjectScore subjectScore) {
		if(subject == null || subjectScore == null) {
			return false;
		}
		//등록된 성적이 아니면
		if(!list.contains(new SubjectScore(subject, 0))) {
			return false;
		}
		//같은 과목을 수정하면
		if(subject.equals(subjectScore.getSubject())) {
			list.remove(subjectScore);
			list.add(subjectScore);
			return true;
		}
		//다른 과목을 수정하면
		//새 성적이 등록된 성적인지 확인
		if(list.contains(subjectScore)) {
			return false;
		}
		list.remove(new SubjectScore(subject, 0));
		list.add(subjectScore);
		return true;
	}

	public boolean deleteScore(Subject subject) {
		
		return list.remove(new SubjectScore(subject, 0));
	}
	
	
	//equals를 오버라이딩, 학년, 반, 번호를 이용
}
