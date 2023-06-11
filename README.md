Money is solution where customer can login and check cumulative balance
and monthly balance. 

Another team is developing transactionAPI and in this solution mockAPI
is used to help developing solution before the real API is available.

It is heavy operation to fetch all transactions of customer every time and so it
is useful to start develop cache for the data that is really needed. In this situation
it is monthly balances and the cumulative amount. First, only in memory datastructure is used
but is should be changed to cache that uses disk also to keep this cache data safe between
server restarts. It is assumed that transaction history doesn't change and if this doesn't hold
it should be changed to according new specs. Example if there is rare situations when old transactions
are fixed and this should update cache also.

Auth0 service is used for login because it is well known and should be reliable when comparing
many other services. In future this could be changed to MFA and maybe using more reliable service
that fullfills finance industry requirements. This should be checked before going to production!

Solution is developed as testable as possible using functional and clear style avoiding inner state
and hard and complex class hierarchies and object graphs.

Solution is possible to wrap in docker and be uploaded to ECS or other container run environment.

To run app:

Copy from email message to file application.yml

client-id

client-secret

issuer-uri

Save file! :D

Run command gradlew.bat bootRun

Go to localhost:3000
