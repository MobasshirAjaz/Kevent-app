## Kevents

**Team members**

 - Ayush Dev (2205222)
 - Daithoulung Rongmai(2205203)
 - Mobasshir Ajaz (2205222)
 - Isha Raj (22052388)
 - Vedang Upadhyay (22052431)
 
 **Requirements**
 
 - Mysql client and workbench
 - Node js
 - Android studio
 - VS Code

**Steps**

 - Clone the github repository.
 - Open the mysql workbench.
 - Select the data import option under the server menu.
 - In the data import window, select 'Import from self contained file' and select the .sql file inside the dumps folder which is inside the kevent folder.
 - In the data import window, select import progress tab and click start import. After the import is completed, you should see the kevents database.
 - Run the database by issuing query `Use kevents;`
 - Now open the kevent_server folder inside the kevents folder in VS Code.
 - In the terminal run command `node ./kevent_back.js`. This should start the server and you should see `Server running on port 3000` and successfully connected to the database.
 - Now open the the kevent folder in android studio. Wait for all the graddle builds to complete.
 - Click on the play button on the top. The app should run in a shortwhile.

**Here's a video link showing the app's working:**
https://youtu.be/8h0oHj2zYgo

**p.s:** To be able to run the app in phone, we would have to host the server in a real server, which was out of our expertise.


