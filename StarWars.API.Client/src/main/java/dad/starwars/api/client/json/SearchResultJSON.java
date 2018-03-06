package dad.starwars.api.client.json;

import java.util.List;

public class SearchResultJSON {
	private Integer count;
	private String next;
	private String previous;
	private List<People> results;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void String(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<People> getResults() {
		return results;
	}
	public void setResults(List<People> results) {
		this.results = results;
	}
	
	
	
}
