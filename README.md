# 🚀 Demoblaze - Automation Testing Project  

## 📌 Project Title  
**Demoblaze Automation Testing (Selenium + Postman API Tests)**  

---

## 🏆 Introduction  
[Demoblaze](https://www.demoblaze.com/) is a sample e-commerce application that allows users to explore, add, and purchase electronic products online.  

This project automates **UI and API testing** for Demoblaze:  
- 🖥️ **Automation (Selenium + Java + TestNG + POM)**  
- 🌐 **API Testing (Postman Collection)**  

The goal is to validate **end-to-end workflows** (from automation testing to APIs) ensuring functionality, usability, and reliability.  

---

## ✨ Key Features Automated  

### 🔹 Automation (Selenium + TestNG + POM)  
- 🔐 **User Authentication** – Signup, Login  
- 🛒 **Shopping Flow** – Browse products, Add to cart, Place order  
- 💳 **Checkout Process** – Enter details, Confirm purchase  
- 🧾 **Order Validation** – Verify successful order placement  
 

### 🔹 API Testing (Postman)  
- 📦 **Product APIs** – Validate product list retrieval  
- 👤 **User APIs** – Verify signup/login API flows  
- 🛍️ **Cart APIs** – Add, retrieve, and delete items from cart  
- 💰 **Order APIs** – Place and validate orders  
- ✅ **Response Validations** – Status codes, JSON schema, response times  

---

## 🔬 Project Type  
This project is a **Hybrid Automation Framework** that includes:  
- ✅ **Automation Testing** using Selenium + TestNG  
- ✅ **API Testing** using Postman collections  
- ✅ **Page Object Model (POM)** for reusability and maintainability  
- ✅ **Extent Reports** for detailed execution reports  

---

### 📂 Project Structure  
```bash
Demoblaze-Automation/
├── pom.xml
├── testng.xml
├── reports/                      
│   └── ExtentReport.html
│
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── pages/
│   │       │   ├── CartPage.java
│   │       │   ├── CheckoutPage.java
│   │       │   ├── HomePage.java
│   │       │   ├── LoginPage.java
│   │       │   └── SignUpPage.java
│   │       │
│   │       ├── tests/
│   │       │   ├── AddToCartTest.java
│   │       │   ├── BaseTest.java
│   │       │   ├── CheckoutTest.java
│   │       │   ├── LoginTest.java
│   │       │   └── SignUpTest.java
│   │       │
│   │       └── utilities/
│   │           ├── DriverManager.java
│   │           ├── ExtentLogger.java
│   │           ├── ExtentTestManager.java
│   │           ├── ScreenshotUtil.java
│   │           └── TestListener.java
│   │
│   └── test/
│       └── java/                  # (reserved for Cucumber BDD stepdefs/features if added)
│
├── src/test/resources/            # Config files, test data
│
├── Postman_API_Tests/             # API testing with Postman
│   └── Demoblaze APIs.postman_collection.json
│
├── test-output/                   # TestNG reports auto-generated
│
└── README.md                      # Project documentation

```
---

## 🛠️ Technology Stack  

**Languages & Tools:**  
- ☕ **Java** – Core programming language  
- 🖥️ **Selenium WebDriver** – Test automation framework  
- 🧪 **TestNG** – Test execution & reporting  
- 🗂️ **Page Object Model (POM)** – Framework design pattern  
- 📊 **Extent Reports** – Rich HTML reports  
- 🌐 **Postman** – API testing & validation  
- 📝 **Git & GitHub** – Version control and hosting  

---

## 📊 Test Reports

-📑 Extent Reports – Interactive and detailed execution reports with screenshots
-✅ API Reports – Available in Postman 


## 🎯 Conclusion

- The Demoblaze Automation Testing Project ensures end-to-end testing of an e-commerce workflow.
- By combining Selenium (UI automation) with Postman (API testing), the framework validates both frontend and backend layers.

This project demonstrates strong SDET skills in UI + API automation, framework design, and reporting. ✅🚀


















