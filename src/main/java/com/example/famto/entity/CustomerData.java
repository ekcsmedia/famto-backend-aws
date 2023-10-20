package com.example.famto.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import converter.ItemConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_data")
public class CustomerData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	

	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "lastUsedPlatform")
	private String lastUsedPlatform;
	
	@Column(name = "wallet_balance")
	private Double walletBalance;
	
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date registerAt;  // Auto order cancellation after x min // subject to discussion 
	
	@Column(name = "codStatus")
	private Boolean codStatus;
	
	@Column(name = "payLaterStatus")
	private Boolean payLaterStatus;
	
	@Column(name = "referralCode")
	private String referralCode;
	
	@Column(name = "rateAndReview")
	private Double rateAndReview;
	
	
	public String getLastUsedPlatform() {
		return lastUsedPlatform;
	}

	public void setLastUsedPlatform(String lastUsedPlatform) {
		this.lastUsedPlatform = lastUsedPlatform;
	}

	public Boolean getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Boolean codStatus) {
		this.codStatus = codStatus;
	}

	public Boolean getPayLaterStatus() {
		return payLaterStatus;
	}

	public void setPayLaterStatus(Boolean payLaterStatus) {
		this.payLaterStatus = payLaterStatus;
	}

	public String getReferralCode() {
		return referralCode;
	}

	public void setReferralCode(String referralCode) {
		this.referralCode = referralCode;
	}

	public Double getRateAndReview() {
		return rateAndReview;
	}

	public void setRateAndReview(Double rateAndReview) {
		this.rateAndReview = rateAndReview;
	}

	public List<VersionsModel> getVersions() {
		return versions;
	}

	public void setVersions(List<VersionsModel> versions) {
		this.versions = versions;
	}

	public List<TagsModel> getTags() {
		return tags;
	}

	public void setTags(List<TagsModel> tags) {
		this.tags = tags;
	}

	@Convert(converter = VersionsModel.class)
	@Column(columnDefinition = "json", name = "versions")
	private List<VersionsModel> versions = new ArrayList<>();
	
	@Convert(converter = TagsModel.class)
	@Column(columnDefinition = "json", name = "tags")
	private List<TagsModel> tags = new ArrayList<>();
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(Double walletBalance) {
		this.walletBalance = walletBalance;
	}

	public Date getRegisterAt() {
		return registerAt;
	}

	public void setRegisterAt(Date registerAt) {
		this.registerAt = registerAt;
	}

	@PrePersist
	private void onCreate() {
		registerAt = new Date();
	}
}


