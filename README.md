# Patient Management – Microservices Project

This is a place where I implement stuff now and then to catch up with things ...

This repository contains a **Patient Management System** built using **Java Spring Boot microservices**, with support for **Authentication, Billing, Analytics, and API Gateway routing**. It is designed as a learning/demo project for building production-ready healthcare microservices.

---

## 🔧 Tech Stack

- **Backend:** Java 21, Spring Boot 3.x, Spring Data JPA, Spring Security
- **API:** REST, JSON,gRPC
- **Messaging (optional):** Apache Kafka
- **Database:** PostgreSQL (per service)
- **Infra / DevOps:** Docker, Docker Compose, LocalStack (AWS emulation), Maven
- **Security:** JWT, OAuth2 (Auth Service)
- **Monitoring (optional):** Actuator, Prometheus, Grafana
- **Testing:** Integration Testing(Junit)

---
## 🗂 Project Structure

```text
Patient-Mangement/
├── .idea/
├── analytics-service/   # for storing the proto file
├── api-gateway/         # API Gateway – single entry point routing to services
├── api-requests/        # Saved API request files (e.g., REST/gRPC examples, client calls)
├── auth-service/        # Authentication microservice (login, JWT, security)
├── billing-service/     # Billing microservice (bills, invoices, payments)
├── config/              # Settings for Kafka Docker
├── grpc-request/        
├── infrastructure/      # Infrastructure config (Docker, LocalStack, networks, etc.)
├── integration-test/    # Integration tests across multiple services
├── patient-service/     # Patient microservice (patient CRUD, core domain)
├── .DS_Store            
├── Dockerfile           # Root Dockerfile for building a container image
├── patient-mangement.iml
└── qodana.yaml          
