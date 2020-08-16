# 2013 Accident Tracker System ASP.NET and Android
 
# Description of the application:

This application was first thought by Dr. Zong Tian as part of his ongoing research on Intelligent Transportation System at the University of Nevada, Reno in USA. Later Md. Arafat Hossain Khan, PhD student of Dr. Zong Tian, developed the application.

# Technical detail
This application has two basic User Interfaces:
1.	Mobile Application: This part of the application was particularly designed for Android phone. Any user of Android Mobile phone equipped with GPS facility may install this software and post information of accidents to this website. To run the application satisfactorily one need Android 2.2 or higher.
2.	Web Application: This website was based on ASP.NET 3.5 and SQL Server 2005. All the data posted by mobile phones will come directly to this website. Anyone can see the posted data on the map.

# User Manual

## Installation on Mobile
1.	Get the apk file from the ‘\Android-Accident-Tracker\bin’ folder of the project.
2.	Install it to your mobile phone.
3.	Run the application.
## Google Map and Your Current Location
4.	You will get google map showing your current location.
5.	 You can zoom to your location.
6.	 If you are moving, the application will automatically update your location.
## Tracking an Accident
7.	You can track an accident by zooming in to the exact place of accident and then press and hold on that location for at least 1 second. You will get a dialog box asking you the following three,
 - Place a pinpoint (this will place a pinpoint)
 -	Toggle view (this will toggle between street and satellite views)
 - Get Address (this will tell you the address of the place you pressed)

Once you placed a pinpoint on the location where the accidents actually occurred, the button 'Toggle View' will be replaced by another button titled 'Post Accidents'. You may want to place more than one pinpoints to track multiple accidents. You may proceed to do anyone of these. Sometimes placing a pinpoint on google map may appear a little slow. You may not notice a pinpoint right after placing it. Please wait for 10 to 15 seconds; you will get your pinpoint placed on the exact location you want.


## Posting Data

8.	Once you clicked the button ‘Post Accidents’ you will get a form showing the following fields,
 - Latitude
 - Longitude
 -	Date & Time
 -	Address
 -	Description
9.	 You will not be able to change the Latitude and longitude.
10.	The Date & Time is already set to the value when you actually placed the pushpin. But you can edit this using ‘Change Date and Time’ button.
11.	Sometimes Geocoder fails to obtain the address. In that case you should enter it manually in the Address Textarea.
12.	Finally you may want to enter your observation and other important data about the accident in the ‘Description of the accident’ Textarea.
13.	You will find few more buttons on this form,
 -	Post Data: The data will be stored in the database.
 - Skip: The data will be lost.
 - View All Data: You will get a table showing all available accident data posted by you and others.
 - View Your Posted Data: This will show you the table that contains everything posted by you.
 - Track New Accidents: This will take you back to the map to track new accidents.

# About Database

14.	The application uses two databases,
 - SQL Lite on in your Android Phone
 - SQL Server for the website.
15.	SQL Lite: This database will record all the accidents tracked by you.
16.	SQL Server: This will record all the accidents tracked by everyone.
About the Website

17.	Once you visit the website you will see Google map showing pinpoints at many places. This means that there were accidents at those places recorded by the users of this application.
18.	To get detail of any particular accident, you may zoom into that place and click on the pinpoint. A tooltip containing the information of that accident will be shown.
