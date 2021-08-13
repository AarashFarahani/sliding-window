# Sliding window average

Implement a data structure which:
* Accepts an endless series of data records (value + timestamp). It is guaranteed that timestamp of each received record will be greater or equal to timestamp of the previous record. Datatype of the values is your choice.
* On each record it returns a value average over a sliding time window. The sliding window ends at the timestamp of the last record and its beginning is at lastTimestamp – windowLength, where windowLength is provided as a parameter on the object creaton

#### Expectations:
* Performance and memory usage. 
* Thread safety. 
* Well-structured and documented code. 
* Reasonable unit tests.
* Build script.

#### Assumption: 
Unit of the window length is Second. Which means when you are entering 10 as window length it will be 10 second.

#### Requirements:
* Java 8
* Maven 3.0.0
* Windows 10 (for build the project or run the project)

### Building process:
For building the project just execute the build.bat in root of the project. The jar file will be generating in ./target path. Also, you can build the project with maven:

```
mvn clean package
```

### Run the project
For run the project just execute the run.bat in the root of the project. Also, you can build the project with maven:

```
java -cp ./target/app.jar com.mastercard.App
```

