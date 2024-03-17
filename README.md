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
Make sure you are done with this step: [Java Database: MySQL JBDC Driver](https://www3.ntu.edu.sg/home/ehchua/p[MySQL JDBC DRIVER]rogramming/java/JDBC_Basic.html?fbclid=IwAR0Tb0gT4JBpLRwxk8c-f4Wsq0uVUvcyzBW-Ms3ZOEuAw87zfWTgQLN8oQE#zz-3)

1. Ensure You Have Cloned the Repository: Confirm that you’ve cloned the entire application repository from GitHub, including the **“db_dump.sql”** file.

2. **Open your CMD:** Open your command line and locate your MySQL installation folder (usually in the MySQL bin directory). 
*An example of the file address or file path: “C:/ProgramFiles/MySql 8.0/mysql/bin”. This is assuming MySQL is installed in that directory.*

3. **Next step is to start the MySQL Database Server:** Type in **mysqld --console** in the same command line. Make sure to leave this CMD open until the end of your use of the application.

4. To connect to our database, make sure to open **ANOTHER NEW CMD** to run the client. 

5. **Logging In to MySQL Server:** Once you have open another CMD, type in this command: **mysql -u myuser -p**
The “Enter password” will show up in the next line. The password is: **remwell996**

6. **Restore the Database from the Dump File:** Assuming the “managementsystem” database already exists, restore the data from the dump file: **mysql -u myuser -p managementsystem < "C:\\path\\to\\db_dump.sql"**


7. **Verify the Database:**
- Reconnect to MySQL:
mysql -u myuser -p managementsystem

- Check if the tables and data are intact:
mysql> SHOW TABLES;
mysql> SELECT * FROM table_name;

8. Right then, you can be able to use our *Management System* as an admin with the privileges in **viewing, adding, deleting, updating clients and services.**
