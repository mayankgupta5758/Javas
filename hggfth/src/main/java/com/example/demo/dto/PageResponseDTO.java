package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class PageResponseDTO<T> {

	private List<T> content;

	private int pageNumber;

	private int pageSize;

	private int totalPage;

	private int totalCount;

	private boolean lastPage;

//	public PageResponseDTO() {
//	}
//
//	public PageResponseDTO(List<T> content, int pageNumber, int pageSize, int totalPage, int totalCount,
//			boolean lastPage) {
//		this.content = content;
//		this.pageNumber = pageNumber;
//		this.pageSize = pageSize;
//		this.totalPage = totalPage;
//		this.totalCount = totalCount;
//		this.lastPage = lastPage;
//	}
//
//	public List<T> getContent() {
//		return content;
//	}
//
//	public void setContent(List<T> content) {
//		this.content = content;
//	}
//
//	public int getPageNumber() {
//		return pageNumber;
//	}
//
//	public void setPageNumber(int pageNumber) {
//		this.pageNumber = pageNumber;
//	}
//
//	public int getPageSize() {
//		return pageSize;
//	}
//
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}

//	public int getTotalPage() {
//		return totalPage;
//	}
//
//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
//
//	public int getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(int totalCount) {
//		this.totalCount = totalCount;
//	}
//
//	public boolean isLastPage() {
//		return lastPage;
//	}
//
//	public void setLastPage(boolean lastPage) {
//		this.lastPage = lastPage;
//	}

}
