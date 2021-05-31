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
2. Run following commands in console 
mvn clean install
mvn test OR mvn -Dtest=AllUnitTests test
3. From Eclipse : Either Run Starte.java /AllUnitTests as a Java Application

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
2.Take the path to logfile.txt as an input argument
3.Parse the contents of logfile.txt
4.Flag any long events that take longer than 4ms
5.Write the found event details to file-based HSQLDB (http://hsqldb.org/) in the working folder
6.The application should create a new table if necessary and store the following values:
7.Event id
8.Event duration
9.Type and Host if applicable
10.Alert (true if the event took longer than 4ms, otherwise false)

In the example above, the event scsmbstgrb duration is 1401377495216 - 1491377495213 = 3ms
The longest event is scsmbstgrc (1491377495218 - 1491377495210 = 8ms)

