package com.example.famto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurant_data")
public class RestaurantData implements Serializable{
	
    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int restaurantId;
	
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@Column(name = "address")
	private String address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "city")
	private String city;
	@Column(name = "display_address")
	private String displayAddress;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "description")
	private String description;
	@Column(name = "slug")
	private String slug;
	@Column(name = "logo_url")
	private String logoUrl;
	@Column(name = "banner_url")
	private String bannerUrl;
	@Column(name = "bg_color")
	private String bgColour;
	@Column(name = "rating_bar_color")
	private String ratingBarColor;
	@Column(name = "tag")
	private String tag;
	@Column(name = "serving_area")
	private String servingArea;
	@Column(name = "commission_type")
	private String commissionType;
	@Column(name = "business_category")
	private String businessCategory;
	@Column(name = "rating")
	private Double rating;
	@Column(name = "service_status")
	private Boolean serviceStatus;
	@Column(name = "sponsorship")
	private Boolean sponsorship;	
	@Column(name = "commission_value")
	private Double commissionValue;	
	@Convert(converter = RestaurantTagsModel.class)
	@Column(columnDefinition = "json", name = "restaurantTags")
	private List<RestaurantTagsModel> restaurantTags = new ArrayList<>();
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDisplayAddress() {
		return displayAddress;
	}
	public void setDisplayAddress(String displayAddress) {
		this.displayAddress = displayAddress;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getBannerUrl() {
		return bannerUrl;
	}
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
	public String getBgColour() {
		return bgColour;
	}
	public void setBgColour(String bgColour) {
		this.bgColour = bgColour;
	}
	public String getRatingBarColor() {
		return ratingBarColor;
	}
	public void setRatingBarColor(String ratingBarColor) {
		this.ratingBarColor = ratingBarColor;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getServingArea() {
		return servingArea;
	}
	public void setServingArea(String servingArea) {
		this.servingArea = servingArea;
	}
	public String getCommissionType() {
		return commissionType;
	}
	public void setCommissionType(String commissionType) {
		this.commissionType = commissionType;
	}
	public String getBusinessCategory() {
		return businessCategory;
	}
	public void setBusinessCategory(String businessCategory) {
		this.businessCategory = businessCategory;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public Boolean getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(Boolean serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public Boolean getSponsorship() {
		return sponsorship;
	}
	public void setSponsorship(Boolean sponsorship) {
		this.sponsorship = sponsorship;
	}
	public Double getCommissionValue() {
		return commissionValue;
	}
	public void setCommissionValue(Double commissionValue) {
		this.commissionValue = commissionValue;
	}
	public List<RestaurantTagsModel> getRestaurantTags() {
		return restaurantTags;
	}
	public void setRestaurantTags(List<RestaurantTagsModel> restaurantTags) {
		this.restaurantTags = restaurantTags;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}

