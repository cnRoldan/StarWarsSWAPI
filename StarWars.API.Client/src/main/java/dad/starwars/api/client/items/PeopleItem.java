package dad.starwars.api.client.items;

import java.time.LocalDateTime;

public class PeopleItem extends PeopleListItem{
	
	private Integer height;
	private String mass;
	private String hairColor;
	private String skinColor;
	private String eyeColor;
	private Double birthYear;
	private String gender;
	private String homeworld;
	private LocalDateTime created;
	private LocalDateTime edited;
	
	
	public String getHairColor() {
		return hairColor;
	}
	
	public String getEyeColor() {
		return eyeColor;
	}
	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getSkinColor() {
		return skinColor;
	}
	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}
	public Double getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Double birthYear) {
		this.birthYear = birthYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHomeworld() {
		return homeworld;
	}
	public void setHomeworld(String homeworld) {
		this.homeworld = homeworld;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getEdited() {
		return edited;
	}
	public void setEdited(LocalDateTime edited) {
		this.edited = edited;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getMass() {
		return mass;
	}
	public void setMass(String mass) {
		this.mass = mass;
	}

}
