package com.auctionservice.tcp.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kushal 
 * Creates a ServerSocket for SellerClients
 * while(true)
	 *  Waits for a SellerClient
	 *  Accepts it 
	 *  Allocates a new thread for processing that SellerClient
 */
public class SellerActivationThread extends Thread
{
	public void run()
	{
		Socket socket = null;
			try
			{
				ServerSocket Server = new ServerSocket(6000); // ServerSocket for SellerClients
				while (true) 
				{
					socket = Server.accept();
					new SellerProcessingThread(socket).start();
				}
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
	}
}
