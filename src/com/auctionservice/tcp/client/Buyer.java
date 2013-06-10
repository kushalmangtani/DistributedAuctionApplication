package com.auctionservice.tcp.client;
import java.io.*;
import java.net.*;

/**
 * @author kushal 
	 * Creates a Client Socket for the BuyerClient
	 * Reads System.in of the BuyerClient
	 * Passes this data to the Server for processing
	 * Accepts the Server response and prints onto BuyerClient's System.out
 */
class Buyer 
{
	public static void main(String[] args) throws IOException
	{
		System.out.println("Hi,Im a  Buyer Client");
		InetAddress inetAddress;
		String parameter = "";
		Socket client = null;
		BufferedReader input=null;
		BufferedReader bufferredReader=null;
		PrintWriter printWriter=null;
		
			inetAddress = InetAddress.getLocalHost();
			client = new Socket(inetAddress, 7000);
			input = new BufferedReader(new InputStreamReader(System.in));
			bufferredReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			printWriter = new PrintWriter(client.getOutputStream(), true);
			System.out.println(bufferredReader.readLine());
			printWriter.println(input.readLine());
			String loginMessage = bufferredReader.readLine();
			if (loginMessage.contains("Success")) 
			{
					System.out.println(loginMessage);
					while (true)
					{
						char[] cbuf = new char[400];
						parameter = input.readLine();
						printWriter.println(parameter);
						bufferredReader.read(cbuf);
						System.out.println(cbuf);
						if (parameter.contains("exit"))
						{
							break;
						}
					}
			} 
			else
			{
				System.out.println(loginMessage);
			}

			printWriter.close();
			bufferredReader.close();
			input.close();
			client.close();
	}
}
