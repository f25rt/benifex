# benifex
Technical exam

This project runs on springboot and H2 Database

JSON file is provided for the POST addEmployee, GET employeeDetail and GET allEmployees

The validation to check unique emails will be triggered when trying to insert new employee that has same email with the existing, it will throw custom exception.
The employeeNumber is currently generated using only the last entry id and it will keep on incrementing.
