
package mz.co.scntech.messenger.resources;

import jakarta.ws.rs.QueryParam;

/**
 *
 * @author Sidónio Goenha on Aug 24, 2020
 *
 */
public class MessageFilterBean {
	private @QueryParam("year") int year;
	private @QueryParam("start") int start;
	private @QueryParam("size") int size;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
