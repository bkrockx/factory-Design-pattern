# Implementation-of-factory-design-pattern-
Implementation of factory design pattern for operation on multiple databases.

-> The factory(ConnectionFactory) will return instances of different classes based on the information passed in the parameter.

-> Then we can operate upon different databases by taking instances from the factory.

->MyConnection.java is the interface. While Database1.java and Database2.java are the classes implementing the inteface and thereby overriding the functions.

->Database1 operate on database "world" while Database2 operate on database "test"
