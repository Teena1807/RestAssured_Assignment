package IBM.RestAssured_Assignment;

import java.util.List;

public class PojoforPet {
	private int id;
	private Child_category category;
	private String name;
	private List<String> photoUrls;
	private List<Childtags> tags;
	private String status;
		
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Child_category getCategory() {
		return category;
	}
	public void setCategory(Child_category category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public List<Childtags> getTags() {
		return tags;
	}
	public void setTags(List<Childtags> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
