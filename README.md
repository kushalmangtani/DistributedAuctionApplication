DistributedAuctionApplication
=============================

Implemented a TCP Auction application in a distributed environment consisting of a client,server.Server capable of processing multiple clients and their bids concurrently.
Technologies:Java 1.6,Java Networking,Java Multithreading,Java FileI/O,TCP/IP protocol suite

Client: A client can be  Seller,Buyer
        Seller supports the following commands:
        1) login: Used for logging in the system
        2) list: Displays the bidding list in the following format
        <ItemId> <ItemName> <ItemAmount> <HighestBidder> <HighestBid>
        3) add <itemname>:Adds an item in the Bidding List<
        4) sell <itemId>: Deletes the item from the bidding list.Also,sends a socket message to the highest bidder saying "Congratulations!!,you have won the bid on <itemname>"
        5)exit:Used for exiting the application
        
        Buyer supports the following command
        1) login: Used for logging in the system
        2) list: Displays the bidding list in the following format
        <ItemId> <ItemName> <ItemAmount> <HighestBidder> <HighestBid>
        3) bid <itemId> <itemAmount>:Used to place a bid on the ItemId passed in the argument.
        If bid < HighestBid 
        then prints a "Low bid" message in System console
        else
        Prints "highest bidder " in System Console
        Sends a Socket message to the Second Highest Bidder saying "You have been outbidden on <itemname>"
        
Server :  The Server is multithreaded and allocates a thread for each client's processing.Also, the server prints all the updations in its System console       
       
