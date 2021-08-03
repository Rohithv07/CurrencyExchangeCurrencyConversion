package com.rohith.microservices.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

/**
 * We need to make use of an entity class inorder to know what are the info that
 * we are storing inside the database and use those values later
 * 
 * @author rohithvazhathody
 *
 */
@Entity
public class CurrencyExchange {

	/**
	 * This field represents the primary key of the table
	 */
	@Id
	@ApiModelProperty(notes = "The database ID")
	private Long id;
	/**
	 * This field represents a column of the table, Since from is a keyword in sql,
	 * we change the column name
	 */
	@Column(name = "currency_from")
	@ApiModelProperty(notes = "The currency from which we need to convert")
	private String from;
	/**
	 * This field represents a column of the table, since to is a keyword in sql, we
	 * change the column name
	 */
	@Column(name = "currency_to")
	@ApiModelProperty(notes = "The currency to which we need to convert")
	private String to;
	/**
	 * This field represnet what is the conversion multiple for exchanging the
	 * currency
	 */
	@ApiModelProperty(notes = "The conversion multiple for one currency to another string")
	private BigDecimal conversionMultiple;
	/**
	 * This field represents what is is the environment we are working on.
	 */
	@ApiModelProperty(notes = "Says about the environment")
	private String environment;

	public CurrencyExchange() {
		// default constructor stub
	}

	/**
	 * All argument constructor
	 * 
	 * @param id
	 * @param from
	 * @param to
	 * @param conversionMultiple
	 */
	public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiple) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}
}
