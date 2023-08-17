# CSCI318 Group Assignment
University of Wollongong
Campus Liverpool - South Western Sydney
CSCI318 - Software Engineering Practices & Principles

### Demonstration: Sample REST Requests
1. Create Customer
   
In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"companyName\":\"Company A\", \"address\": \"123 A Street\", \"country\": \"Australia\" }" http://localhost:8080/customer
```

In MacOS,
```shell
curl --location 'http://localhost:8080/customer' \
--header 'Content-Type: application/json' \
--data '{
    "companyName": "Company A",
    "address": "123 A Street",
    "country": "Australia"
}'
```
which returns
```json
{"id":1,"companyName":"Company A","address":"123 A Street", "country":"Australia","contact":null}
```

2. Update Customer

In Windows CMD,
```shell
curl -X PUT -H "Content-Type:application/json" -d "{\"companyName\":\"Company 123\", \"address\": \"123 AB Street\", \"country\": \"New Zealand\" }" http://localhost:8080/customer/1
```

In MacOS,
```shell
curl --location --request PUT 'http://localhost:8080/customer/1' \
--header 'Content-Type: application/json' \
--data '{
    "companyName": "Company 123",
    "address": "123 AB Street",
    "country": "New Zealand"
}'
```
which returns
```json
{"id":1,"companyName":"Company 123","address":"123 AB Street", "country":"New Zealand","contact":null}
```

3.  Create Contact
   
In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"Hue Minh Nguyen\", \"phone\": \"0123456789\", \"email\": \"hmn998@gmail.com\", \"position\": \"Software Developer\" }" http://localhost:8080/customer/contact
```

In MacOS,
```shell
curl --location 'http://localhost:8080/customer/contact' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Hue Minh Nguyen",
    "phone": "0123456789",
    "email": "hmn998@gmail.com",
    "position": "Software Developer"
}'
```
which returns
```json
{"id":2,"name":"Hue Minh Nguyen","phone":"0123456789", "email": "hmn998@gmail.com","position":"Software Developer"}
```

4. Map Customer to Contact

In Windows CMD
```shell
curl -X PUT http://localhost:8080/customer/1/contact/2
```

In MacOS, 
```shell
curl --location --request PUT 'http://localhost:8080/customer/1/contact/2'
```
which returns
```json
{"id":1,"companyName":"Company 123","address":"123 AB Street", "country":"New Zealand","contact":{"id":2,"name":"Hue Minh Nguyen","phone" :"0123456789","email":"hmn998@gmail.com","position":"Software Developer"}}
```

5. Update Contact for Customer by ID

In Windows CMD,
```shell
curl -X PUT -H "Content-Type:application/json" -d "{\"name\":\"Minh Hue Nguyen\", \"phone\": \"0987654321\", \"email\": \"hmn998@uow.edu.au\", \"position\": \"Software Engineer\" }" http://localhost:8080/customer/contact/2
```

In MacOS,
```shell
curl --location --request PUT 'http://localhost:8080/customer/contact/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Minh Hue Nguyen",
    "phone": "0987654321",
    "email": "hmn998@uow.edu.au",
    "position": "Software Engineer"
}'
```
which returns
```json
{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email": "hmn998@uow.edu.au","position":"Software Engineer"}
```

6. Get Customer by ID
 
In Windows CMD,
```shell
curl -X GET http://localhost:8080/customer/1
```

In MacOS,
```shell
curl --location 'http://localhost:8080/customer/1'
```
which returns
```json
{"id":1,"companyName":"Company 123","address":"123 AB Street","country":"New Zealand","contact":{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email":"hmn998@uow.edu.au","position":"Software Engineer"}}
```

7. Get All Customers

In Windows CMD,
```shell
curl -X GET http://localhost:8080/customer
```

In MacOS,
```shell
curl --location 'http://localhost:8080/customer'
```
which returns
```json
[{"id":1,"companyName":"Company 123","address":"123 AB Street","country":"New Zealand","contact":{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email":"hmn998@uow.edu.au","position":"Software Engineer"}}]
```

8. Get Contact by ID

In Windows CMD,
```shell
curl -X GET http://localhost:8080/customer/contact/2
```

In MacOS,
```shell
curl --location 'http://localhost:8080/customer/contact/2'
```
which returns
```json
{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email": "hmn998@uow.edu.au","position":"Software Engineer"}
```

9. Get All Contacts

In Windows CMD,
```shell
curl -X GET http://localhost:8080/customer/contact
```

In MacOS,
```shell
curl --location 'http://localhost:8080/customer/contact'
```
which returns
```json
[{"id":2,"name":"Hue Minh Nguyen","phone":"0123456789","email":"hmn998@uow.edu.au","position":"Software Engineer"}]
```

