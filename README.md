# CreditCardApplication Processor

We have implemented the Two REST Endpoints as per the below requirement

•	"Add" will create a new credit card for a given name, card number, and limit

o	Card numbers should be validated using Luhn 10

o	New cards start with a £0 balance

o	for cards not compatible with Luhn 10, return an error

•	"Get all" returns all cards in the system

#Technology used

o	Spring Boot with Maven

o Swagger to test and present the end points.

o Used the Mockito and spy to test application.
