# **EasyBank: Financial Management System**

EasyBank is a desktop banking application developed in Java, integrating a SQL database to provide users with a streamlined platform for managing financial transactions. It offers essential banking functionalities such as account creation, fund transfers, bill payments, and downloadable mini-statements in PDF format.

## **Table of Contents**
1. Overview
2. Features
3. Technology Stack
4. Getting Started
5. Usage
6. Configuration
7. Contact

## **1. Overview**

EasyBank is designed to be an accessible and user-friendly financial management system, catering to individuals or small businesses needing basic banking operations. It is developed using Java (Swing) for the front-end and MySQL for the back-end, offering functionalities such as account management, transaction history tracking, and the ability to download transaction summaries in PDF format.

### **Key Highlights:**
- **Intuitive Interface**: Built using Java (Swing), providing a seamless user experience.
- **SQL Database Integration**: Powered by MySQL for secure data handling.
- **Auto-Generated Account Numbers**: Simplifies the onboarding process for new users.
- **Profile Customization**: Users can change their login password directly from the dashboard.

## **2. Features**

- **Create Savings/Current Account**: Users can open savings or current accounts as per their requirements.
- **Multiuser Login**: Supports multiple user profiles with personalized dashboards.
- **Profile Dashboard**: Displays user-specific account details and actions.
- **Fund Transfer and Bill Payments**: Users can easily transfer funds and pay bills through the application.
- **Change Password**: Users can update their login credentials securely.
- **Download Mini Statement**: Transaction history is available for download in PDF format.
- **Application Forms**: Users can apply for debit/credit cards or loans directly from their profile.

## **3. Technology Stack**

- **Frontend**: Java (Swing)
- **Backend**: MySQL
- **Database Connectivity**: JDBC (Java Database Connectivity)
- **IDE**: NetBeans
- **JAR Files**:
  - `itextpdf-5.5.13`: For generating PDF statements.
  - `javax.mail`: For email functionalities (if needed).
  - `mysql-connector-j-9.0.0`: For connecting to MySQL database.
  - `rs2xml`: For handling result set transformations.


## **4. Getting Started**

### **Prerequisites**
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE
- MySQL Server for database setup and management

### **Installation Steps**

1. **Clone the Repository**  
   ```
   git clone https://github.com/your-username/EasyBank-Financial-Management-System.git
   ```

2. **Set Up Database**  
   Import the provided SQL file into your MySQL server to set up the required tables and initial data.

3. **Configure Database Connectivity**  
   Update the database connection settings in the JDBC configuration file to match your MySQL server details.

4. **Install Required JAR Files**  
   Add the necessary JAR files (itextpdf-5.5.13, javax.mail, mysql-connector-j-9.0.0, rs2xml) to your project libraries in NetBeans.

5. **Run the Project**  
   Open the project in NetBeans, and run the `Main` class to start EasyBank.


## **5. Usage**

- **Login**: Use the multiuser login feature to sign in with your credentials.
- **Create Account**: Choose between savings or current accounts to create a new account.
- **Dashboard**: View your account details, check transaction history, and access application forms.
- **Fund Transfer/Bill Payment**: Transfer funds or pay bills directly from your account.
- **Download Mini Statement**: Generate and download your recent transaction history as a PDF.
- **Apply for Card/Loan**: Submit application forms for debit/credit cards or loans through the platform.


## **6. Configuration**

### **Database Configuration**
Update the `dbConfig.java` file with your MySQL database details:
- **DB_USERNAME**: Your MySQL username
- **DB_PASSWORD**: Your MySQL password

Ensure these values are correctly set for a seamless database connection.


## **7. Contact**

- **GitHub**: [Nishhh3](https://github.com/your-username)
- **Email**: [nishantwrkchauhan05@gmail.com](mailto:nishantwrkchauhan05@gmail.com)
