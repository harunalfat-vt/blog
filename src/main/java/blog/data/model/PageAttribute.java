package blog.data.model;

public class PageAttribute {

	private int currentPage;
	private int total;
	private int pageLimit;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}	
	
	public PageAttribute(int currentPage, int total, int pageLimit){
		this.currentPage = currentPage;
		this.total = total;
		this.pageLimit = pageLimit;
	}
}
