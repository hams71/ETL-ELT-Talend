# ETL-ELT-Talend

---

### Table of Contents

- [Overview](#overview)
- [Talend Open Studio](#talend-open-studio)
- [Program Flow](#program-flow)
- [Architecture and Design](#architecture-and-design)
- [Data Model](#data-model)
- [SMX Document](#smx-document)
- [ETL Jobs](#etl-jobs)
- [Indexes](#indexed)
- [Statistics Collection](#statistics-collection)
- [Tools and Technologies](#tools-and-technologies)

---


### Overview

- This was project to show how talend can be used to load to teradata and how teradata warehouse can use different indexes, stattistics collection to provide value to end user in an efficient manner.
- Talend was used as the tool of choice to perform this task. It can be downloaded easily. 
- Needed to design a data model for the banking industry.
- Needed to create an ETL pipeline using Talend so that the task can be automated and data can be loaded with minimum manual effort.

---

### Talend Open Studio

- Download the free version of Talend.
- Installed Teradata required jars so that Talend can connect to Teradata.
- Talend has a great UI, pre build components that can be used for different use cases.
- Talend being a java based tool you will need to have all the java requirements checked like jvm, jdk.
- While running jobs it also provides real time statistics which is really helpful.

---

### Program Flow

<p align="center">
  <img src="Images/Flow_3.jpg" width="850" >
</p>



---

### Architecture and Design

- Now on to the interesting part. Firstly we need to create a Landing Zone where our data files will be pushed. This process was automated and Talend will wait for the files to appear and then will start the next step.
- In Talend we needed to provide our file schema in the metadata section so that it knows what will be the format.
- After the data has arrived we need to clear our staging area (truncate and load) and load this data into our Staging Area.
- When the data in our staging area it is not in its purest form, from now we load this data to our help tables which will be used to generate the surogate keys, these are the keys used internally by the warehouse.
- Will do a join and see based on our keys if the staging data is present in the core layers. If its not we will load this data to our Load Ready Layer.
- The Load Ready layer is really interesting here we mark our rows that either they will be Inserted, Updated or Deleted (IUD). So this will have a column which will tell us what operation needs to be performed.
- When we have this IUD marked data in our Load Ready Layer, based on our marking we can load this data to our Core/Dim Layer.
- In our Core Layer we will be implementing SCDs, now that will be based on our use case that what sort of details we can to capture.
- Now in our core layer will be do the indexing so that based on keys we can find data efficiently and similarly will collect statistics as well. Teradata also provides us to have different join indexes which are really helpful in the Fact and Dim situation. 
