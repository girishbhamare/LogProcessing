**Summary**:
Log Processing with Java 8 and  HSQL 

Requirements
------------
1.Java 8 <br />
2.Open-Source Library: Junit,Jackson,slf4j <br />
3.Maven (For Building and Execution)

Execution Process:
-----------
1. Clone this project : git@github.com:girishbhamare/LogProcessing.git or https://github.com/girishbhamare/LogProcessing.git
2. Run following commands in console <br />
mvn clean install<br />
mvn test OR mvn -Dtest=AllUnitTests test <br />
3. From Eclipse : Either Run **Starter.java (com.demo) as a Java Application  OR AllUnitTests (com.demo.unittest) as Junit** 

Testing Instructions
--------------------

The program should:
1. Take the input file path as input argument. Use following example as logfile.txt
. Example:
```
{"id":"scsmbstgra", "state":"STARTED", "type":"APPLICATION_LOG",
"host":"12345", "timestamp":1491377495212}
{"id":"scsmbstgrb", "state":"STARTED", "timestamp":1491377495213}
{"id":"scsmbstgrc", "state":"FINISHED", "timestamp":1491377495218}
{"id":"scsmbstgra", "state":"FINISHED", "type":"APPLICATION_LOG",
"host":"12345", "timestamp":1491377495217}
{"id":"scsmbstgrc", "state":"STARTED", "timestamp":1491377495210}
{"id":"scsmbstgrb", "state":"FINISHED", "timestamp":1491377495216}
```
2.Take the path to logfile.txt as an input argument<br />
3.Parse the contents of logfile.txt <br />
4.Flag any long events that take longer than 4ms <br />
5.Write the found event details to file-based HSQLDB (http://hsqldb.org/) in the working folder <br />
6.The application should create a new table if necessary and store the following values: <br />
7.Event id <br />
8.Event duration <br />
9.Type and Host if applicable <br />
10.Alert (true if the event took longer than 4ms, otherwise false) <br />

In the example above, the event scsmbstgrb duration is 1401377495216 - 1491377495213 = 3ms
The longest event is scsmbstgrc (1491377495218 - 1491377495210 = 8ms)

