package com.auctionservice.tcp.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author kushal
 	* ItemList class containing the list operations required for this application  
 */
public class ItemList {

	static List<Item> list = new ArrayList<Item>();

	 public static void addItem(Item i)
	 {
		list.add(i);
	 }
	 public static int getlength() 
	 {
		return list.size();
	 }
	 public static  void removeItem(Item i)
	 {
		list.remove(i);
	 }
	 public static String printList() 
	 {
		String str = "";
		Item element;
		int size=list.size();
		System.out.println("list size:" + size);
		if(size>0)
		{		
			Iterator<Item> it = list.iterator();
				while (it.hasNext())
				{
					element = it.next();
					str = str + "Item no:" + element.itemno + " Item name:"
							+ element.name + " Highest Bidder:"
							+ element.highestBidderName + " HighestBid:"
							+ element.highestBid + "\n";
		
				}
		}
		else
		{
			str=str+"list is empty";
		}

		return str;
	}

// public static void bidname(String para, String loginname)
//	 {
//		Item it = new Item();
//		int index = 0;
//		boolean flag = false;
//		String[] split = para.split(" ");
//		int value = Integer.parseInt(split[2]);
//		for (int i = 0; i < list.size(); i++) {
//			it = list.get(i);
//			if ((it.name.equalsIgnoreCase(split[1])) && (flag == false)) {
//				index = i;
//
//				System.out.println("item found");
//
//				flag = true;
//
//				if (it.highestBid == 0) {
//					it.highestBidderName = loginname;
//
//					it.highestBid = value;
//
//				}
//
//				else if (it.highestBid < value) {
//					it.highestBidderName = loginname;
//					System.out.println("here the value is" + value);
//
//					it.highestBid = value;
//
//				}
//
//				ItemList.list.set(index, it);
//
//			}
//
//		}
//
//	}

}
