package com.auctionservice.tcp.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author kushal 
 * Creates a ServerSocket for BuyerClients
 * while(true)
	 *  Waits for a BuyerClient
	 *  Accepts it 
	 *  Allocates a new thread for processing that BuyerClient
 */
public class BuyerActivationThread extends Thread
{
	public void run()
	{
		Socket socket = null;
			try
			{
					ServerSocket Server = new ServerSocket(7000); // ServerSocket for BuyerClients
					while (true) 
					{
						socket = Server.accept();
						new BuyerProcessingThread(socket).start();
					}
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
	}
}
