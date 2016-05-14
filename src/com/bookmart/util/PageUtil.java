package com.news.util;

/**
 * 分页工具类
 * 
 * @author 杨超民 2013-7-23 下午6:16:21
 * 
 */
public class PageUtil {

	private int pageRecord;// 每页显示条数
	private int totalRecord;// 总记录数
	private int totalPage;// 总页数
	private int currentPage = 1;

	private int prePage;// 上一页
	private int nextpage;// 下一页

	private int start;
	
	private int pageNumStart;// 页码显示开始listbegin
	private int pageNumEnd; // 页码显示结束 listend
	private int showPageNum = 10;
	
	public int getStart() {
		return (this.currentPage - 1) * pageRecord;
	}




	public PageUtil() {
	}

	public PageUtil(int pageRecord, int totalRecord, int currentPage) {

	}

	public int getPageRecord() {
		return pageRecord;
	}

	public void setPageRecord(int pageRecord) {
		this.pageRecord = pageRecord;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		setTotalPage(this.totalRecord % this.pageRecord == 0 ? this.totalRecord / this.pageRecord
				: this.totalRecord / this.pageRecord + 1);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置当前页数
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		if (currentPage > getTotalPage())
			this.currentPage = getTotalPage();
		else {
			if (currentPage < 1)
				this.currentPage = 1;
			else
				this.currentPage = currentPage;
		}
	}

	/**
	 * 获取上一页
	 * 
	 * @return
	 */
	public int getPrePage() {
		return this.getCurrentPage() - 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	/**
	 * 获取下一页
	 * 
	 * @return
	 */
	public int getNextpage() {
		return this.getCurrentPage() + 1;
	}

	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}

	public int getPageNumStart() {
		return pageNumStart;
	}

	/**
	 * 显示页码
	 * 
	 * @param pageNumStart
	 */
	public void setPageNumStart(int pageNumStart) {
		int halpage = (int) Math.ceil((double) showPageNum / 2);
		if (halpage >= currentPage) {
			this.pageNumStart = 1;
		} else {
			if (currentPage + halpage > totalPage) {
				this.currentPage = (totalPage - showPageNum + 1) <= 0 ? 1 : (totalPage
						- showPageNum + 1);
			} else {
				this.pageNumStart = currentPage - halpage + 1;
			}
		}
	}

	public int getPageNumEnd() {
		return pageNumEnd;
	}

	public void setPageNumEnd(int pageNumEnd) {
		int halfPage = (int) Math.ceil((double) showPageNum / 2);
		if (halfPage >= currentPage) {
			// this.pageNumEnd = showPageNum;
			this.pageNumEnd = showPageNum > totalPage ? totalPage : showPageNum;
		} else {
			if (currentPage + halfPage >= totalPage) {
				this.pageNumEnd = totalPage;
			} else {
				this.pageNumEnd = currentPage + halfPage;
			}
		}
	}

	public int getShowPageNum() {
		return showPageNum;
	}

	public void setShowPageNum(int showPageNum) {
		this.showPageNum = showPageNum;
	}

}
