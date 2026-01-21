# 📢 Notification Microservice

A **Java Spring Boot microservice** responsible for sending **notifications via Email and SMS**.  
This project demonstrates a clean and extensible notification service architecture, suitable for distributed systems and microservice-based applications.

It can be easily integrated with other services to handle user alerts, system notifications, and transactional messages.

---

## 🧠 Project Overview

The **Notification Microservice** centralizes all notification-related responsibilities, allowing other systems to trigger notifications without dealing directly with external providers such as email servers or SMS gateways.

### Supported notification channels:
- 📧 Email notifications
- 📱 SMS notifications (via Twilio)

---

## 🛠️ Tech Stack

| Category        | Technology        | Version |
|-----------------|------------------|---------|
| Language        | Java             | 17      |
| Framework       | Spring Boot      | 3.3.0   |
| Build Tool      | Maven            | 3.x     |
| SMS Provider    | Twilio SDK       | 10.2.1  |
| Email           | Spring Mail      | 3.3.0   |

---

## 📦 Main Dependencies

- **Spring Boot Web** – REST API exposure
- **Spring Boot Mail** – Email sending support
- **Twilio SDK** – SMS delivery
- **Resilience4j** – Rate limiting and fault tolerance
- **Lombok** – Boilerplate code reduction
- **Mockito & Spring Boot Test** – Unit and integration testing

---

## 🏗️ Architecture & Design

- RESTful API built with **Spring MVC**
- External notification providers abstracted for easy replacement
- **Resilience4j Rate Limiter** to protect external services
- Clean separation of concerns (controllers, services, providers)
- Ready to be integrated into a larger microservices ecosystem

---

## 🚀 Features

- Send **SMS notifications** using Twilio
- Send **Email notifications** via SMTP
- Rate limiting to avoid provider abuse
- Easily extensible to support:
  - Push notifications
  - WhatsApp messages
  - Event-based messaging (Kafka / RabbitMQ)

---

## ▶️ How to Run the Project

### Prerequisites
- Java 17+
- Maven
- Twilio account (for SMS)
- SMTP server credentials (for email)

### Steps

```bash
# Clone the repository
git clone https://github.com/your-username/notification-ms.git

# Navigate to the project
cd notification-ms

# Run the application
mvn spring-boot:run
