package com.satish.response;

import com.satish.entity.Product;
import java.util.List;

public class ProductResponse {

    private List<Product> products;
    private int pageNo;
    private int pagesize;
    private long totalElements;
    private int totalPage;
    private boolean last;
    private boolean first;
    private boolean sorted;
    private String sortBy;
    private Long nextPage;
    private Long previousPage;

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public int getPageNo() {
        return pageNo;
    }
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    public int getPagesize() {
        return pagesize;
    }
    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public boolean isLast() {
        return last;
    }
    public void setLast(boolean last) {
        this.last = last;
    }
    public boolean isFirst() {
        return first;
    }
    public void setFirst(boolean first) {
        this.first = first;
    }
    public boolean isSorted() {
        return sorted;
    }
    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }
    public String getSortBy() {
        return sortBy;
    }
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
    public Long getNextPage() {
        return nextPage;
    }
    public void setNextPage(Long nextPage) {
        this.nextPage = nextPage;
    }
    public Long getPreviousPage() {
        return previousPage;
    }
    public void setPreviousPage(Long previousPage) {
        this.previousPage = previousPage;
    }






}
