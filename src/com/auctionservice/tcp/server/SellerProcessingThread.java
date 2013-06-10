package com.auctionservice.tcp.server;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author kushal
 */

/**
 * @author kushal
 * Performs all the functions of the seller
 * add <itemname>
 * list
 * sell <itemname>
 * exit 
 */
public class SellerProcessingThread extends Thread

{
	ItemList itemlist=new ItemList();
	Socket s = null;

	SellerProcessingThread(Socket sel) {

		s = sel;

	}

	public void addanitem(String add)

	{
		Item item = new Item();
		int itemNo=1;
		String[] split = add.split(" ");
		
		item.itemno = itemNo;
		item.name = split[1];
		item.highestBidderName = null;
		item.highestBid = 0;

		ItemList.addItem(item);
		itemNo++;
	}

	public void run()

	{
		String Displist = "";

		String seller = "seller";

		try {

			BufferedReader bf = new BufferedReader(new InputStreamReader(
					s.getInputStream()));

			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

			pw.println("Enter your Login name:");

			String str = bf.readLine();

			

			if (str.equalsIgnoreCase(seller)) {
				String login = "Login Successful";
				System.out.println(seller + " " + login);
				pw.println(login);

				while (true) {

					String para = bf.readLine();

					if (para.contains("add")) {
						addanitem(para);
						pw.println("Your Item was  added successfully");

					}

					else if (para.contains("list")) {
						Displist = ItemList.printList();
						System.out.println(Displist);
						pw.println(Displist);
						// pw.println("here is the list");

					}

					else if (para.contains("sell")) {
						Item it = new Item();
						int index = 0;
						boolean flag = false;
						String[] split = para.split(" ");
						System.out.println("LIst size is :::"+ItemList.getlength());
						for (int loop = 0; loop < ItemList.list.size(); loop++) {
							it = ItemList.list.get(loop);
							if ((it.itemno==(Integer.parseInt(split[1])))&& (flag == false)) {
								flag = true;
								
								System.out.println(ItemList.printList());
								pw.println("Item "+ it.name+ " has been removed from the auction list");
								it.buyerPrintWriter.println("Congratulations!! you have won the bid on item "+ it.name);
								ItemList.list.remove(index);
							}

						}

					}

					else if (para.contains("exit")) {

						pw.println("BYE");
						break;
					}

					else {
						System.out.println("Unrecognized command");
						pw.println("Unrecognized command");
					}

				}// end while

			}// end if loop

			else {
				String login = "Login Failed";
				System.out.println(login);
				pw.println(login);

			}

			// ...........close streams and sockets......................

			bf.close();
			pw.close();
			s.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
