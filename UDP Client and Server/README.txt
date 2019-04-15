		
------------------------------------------------------------
				INSTRUCTIONS FOR USERS
------------------------------------------------------------

Pre-Requisites:
	* Java JDK installed on the computer
	* Java JDK added to 'Path' in Environment Variables -> User Variables
	
1) Open 2 CMD windows 

2) Change directory to folder containing UDPServer.java and UDPClient.java for both cmd window
	eg: cd C:\CECS327 HW3\

3) Compile Java Files-
	On any of the CMD window, type and enter 'javac *.java' without the single quotes and press enter

4) RUN UDPServer.java - 
	Type and enter 'java UDPServer.java [portnumber]' on one of the CMD window with 4 digit port number

5) RUN UDPClient.java -
	Type and enter 'java UDPClient.java [message] [InetAddress] [portnumber]' on the other CMD window
	with your desired message, Inet Address, and matching port number with Server

