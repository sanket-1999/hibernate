package com.hibernate.one_many;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MARKET")
public class Market {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	
	private int marketid;
	private String marketname;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid")
	@OrderColumn(name = "name")
	private List<Stock> stocks;

	public int getMarketId() {
		return marketid;
	}

	public void setMarketId(int marketid) {
		this.marketid = marketid;
	}

	public String getMarketname() {
		return marketname;
	}

	public void setMarketname(String marketname) {
		this.marketname = marketname;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
}
