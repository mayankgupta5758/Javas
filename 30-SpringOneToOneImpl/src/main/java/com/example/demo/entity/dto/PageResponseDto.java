package com.example.demo.entity.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {

    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private int totalPage;

    private long totalCount;

    private boolean lastPage;
}
