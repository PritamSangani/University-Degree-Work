# ELIZA-Plus

ELIZA-Plus is a extension of the famous ELIZA chatterbot conceived by Joseph Weizenbaum in 1966.

ELIZA-Plus implements a long-term memory mechanism. It does this in two parts - a database and using a natural language processing algorithm called Named Entity Recognition.

The algorithm will extract entities from the body of the text the user inputs and store them in the database. There is logic implemented in the chatterbot, which determines when there is an opportunity to use the entities and feeds the entity back into the response. This allows the chatterbot to mimic a sense of memory.

## Instructions on using this software

To run this software you will need to have Python 3.7+ installed on your local machine. These instructions are for Windows OS.

Once you have downloaded the source code, run this command in Windows Powershell within the source folder:

`python -m venv venv`

This will create a virtual environment to keep your global Python installation clean from any modules installed for this project.

To install the requirements for this project, you will first need to activate the virtual environment you created by running this command:

`venv/Scripts/Activate.ps1`

Your prompt should look something like this:

`(venv) [Path to folder] >`

To install the requirements, which are listed in `requirements.txt`, run this command:

`pip install -r requirements.txt`

Once this is completed, you are now ready to run and explore this software. To run this app you need to run this command:

`python app.py`

This will start the server and will give you a link to the website once the server is up. Click or Ctrl-Click on this url and it will take you to the website.

You will need to create an account using a Google account or using your email and password. Once signed up you are ready to chat to ELIZA.

## Folder Structure

The folder is structured as follows:

C:.  
|   .gitignore  
|   .jshintrc  
|   app.py  
|   eliza.py  
|   Procfile  
|   README.md  
|   requirements.txt  
|   runtime.txt  
|   tree.txt  
|   
+---.idea  
|  
+---.vscode  
|  
+---static  
|   +---css  
|   |       chat.css  
|   |       main.css  
|   |       notifications.css  
|   |       send.css  
|   |       
|   +---images  
|   |       eliza-logo.png  
|   |       guy.png  
|   |       laptop.png  
|   |       
|   \---js  
|           chat.js  
|           config.js  
|           index.js  
|           notifications.js  
|           socketApp.js  
|           
+---templates  
|       index.html  
|       
+---venv  
|  
\\---\_\_pycache\_\_

The HTML file is in the `templates` folder, whilst the images, JavaScript and CSS files are in the `static` folder.

## File contents

### chat.js
        
`chat.js` contains all the code to display chat messages and get the HTML content of the chat depending on whether the message is from the user or from ELIZA.

### config.js

`config.js` contains the code to set up and configure the database and authentication service settings using Google's Firebase service

### index.js

`index.js` contains the bulk of the JavaScript code and contains code dictating what sign-in methods are used for the UI of the Authentication service and handles what happens when a user signs-in, signs-up, or logs out of the application. It also contains the code interacting with the database which are the following interactions:

- create a user in the database if one with that email doesn't exist
- retrieve the user object from the database when an existing user logs in - this is to retieve the chat id and entities
- using the chat id retrieve all of the chat messages from the database
- send chat messages to the database
- send entities to the database (this file also contains code to add a timestamp to each of the entity documents)

### notifications.js

`notifications.js` contains code to alert the user to any error. This application is limited to one alert - when a user tries to submit a message with no content.

### socketApp.js

`socketApp.js` contains all the code related to web sockets with the following interactions:

- when the client side of the socket connects to the server side of the socket, it emits a message notifying the server
- when the user submits a message, the message is emitted along with the entities in a json object 
- when a message is received from the server, the code sends a call to the function to display a message.

### app.py

`app.py` complements `socketApp.js` in the sense that the code to connect to the socket from the server is in this file. This file also contains the code to start the server and render the web page. The message is sent to the ELIZA script in this file.

### eliza.py

`eliza.py` contains all the code to do with the ELIZA chatterbot. It contains a dictionary of all the patterns and responses to input and the logic of when to feed back entities into the responses to user input.