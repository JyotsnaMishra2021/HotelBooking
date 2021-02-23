Queue Management
1.	Introduction:
This document will describe how Queue Management project can be deployed in the local system. It’s a REST API project using Spring Boot Framework in java. This project received the message of hotel reservation and process the data accordingly. This project has been written in such a way that if there will be any exception, the data will be written in a txt file to avoid any kind of messages loss.
1.1.	Design:
Whenever data will be received from Hotel via the HTTP services, this service will call the Consumer which will process the data. It will generate a CORELATION_ID and send it back to the hotel for future reference. In case of any exception like Consumer is down, the data will be saved as txt file which can be processed later by some regular scheduled job.
1.2.	Assumption:
i)	The data from hotel will be sent as simple text.
ii)	Service Consumer will not generate any CORELATION ID asynchronously as this is out of scope.
iii)	No database has been used.
iv)	Failed request will be saved in file.
1.3.	Performance & Maintainability:
i)	Since this process is asynchronous, hence the performance will be increased to a greater extent.
ii)	Any changes will need less amount of time to deploy.
iii)	Multiple requests can be processed easily without any performance impact.
iv)	Error handling will not let any messages to be lost.
2.	Prerequisite
2.1.	Tools:
i)	Eclipse IDE. In case you don’t have Eclipse installed in local system, the same can be downloaded from below link:
https://www.eclipse.org/downloads/packages/release/neon/2/eclipse-ide-java-developers
2.2.	Technology:
i)	Java
ii)	REST API
iii)	Spring Boot Framework
3.	Download or clone the project git: 
Follow the below steps in order to deploy the project in local system.
i)	Download the project from below given git clone project path.
JyotsnaMishra2021/HotelBooking (github.com)
ii)	Unzip it
iii)	Open eclipse
iv)	Select workspace folder and click on Launch button in the Eclipse.
v)	Import projectselect mavenexisting maven project
vi)	Browse downloaded source code and click on finish
vii)	Clean and build project

3.	How to test the project:
i)	Open class BookingApplication.java and run it as java application.
ii)	Open the browser and paste the below URL test the service.
http://localhost:9090/booking?name=Jyotsna&phoneNumber=90786548&bookingDate=22022021
Data in the URL can be modified to test it.
iii)	To test exception scenario 
In order to test the exception scenarios, uncomment line 26 of BookingService.java class. Whenever there is any exception, the message will be written as txt file and will be stored in the same path where project is saved. This path can be modified and file can be saved in other locations also. Instead of file, the data can also be stored in database.

4.	Questions:
1.	In the README, please explain design decisions and assumptions you have made. Consider aspects such as Maintainability, Scalability, Performance, etc.
Solution: Please refer section 1.3
2.	If you decide to use external libraries, make sure to justify why you picked them. 
Solution: No external API has been used.
3.	Do you see any problems with this setup? 
Solution: Below mentioned problems was encountered while executing it.
i)	Every time Server needs to be stopped first then restart. 
4.	What kind of data does the message by the sender NEED to contain to ensure they are imported in the correct order? 
Solution: Request and response can be send in JSON format as this is inbuild feature of Spring boot. If instead of JSON, we will use xml format then we have to add xml dependency in pom.xml.
5. Are there any optimisations you see but didn’t implement?
Solution: For this current project, no optimization is needed.


