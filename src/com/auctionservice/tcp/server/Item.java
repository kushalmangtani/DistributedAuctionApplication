package com.auctionservice.tcp.server;



import java.io.PrintWriter;

/**
 * @author kushal
 * A POJO class for Item
 */
public class Item {

	int itemno;
	String name;
	String highestBidderName;
	int highestBid;
	PrintWriter buyerPrintWriter = null;

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHighestbiddername() {
		return highestBidderName;
	}

	public void setHighestbiddername(String highestbiddername) {
		this.highestBidderName = highestbiddername;
	}

	public int getHighestbid() {
		return highestBid;
	}

	public void setHighestbid(int highestbid) {
		this.highestBid = highestbid;
	}

	public PrintWriter getBuyerpw() {
		return buyerPrintWriter;
	}

	public void setBuyerpw(PrintWriter buyerpw) {
		this.buyerPrintWriter = buyerpw;
	}

}
