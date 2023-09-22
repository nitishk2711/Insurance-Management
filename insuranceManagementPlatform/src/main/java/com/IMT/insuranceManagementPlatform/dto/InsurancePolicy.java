package com.IMT.insuranceManagementPlatform.dto;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String policyNumber;
	private String policyType;
	private double coverageAmount;
	private double premium;
	private LocalDate startDate;
	private LocalDate endDate;

	@ManyToOne
//	@JoinColumn(name = "client_id")
	private Client client;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [id=" + id + ", policyNumber=" + policyNumber + ", policyType=" + policyType
				+ ", coverageAmount=" + coverageAmount + ", premium=" + premium + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", client=" + client + "]";
	}

}
