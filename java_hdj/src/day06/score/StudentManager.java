package day06.score;

public class StudentManager {

	private Student [] std = new Student[5];
	private int count = 0;
	
	private void expend() {
		if(std == null) {
			std = new Student[5];
		}
		if(count < std.length) {
			return;
		}
		//확장
		Student tmp[] = new Student[std.length + 5];
		//복사
		System.arraycopy(std, 0, tmp, 0, std.length);
	}
	
	public void insertStudent(String name, int score){
		std[count++] = new Student(name, score);
		expend();
	}
	
	public void printStudent() {
		int sum = 0;
		for(int i = 0; i < count; i++) {
			//학생 정보 출력
			std[i].print();
			sum += std[i].getScore();
		}
		double avg = sum / (double)count;
		System.out.println("평균 : " + avg);
	}
}
