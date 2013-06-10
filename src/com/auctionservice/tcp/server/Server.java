package com.auctionservice.tcp.server;

/**
 * 
 * 
 * @author kushal
	 * TCP Server Main Class
	 * Instantiates a Thread for each SellerActivation and BuyerActivation respectively 
 */

public class Server {
	public static void main(String args[])
	{
		System.out.println("Hi,Im the Multithreaded SERVER");
		SellerActivationThread mythread1 = new SellerActivationThread();
		mythread1.start();
		BuyerActivationThread mythread2 = new BuyerActivationThread();
		mythread2.start();
	}

}
