package dad.starwars.api.client.items;

import java.util.List;

public class SearchResultItem {

	private Integer count;
	private Integer next;
	private Integer previous;
	private List<PeopleListItem> results;
	
	public List<PeopleListItem> getResult() {
		return results;
	}
	public void setResult(List<PeopleListItem> result) {
		this.results = result;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer total) {
		this.count = total;
	}
	public Integer getNext() {
		return next;
	}
	public List<PeopleListItem> getResults() {
		return results;
	}
	public void setResults(List<PeopleListItem> results) {
		this.results = results;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public void String(Integer next) {
		this.next = next;
	}
	public Integer getPrevious() {
		return previous;
	}
	public void setPrevious(Integer previous) {
		this.previous = previous;
	}
	
	
}
