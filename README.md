**EasyBank: Financial Management System**
EasyBank is a desktop banking application developed in Java, featuring SQL database integration to provide users with a streamlined platform for managing financial transactions. It includes essential banking functionalities such as account creation, fund transfer, bill payments, and downloadable mini statements in PDF format.

**Table of Contents**
Overview
Features
Technology Stack
Getting Started
Usage
Configuration
Contact


**Overview**
EasyBank is designed to be an accessible and straightforward financial management system, suitable for individuals or small businesses needing basic banking operations. Developed using Java (Swing) for the frontend and MySQL as the backend database, it provides functionalities such as account management, transaction history tracking, and the ability to download transaction summaries in PDF format.

**Key Highlights**
Intuitive interface built using Java (Swing)
SQL database (MySQL) integration
Auto-generated account numbers for streamlined onboarding
Supports profile customization with password change capability

**Features**
Create Savings/Current Account: Users can create savings or current accounts.
Multiuser Login: Supports multiple user logins with personalized profiles.
Profile Dashboard: Displays user-specific account details and options.
Fund Transfer and Bill Payments: Users can transfer funds and pay bills.
Change Password: Allows users to update their login password.
Download Mini Statement: Transaction history available as a downloadable PDF.
Application Forms: Users can apply for debit cards, credit cards, and loans.

**Technology Stack**
Frontend: Java (Swing)
Backend: MySQL
Connectivity: JDBC (Java Database Connectivity)
IDE: NetBeans
JAR Files:
itextpdf-5.5.13: For generating PDF statements.
javax.mail: For email functionalities (if any).
mysql-connector-j-9.0.0: For MySQL database connection.
rs2xml: For result set transformations.

**Getting Started**
Prerequisites
Java Development Kit (JDK) 8 or higher
NetBeans IDE
MySQL Server: For database setup and management.

**Installation**
Clone the Repository
git clone https://github.com/your-username/EasyBank-Financial-Management-System.git

Set Up Database
Import the provided SQL file into your MySQL database to set up tables and initial data.

Configure Database Connectivity
Update database connection settings in the JDBC configuration file to match your MySQL setup.

Install Required JAR Files
Add the necessary JAR files (itextpdf-5.5.13, javax.mail, mysql-connector-j-9.0.0, rs2xml) to the project libraries in NetBeans.

Run the Project
Open the project in NetBeans and run the Main class to start EasyBank.

**Usage**
Login: Use the multiuser login feature to sign in with your credentials.
Create Account: Select savings or current account options to open a new account.
Dashboard: Access your account details, transaction history, and application forms.
Fund Transfer/Bill Payment: Transfer funds or pay bills directly from your account.
Download Mini Statement: Download recent transaction history in PDF format.
Apply for Card/Loan: Use the application forms for debit/credit card or loan requests.

**Configuration**
Database Configuration: Update dbConfig.java with your MySQL database URL, username, and password.
Environment Variables:
DB_USERNAME: Set your MySQL username.
DB_PASSWORD: Set your MySQL password.

**Contact**
GitHub: **Nishhh3**
Email: **nishantwrkchauhan05@gmail.com**
