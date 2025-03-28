# Spring Cloud Microservices🚀

This tutorial will teach you how to implement the **Spring Cloud Framework** and its architecture.

## Architecture Overview

### 🔹 Gateway
Acts as the entry point for external requests. It routes incoming traffic to the appropriate microservice.

### 🔹 Eureka (Service Discovery)
Registers each microservice using its **IP address** and **port**, based on the name specified in the `yml` configuration file.

### 🔹 Config Server
Manages and stores the configuration of each microservice, ensuring consistency across the system.

## Microservices

### 📌 Microservice: Course
Handles operations related to **courses** and **teachers**.

### 📌 Microservice: Student
Manages **students** and their associated courses.

---

 
