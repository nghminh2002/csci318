# CSCI318 Group Assignment
University of Wollongong
Campus Liverpool - South Western Sydney
CSCI318 - Software Engineering Practices & Principles

### Demonstration: Sample REST Requests
1. Create customer
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

2. Update customer name, address, country
```shell
curl --location --request PUT 'http://localhost:8080/customer/1' \
--header 'Content-Type: application/json' \
--data '{
    "companyName": "Company 123",
    "address": "123 AB Street",
    "country": "NZ"
}'
```
which returns
```json
{"id":1,"companyName":"Company 123","address":"123 AB Street", "country":"NZ","contact":null}
```

3. Create contact
```shell
curl --location 'http://localhost:8080/customer/contact' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Hue Minh Nguyen",
    "phone": "0123456789",
    "email": "hmn998@gmail.com",
    "position": "Software developer"
}'
```
which returns
```json
{"id":2,"name":"Hue Minh Nguyen","phone":"0123456789", "email": "hmn998@gmail.com","position":"Software developer"}
```

4. Map customer to contact
```shell
curl --location --request PUT 'http://localhost:8080/customer/1/contact/2'
```
which returns
```json
{"id":1,"companyName":"Company 123","address":"123 AB Street", "country":"NZ","contact":{"id":2,"name":"Hue Minh Nguyen","phone" :"0123456789","email":"hmn998@gmail.com","position":"Software developer"}}
```

5. Update contact for customer by id
```shell
curl --location --request PUT 'http://localhost:8080/customer/contact/2' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Minh Hue Nguyen",
    "phone": "0987654321",
    "email": "hmn998@uow.edu.au",
    "position": "Software engineer"
}'
```
which returns
```json
{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email": "hmn998@uow.edu.au","position":"Software engineer"}
```

6. Get customer by Id
```shell
curl --location 'http://localhost:8080/customer/1'
```
which returns
```json
{"id":1,"companyName":"Company 123","address":"123 AB Street","country":"NZ","contact":{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email":"hmn998@uow.edu.au","position":"Software engineer"}}
```

7. Get all customers
```shell
curl --location 'http://localhost:8080/customer'
```
which returns
```json
[{"id":1,"companyName":"Company 123","address":"123 AB Street","country":"NZ","contact":{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email":"hmn998@uow.edu.au","position":"Software engineer"}}]
```

8. Get contact by Id
```shell
curl --location 'http://localhost:8080/customer/contact/2'
```
which returns
```json
{"id":2,"name":"Minh Hue Nguyen","phone":"0987654321","email": "hmn998@uow.edu.au","position":"Software engineer"}
```

9. Get all contacts
```shell
curl --location 'http://localhost:8080/customer/contact'
```
which returns
```json
[{"id":2,"name":"Hue Minh Nguyen","phone":"0123456789","email":"hmn998@uow.edu.au","position":"Software engineer"}]
```

10. Create product
```shell
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--data '{
    "productCategory": "Food",
    "name": "Chicken",
    "price": 15.20
}'
```
which returns
```json
{"id":3,"productCategory":"Food","name":"Chicken","price":15.2,"productDetail":null}
```

11. Update product category, name and price
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

12. Create product detail
```shell
curl --location 'http://localhost:8080/product/detail' \
--header 'Content-Type: application/json' \
--data '{
    "description": "Description ABC",
    "comment": "OKAY"
}'
```
which returns
```json
{"id":4,"description":"Description ABC","comment":"OKAY"}
```

13. Map product detail to product
```shell
curl --location --request PUT 'http://localhost:8080/product/3/detail/4'
```
which returns
```json
{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":{"id":4,"description":"Description ABC","comment":"OKAY"}}
```

14. Update product detail by Id
```shell
curl --location --request PUT 'http://localhost:8080/product/detail/4' \
--header 'Content-Type: application/json' \
--data '{
    "description": "Description CDE",
    "comment": "GOOD"
}'
```
which returns
```json
{"id":4,"description":"Description CDE","comment":"GOOD"}
```

15. Get product by Id
```shell
curl --location 'http://localhost:8080/product/3'
```
which returns
```json
{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":{"id":4,"description":"Description CDE","comment": "GOOD"}}
```

16. Get all products
```shell
curl --location 'http://localhost:8080/product'
```
which returns
```json
[{"id":3,"productCategory":"Vegetable","name":"Carrot","price":5.0,"productDetail":{"id":4,"description":"Description CDE","comment":"GOOD"}}]
```

17. Get product detail by Id
```shell
curl --location 'http://localhost:8080/product/detail/4'
```
which returns
```json
{"id":4,"description":"Description CDE","comment":"GOOD"}
```

18. Get all product details
```shell
curl --location 'http://localhost:8080/product/detail'
```
which returns
```json
[{"id":4,"description":"Description CDE","comment":"GOOD"}]
```

19. Create order
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

20. Update order
```shell
curl --location --request PUT 'http://localhost:8080/order/5' \
--header 'Content-Type: application/json' \
--data '{
    "supplier": "Company 123",
    "product": "Tech",
    "quantity": 2
}'
```
which returns
```json
{"id":5,"supplier":"Company 123","product":"Tech","quantity":2}
```