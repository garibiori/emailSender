## Email

*  Email Program.
*  Recieves information to send to SMTP server and server sends email.
*  Waits for a Welcome message from the server.
*  Sends the first sentence to the server.
*  Recieves server responses
*  Closes the socket and exits

In this program, we wrote code that recieves information from the user to send to an SMTP server. The information that the user would type in includes the sender email, reciever email, sender name, reciever name, subject, and the message itself. After the user types in all this information, they end the program by typing "." and pressing the "enter"/"return" key. This causes the user input portion of the code to end, displaying a "Quit" message to the user, and sends the information the user inputted to an SMTP server. The Email program waits for a Welcome message from the server and once it gets that message, it sends the first sentence to the server, which continues until there is no new sentences to send. After this is done, the program closes the socket and exits, displaying a "Bye" message to the user. The result is an email sent from the user-specified sender email address to the user-specified reciever email address with all the information specified by the user.

## Identifying Information

* Name: Ori Garibi and Ofek Shoichet
* Student ID: 2367830, 2371178
* Email: garibi@chapman.edu and shoichet@chapman.edu
* Course: CPSC 353
* Assignment: PA01 Email

## Source Files
* java TcpServer
* java Email

## References
None, other than class material

## Known Errors
No known errors

## Build Insructions
javac *.java

## Execution Instructions
* java TcpServer
* java Email

(run in two seperate terminal windows in this exact order)
