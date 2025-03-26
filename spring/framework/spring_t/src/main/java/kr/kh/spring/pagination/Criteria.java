package kr.kh.spring.pagination;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Criteria {
	
	protected int page = 1;//���� ������ : �⺻�� - 1
	protected int perPageNum = 10;//�� ���������� ������ ���� : �⺻�� - 10
	
	protected String search = ""; //�˻��� : �⺻�� - ���ڿ�=> ��ü �˻�
	protected String type="0"; //�˻� Ÿ�� 
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	public int getPageStart() {
		return (page - 1) * perPageNum;
	}
}
