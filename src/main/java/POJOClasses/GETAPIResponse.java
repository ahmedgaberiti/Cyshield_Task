package POJOClasses;

import java.util.List;

public class GETAPIResponse {

    private int page;
    private int per_page;
    private int total;
    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> dataField) {
        this.data = dataField;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support =  support;
    }

    private Support support;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    private int total_pages;

}
