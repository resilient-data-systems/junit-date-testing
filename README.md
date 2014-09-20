Unit testing and Date equality
===================================


This project has been created as part of a post: [Unit testing and Date equality]

It demonstrates how new Date() may cause your tests to fail assertions.

**To demonstrate failure**
- Edit constructor of Event and make this.createdOn to be created with new Date() and comment out DateTime.now().toDate();
- Run EventServiceTest - if should fail, if not, re-run few times. 
- In Failure Trace you will notice that createdOn of expected object is different than actual by few milliseconds. That's because expected and actual were created separatelly and it's due to timing issue.
- If you edit constructor of Event and this.createdOn to be created with DateTime.now().toDate() you will see the tests passing as time is being fixed in setUp() method

Take a look at http://www.resilientdatasystems.co.uk/java/unit-testing-date-equality/


[Unit testing and Date equality]:http://www.resilientdatasystems.co.uk/java/unit-testing-date-equality/