10. Create Product

In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"productCategory\":\"Meat\", \"name\": \"Chicken\", \"price\": 15.20}" http://localhost:8080/product
```

In MacOS,
```shell
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
    "productCategory": "Meat",
    "name": "Chicken",
    "price": 15.20
}'
```
which returns
```json
{"id":3,"productCategory":"Meat","name":"Chicken","price":15.2,"productDetail":null}
```

11. Update Product Category, Name and Price

In Windows CMD,
```shell
curl -X PUT -H "Content-Type:application/json" -d "{\"productCategory\":\"Vegetable\", \"name\": \"Carrot\", \"price\": 5}" http://localhost:8080/product/3
```

In MacOS,
```shell
curl --location --request PUT 'http://localhost:8080/product/3' \
--header 'Content-Type: application/json' \
--data '{
    "productCategory": "Vegetable",
    "name": "Carrot",
    "price": 5
}'
```
which returns
```json
{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":null}
```

12. Create Product Detail

In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"description\":\"Orange Vegetable\", \"comment\": \"Grown Locally\"}" http://localhost:8080/product/detail
```

In MacOS,
```shell
curl --location 'http://localhost:8080/product/detail' \
--header 'Content-Type: application/json' \
--data '{
    "description": "Orange Vegetable",
    "comment": "Grown Locally"
}'
```
which returns
```json
{"id":4,"description":"Orange Vegetable","comment":"Grown Locally"}
```

13. Map Product Detail to Product

In Windows CMD
```shell
curl -X PUT http://localhost:8080/product/3/detail/4
```

In MacOS, 
```shell
curl --location --request PUT 'http://localhost:8080/product/3/detail/4'
```
which returns
```json
{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":{"id":4,"description":"Orange Vegetable","comment":"Grown Locally"}}
```

14. Update Product Detail by ID

In Windows CMD,
```shell
curl -X PUT -H "Content-Type:application/json" -d "{\"description\":\"Purple Vegetable\", \"comment\": \"Grown Overseas\"}" http://localhost:8080/product/detail/4
```

In MacOS, 
```shell
curl --location --request PUT 'http://localhost:8080/product/detail/4' \
--header 'Content-Type: application/json' \
--data '{
    "description": "Purple Vegetable",
    "comment": "Grown Overseas"
}'
```
which returns
```json
{"id":4,"description":"Purple Vegetable","comment":"Grown Overseas"}
```

15. Get Product by ID

In Windows CMD,
```shell
curl -X GET http://localhost:8080/product/3
```

In MacOS,
```shell
curl --location 'http://localhost:8080/product/3'
```
which returns
```json
{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":{"id":4,"description":"Purple Vegetable","comment": "Grown Overseas"}}
```

16. Get All Products

In Windows CMD,
```shell
curl -X GET http://localhost:8080/product
```

In MacOS,
```shell
curl --location 'http://localhost:8080/product'
```
which returns
```json
[{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":{"id":4,"description":"Purple Vegetable","comment":"Grown Overseas"}}]
```

17. Get Product Detail by ID
 
In Windows CMD,
```shell
curl -X GET http://localhost:8080/product/detail/4
```

In MacOS,
```shell
curl --location 'http://localhost:8080/product/detail/4'
```
which returns
```json
{"id":4,"description":"Purple Vegetable","comment":"Grown Overseas"}
```

18. Get All Product Details
     
In Windows CMD,
```shell
curl -X GET http://localhost:8080/product/detail/
```

In MacOS,
```shell
curl --location 'http://localhost:8080/product/detail'
```
which returns
```json
{"id":4,"description":"Purple Vegetable","comment":"Grown Overseas"}
```

19. Create Order

In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"supplier\":\"Company A\", \"product\": \"Chicken\", \"quantity\": 5}" http://localhost:8080/order
```

In MacOS,
```shell
curl --location 'http://localhost:8080/order' \
--header 'Content-Type: application/json' \
--data '{
    "supplier": "Company A",
    "product": "Chicken",
    "quantity": 5
}'
```
which returns
```json
{"id":5,"supplier":"Company A","product":"Chicken","quantity":5}
```

20. Update Order

In Windows CMD,
```shell
curl -X PUT -H "Content-Type:application/json" -d "{\"supplier\":\"Company 123\", \"product\": \"Carrot\", \"quantity\": 2}" http://localhost:8080/order/5
```

In MacOS,
```shell
curl --location --request PUT 'http://localhost:8080/order/5' \
--header 'Content-Type: application/json' \
--data '{
    "supplier": "Company 123",
    "product": "Carrot",
    "quantity": 2
}'
```
which returns
```json
{"id":5,"supplier":"Company 123","product":"Carrot","quantity":2}
```
