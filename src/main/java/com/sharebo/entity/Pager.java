package com.sharebo.entity;

import java.util.List;

/**
 * ��ҳ����
 * @author niewei
 */
public class Pager<T> {
	private Integer pageIndex;// ��ǰҳ
	private Integer pageSize;// ��ѯ������
	private Integer totalPages;// ��ҳ��
	private Integer totalNumber;// ������
	private List<T> list;

	public Integer getPageIndex() {
		return pageIndex;
	}

	// ����ҳ
	public void setPageIndex(Integer pageIndex) {
		// ���ҳ��С�ڵ���0 ���ó�1
		if (pageIndex <= 0) {
			this.pageIndex = 1;
		}
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize <= 0) {
			this.pageSize = 1;
		}
		this.pageSize = pageSize;
	}

	// ��ȡ��ҳ��
	public Integer getTotalPages() {
		// totalPages �Ƿ�Ϊnull
		if(totalPages==null){
			setTotalPages();
		}
		return totalPages;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public void setTotalPages() {
		Integer tp = this.totalNumber / this.pageSize;// ��ȡ�õ�ҳ��
		if (this.totalNumber % this.pageSize != 0) {
			tp += 1;
		}
		this.totalPages = tp;
	}
	// �Ƿ�����һҳ
	public Boolean isPreviousPage() {
		return this.pageIndex == 1 ? false : true;
	}

	// �Ƿ�����һҳ
	public Boolean isNextPage() {
		return this.getTotalPages() == this.pageIndex ? false : true;
	}

	// ��һҳҳ��
	public Integer getFirstPage() {
		return 1;
	}

	// ���һҳ��ҳ��
	public Integer getLastPage() {
		return this.getTotalPages();
	}
}
