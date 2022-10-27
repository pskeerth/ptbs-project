PTBS PROJECT# ptbs-project

This is my implementation of the PTBS project
Since it was open-ended in many ways I have done all functions in a way that I imagine a PTBS system would run. 

Initially the user is asked for Username and password 
If the Login fails, the appropriate message is displayed and option to create new user is provided. 
Next the user is asked whether he wants to add a trade or view all existing trades of any user

In the add trade function, if the user is a buyer, then he gets to enter the category and item name of the product he wants to buy
After that he gets the list of sells that want to sell that particular product. The buyer can now pick teh seller he wants to buy from and this trade transaction will remove the seller's item from the userproduct file(which means that the sellers item is sold and so is no longer available for purchase).

If the user is a seller, he gets to either add a new product that he wants to sell or simply sell his existing products.
If he wants to add a new product, the product details are taken and added to the existing list of product items.
If he wants to sell a product, he is shown a list of buyers who want to buy that particular product, and here I call the bidding functions where the seller simply selects which buyer he wants to sell to from the list of buyers who want to buy that product(This is done because there were no bidding prices involved)
Once a product is sold, that item is removed from the existing product list and from the userproduct file(meaning that the product is sold and no longer available)

In the view trading function, user is asked to input the name of the buyer or seller whose trade history he wants to see.
The result is a log of all available trades.

Sample run for Seller: src/main/resources/sampleRunSeller.txt
Sample run for Buyer: src/main/resources/sampleRunBuyer.txt

This is a maven project. 