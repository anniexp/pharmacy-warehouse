# pharmacy-warehouse

 Java dbUtil exercise for preparing statements for oracle relaional db
  -  the application has fronend and backend parts
  -  the frontend views are made with javafx
  -  the source code is made with java 8 (1.8.)
  -  the statements are being prepared in a dbUtil class
  -  the dbUtil class uses the dbUtil class of the util library
  -  the business logic of each table is in a coresponding controller
  -  the home page consists of buttons with links to each forms
  -  the prepare statements execute getAll, getById, create and delete requests to the db
  -  the application does not consist of every single requests for every single table
  -  there are also provided files with sql script, eer model and r model
 
 
 
Brief information about the pharmacy warehouse database :
 The database serves to serve some of the functionalities in a pharmacy warehouse system, more precisely the functionalities related to the items in the warehouse. It will be able to consult the items that enter and leave the warehouse. 
 It excludes staff (pharmaceuticals, accountants, cleaners, warehouse workers, drivers, warehouse manager), work schedules, daily turnover reports from pharmacies where items are sent, bill costs, promotional campaigns, etc. 
 The system is simplified for the needs of the course. The main components of the database will be the items themselves, information about orders from a list of suppliers, respectively and ordering them from pharmacies that the warehouse serves.
 The items with which the warehouse works are divided medicaments and food supplements, with their respective specifications.
 Each item is part of a particular batch, with a batch number and expiry date, which apply to all products in it.
 Medications are divided into drug groups and have certain active ingredients, while dietary supplements specialize according to their so-called E-number.
 The orders can be from a distributor to the warehouse (orders in) or from the warehouse to an affiliated pharmacy (orders out)
 Each order has products in it with information about their name, quantity nd price by piece 
 
 Sample requests that can be made with the relevant database :
  -  From a batch with a certain number, how many products are left in the warehouse. 
  -  For a certain period of time, which products of a particular drug group were sold the most. 
  -  Whether there are expired items From which suppliers are food additives obtained in a certain period of time
  -  Changes in the prices of items from a vendor in a certain period of time
  -  A drug group checks which drugs with the same active ingredients are most taken without a prescription.
  -  In case of violation of the quality of all products in certain premises, it should be possible to check for the losses of the warehouse from the goods itself (VAT included).

