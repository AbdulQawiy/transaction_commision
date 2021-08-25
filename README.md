# transaction_commision
Digital coillers interview


Using mysql database (xampp)
create a database with name transaction_test

mysql jdbc connector ardy added to project
refresh maven to be sure all dependencies are up to date
run the app
test via https://www.getpostman.com/collections/fed2331147a704d46d9f on postman

Notice: I am yet to get a response concerning the explanation
of the fee wages percentage, and I shall do the mongo db logs later today

still work in progress, I used lots more of java for comfort and speed
because this is running concurrently with an ongoing agile sprint at my place of work
I do not have the luxury of time to do better, but I ensured something is done...

I hope to continue tomorrow


I have now completed all cases:

mongodb details
spring.mongo.host=mongodb://localhost:27017/transactionTest
spring.mongo.databaseName=transactionTest

Please note that I interpreted the fee_wages table as

Total amounts for a commission request <= 1000 will have a commission of 3.5%
Total amounts for a commission request <= 2500 will have a commission of 2.5%
Total amounts for a commission request <= 5000 will have a commission of 1.1%
Total amounts for a commission request <= 10000 will have a commission of 0.1%

therefore, based on the data given, only customer with id = 3 returns a valid data 3.5 for the commission value

customer with id 1 will return 'Transaction value 24333 has no match in fee wages data given' as it is more than

10000 which is the highest represent for fee_wage percentage


Also, there are better tools to optimize the process in a real life scenario, but time is really against me considering other office task I do have

-- redis could have be used to cache data limit db calls.

-- queues could have been used to hold some db request data and only assign to db memory in FIFO manner.

-- Flyway could have been used to manage the data loading to db upon app start.

-- more of scripts could have been used, particularly for the commission calculation as scripts are known to be faster
as against several calls for data processing.

And more,these are the enhancements I would ensure is done in a real life scenario



