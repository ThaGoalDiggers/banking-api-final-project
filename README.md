# banking-api-final-project
This a banking app.

You can add, edit, retrieve, and delete customers.

POST and GET ALL customers at localhost:8080/customers

UPDATE, GET ONE, and DELETE customer(s) at localhost:8080/customers/{id}

You can also GET ONE customer using an account id at localhost:8080/accounts/{accountId}/customer

You can add, edit, retrieve, and delete accounts for a customer.

POST and GET ALL (per customer) accounts at localhost:8080/customers/{customerId}/accounts

UPDATE, GET ONE, and DELETE accounts at localhost:8080/accounts/{id}

GET ALL accounts at localhost:8080/accounts

You can add, edit, and retrieve bills for an account.

POST and GET ALL (per account) bills at localhost:8080/accounts/{accountId}/bills

UPDATE, GET ONE, and DELETE bills at localhost:8080/bills/{id}

GET ALL (per customer) bills at localhost:8080/customers/{customerId}/bills

You can make withdrawals and deposits to/from accounts.

POST and GET withdrawals and deposits at localhost:8080/account/{id}/{withdrawals or deposits}