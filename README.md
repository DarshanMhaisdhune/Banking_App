# Banking Application  

## Overview  
This is a Spring Boot application for managing bank accounts. It provides RESTful APIs for common banking operations such as creating accounts, depositing money, withdrawing money, and checking account balances.  

Additionally, this application includes **AI-powered chat support** using the **Ollama Mistral model**, allowing users to interact with an AI chatbot for assistance.  

## Features  
✔️ Create new bank accounts  
✔️ Retrieve account information by ID  
✔️ Deposit money into accounts  
✔️ Withdraw money from accounts  
✔️ List all accounts  
✔️ Delete accounts  
✔️ **AI-powered chat support** via `/api/chat` endpoint  

## Technologies Used  
- Java  
- Spring Boot  
- Spring Data JPA  
- Lombok  
- H2 Database (or any preferred database)  
- Maven  
- **Ollama Mistral AI Model**  

## API Endpoints  

### **Banking Operations**  
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `POST` | `/api/accounts` | Create a new bank account |  
| `GET` | `/api/accounts/{id}` | Retrieve account details by ID |  
| `PUT` | `/api/accounts/{id}/deposit` | Deposit money into an account |  
| `PUT` | `/api/accounts/{id}/withdraw` | Withdraw money from an account |  
| `GET` | `/api/accounts` | List all accounts |  
| `DELETE` | `/api/accounts/{id}` | Delete an account |  

### **Chat Support API**  
| Method | Endpoint | Description |  
|--------|---------|-------------|  
| `POST` | `/api/chat` | Interact with the AI-powered chatbot |  
