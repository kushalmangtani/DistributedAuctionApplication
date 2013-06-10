package com.auctionservice.tcp.server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author kushal
	 * Implements the functionality of the BuyerClient
	 * bid <itemname> <amount:int>
	 * list
	 * exit
 *
 */
public class BuyerProcessingThread  extends Thread
{
	Socket clientSocket = null;
	BuyerProcessingThread(Socket socket)
	{
		clientSocket = socket;
	}
	
	public void run() 
	{
		boolean buyerFlag = false;
		String listData = "";
		String[] buyer = {"alice","amy","bob","dave","pam","tom"};
		BufferedReader bufferedReader=null;
		PrintWriter printWriter=null;
		try
		{
			bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			printWriter = new PrintWriter(clientSocket.getOutputStream(), true);
			printWriter.println("Enter your Login name:");
			String str = bufferedReader.readLine();
			System.out.println(str);
			for (int i = 0; i < buyer.length; i++) 
			{
					if ((str.equalsIgnoreCase(buyer[i])) && (buyerFlag == false)) 
					{
						String login = "Login Successful";
						String loginname = buyer[i];
						System.out.println(loginname + " " + login);
						printWriter.println(login);
						buyerFlag = true;
						while (true)
						{
							String para = bufferedReader.readLine();
							buyerFunctionProcess(para, bufferedReader, printWriter, loginname, listData);
							 if (para.contains("exit"))
							 {
								printWriter.println("BYE");
								break;
							 }
						}
					}
			} 

			if (buyerFlag == false) 
			{
				String login = "Login Failed";
				System.out.println(login);
				printWriter.println(login);
			}

		} 
		catch (IOException exception) {
			exception.printStackTrace();
		}
		
		finally
		{
			try
			{
				bufferedReader.close();
				printWriter.close();
				clientSocket.close();
			}
			catch (IOException exception)
			{
				exception.printStackTrace();
			}
		}

	}
	public void bidProcess(Item it,String str,boolean flag,PrintWriter printWriter,String loginname,int value)
	{

		if ((it.itemno==Integer.parseInt(str))&& (flag == false)) {
			flag = true;

			if (it.highestBid == 0) {
				it.buyerPrintWriter = printWriter;
				it.highestBidderName = loginname;

				it.highestBid = value;

				printWriter.println("You have the higgest bid for item "
						+ it.name);
			}

			else if (value < it.highestBid) {
				printWriter.println("Your bid is not high enough");

			}

			else if (it.highestBid < value) 
			{
				it.buyerPrintWriter.println("You have been outbidden on item "+ it.name);
				it.highestBidderName = loginname;
				System.out.println("here the value is"
						+ value);
				it.buyerPrintWriter = printWriter;
				it.highestBid = value;
				printWriter.println("You have the higgest bid for item "
						+ it.name);

			}

		}

	
	}
	
	private void buyerFunctionProcess(String para,BufferedReader bufferedReader,PrintWriter printWriter,String loginname,String listData) throws IOException
	{

		if (para.contains("bid"))
		{
			Item it = new Item();
			boolean flag = false;
			String[] split = para.split(" ");
			int value = Integer.parseInt(split[2]);
			for (int loop = 0; loop < ItemList.list.size(); loop++)
			{
				it = ItemList.list.get(loop);
				bidProcess(it, split[1], flag, printWriter, loginname, value);
			}

		}

		else if (para.contains("list")) 
		{
			listData = ItemList.printList();
			System.out.println(listData);
			printWriter.println(listData);

		}

	}

}
