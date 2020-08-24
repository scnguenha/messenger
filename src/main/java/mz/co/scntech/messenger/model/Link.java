
package mz.co.scntech.messenger.model;

/**
 *
 * @author Sidónio Goenha on Aug 24, 2020
 *
 */
public class Link {
	private String link;
	private String rel;

	public Link() {
	}

	public Link(String link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

}
