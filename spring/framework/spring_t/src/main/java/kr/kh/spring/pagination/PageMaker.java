package kr.kh.spring.pagination;

import lombok.Data;

@Data
public class PageMaker {
	private int totalCount; //��ü ������ ���� => ������ ���������̼��� ������ �������� ����ϱ� ����
	private int startPage;//���������̼� ���� ��������ȣ
	private int endPage;//���������̼� ������ ��������ȣ
	private boolean prev;//������ư Ȱ��ȭ
	private boolean next;//������ư Ȱ��ȭ
	private int displayPageNum;//�� ���������̼ǿ��� ������ �������� �ִ� ���� ����
	private Criteria cri;
	
	//���� ������ Ȱ��ȭ ����, ���� ������ Ȱ��ȭ ����, ������ ������ ��ȣ�� ����ϴ� �޼ҵ�
	public void calculate() {
		
		//������ ���� ������� ���� �������� ������ �ִ� ������ �������� ���
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		
		//�ִ� ������ �������� �̿��Ͽ� ���� �������� ���
		startPage = endPage - displayPageNum + 1;
		
		//������ ������ �̿��Ͽ� ����� ��� �������� �ִ� ������ ��ȣ
		int tmpEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		//�ִ� �������� ���� ���������� ������ �ִ� ���������� ������ ���� ���������� ������ �ִ� �������� ����
		//������ ���������̼�, ������ ���� ������ ���������� �� ���� ���
		if(endPage > tmpEndPage) {
			endPage = tmpEndPage;
		}
		//ù��° ���������̼��̸� false �ƴϸ� true
		prev = startPage == 1 ? false : true;
		//������ ���������̼��̸� false �ƴϸ� true
		next = endPage == tmpEndPage ? false : true;
	}
	public PageMaker(int displayPageNum, Criteria cri, int totalCount) {
		this.displayPageNum = displayPageNum;
		this.cri = cri;
		this.totalCount = totalCount;
		calculate();
	}
}