## ✨ WELCOME TO CLIENT MANAGEMENT SYSTEM ✨  
By Rem Well Pepito & Mary Kate Saguin
ITCC 11.1 - B

## ⚙️ APPLICATION FEATURES
Our application, Management System, is run by an admin which is the virtual assistant.
The admin has the privilege to view, add, delete, update the clients, services, and invoice, all at once.

These are the following functions and features:
1. **VIEW CLIENTS** - Displays all the recorded clients.
2. **ADD CLIENTS** - You can add another service and add the details for it.
3. **DELETE CLIENTS** - You can be able to Delete a specific Service along with its records.
4. **UPDATE CLIENT INFO** - You can update the client informations (name, email)
5. **VIEW ALL SERVICE** - Displays available services offered.
6. **ADD NEW SERVICE** - You can add another service and add the details for it.
7. **DELETE A SERVICE** - You can be able to Delete a specific Service along with its records.
8. **UPDATE A SERVICE** - You can update the service informations (price, type, etc.)
9. **SHOW STATISTICS** - This is where we can see which service is most availed, and which customer has the most ordered.


## 🗂️ HOW TO RECREATE THE DATABASE FROM THE SQL DUMP
1. If you have already cloned the whole files for our application from the git hub repository, make sure that you have included the sql dump file named as *‘db_dump.sql’* as this is crucial in obtaining the database.

2. **Open your CMD:** Open your command line and make sure to locate your MySQL file. The goal is to find the root folder of your MySQL server application and locate its bin. An example of the file address or file path: “C:/ProgramFiles/MySql 8.0/mysql/bin”. This is assuming MySQL is installed in that directory.

3. Next step is to start the MySQL Database Server: Type in **mysqld --console** in the same command line. Make sure to leave this CMD open until the end of your use of the application.

4. To connect to our database, make sure to open **ANOTHER NEW CMD** to run the client. *Recall that the MySQL is a client-server system. Once the server is started, one or more clients can be connected to the database server. A client could be run on the same machine (local client); or from another machine over the network (remote client).To login to the MySQL server, you need to provide a username and password.*

5. **Logging In to MySQL Server:** Once you have open another CMD, type in this command: **mysql -u myuser -p**
The “Enter password” will show up in the next line. The password is: **remwell996**

6. After entering the password, the next line should tell you are welcomed to the MySQL monitor.

7. You can try to type in MySQL commands such as show databases; to show the current database that we are using entitled as ‘managementsystem’. 

Type in another MySQL command **use managementsystem;** , then another command **show table** to display if you want to see the available tables and datas within it. You can select or view the data with an sql command *SELECT * FROM (Table Name)*

8. Right then, you can be able to use our *Management System* as an admin with the privileges in **viewing, adding, deleting, updating clients and services.**

