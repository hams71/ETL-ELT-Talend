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
- [Indexes and Statistics Collection](#indexes-and-statistics-collection)
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
  <img src="Images/Flow_1.jpg" width="850" >
</p>




---

### Architecture and Design

- Now on to the interesting part. Firstly we needed to create a **Landing Zone** where our data files will be placed. This process was automated and Talend will wait for the files to appear and then will start the next step. 
- In Talend we needed to provide our file schema in the metadata section so that it knows what will be the format of the different files.
- After the data has arrived we need to clear our **Staging Area** (truncate and load) and load this data into our Staging Area. The Staging Area is the first place where our data is loaded. Our data files will be loaded to different tables in our Staging Area.
- When the data is in our Staging Area it is not in its purest form, from here do some transformation and load this data to our **Help Tables** which will be used to generate the surrogate keys, these are the keys used internally by the warehouse.
- Will do a join and see based on our keys if the Staging data is present in the **Core/Dim** tables. If its not we will load this data to our **Load Ready** tables.
- The Load Ready tables are really interesting here we mark our rows that either they will be Inserted, Updated or Deleted (IUD). So this will have a column which will tell us what operation needs to be performed and hence the name IUD column.
- When we have this IUD marked data in our Load Ready tables, based on our marking we can load this data to our Core/Dim tables.
- In our Core tables we will be implementing SCDs, now that will be based on our use case that what sort of details we can to capture.
- In Core tables will do the indexing so that based on keys we can find data efficiently and similarly will collect statistics as well. Teradata also provides us with different join indexes which are really helpful in the Fact and Dim situation.

---

### Data Model


<p align="center">
  <img src="Images/PDM.PNG" width="850" >
</p>

- The source system provides the Full Dump (all of the data).
- No Delta data was provided meaning only the data that changed in the source system is provided to us.
- The Transactions table is append only data.
- Most the tables were SCD Type 1 or Type 2.
- Country and City do not change much they can be loaded manually whenever needed.

---

### SMX Document

<p align="center">
  <img src="Images/Mapping.PNG" width="850" >
</p>

- An excel sheet was also created which explains what operation performed.
- Each of the table will have a detailed sheet which tells what tranformations happened, at what layer(Staging, Load Ready, Core/Dim).
- This is really helpful for other team member so see and interpret what happened.


---


### ETL Jobs

- The first time the user will place the files in the Landing area and Talend will start the job.
- It will truncate all the data if any in the Staging Tables (Contact, Account, Transaction etc) and will load this new data into the respective tables.
- After this we will populate our Help Tables with the Surogate keys and will be used in the next layers.
- Using the Help Tables and Staging we will check this with Core/Dim that what data is new, or updated, or has been deleted and will load and mark this new data in our Load Ready Tables.
- Once the data is in the Load Ready, based on the IUD column marking we will load this data into our Core tables.
- The Core tables will have the SCDs implemented and based on that either the rows will be updated or new row will be inserted.
- Statistics will collected on these tables and indexed will be created so that data can be used efficiently by end user.
- The data file in our Landing area will be archived.
- Next day again new data arrives and this cycle will start again.


---

### Indexes and Statistics Collection

- Teradata provides many types of indexed
  - Unique Primary Index (UPI)
  - NON Unique Primary Index (NUPI)
  - Secondary Index (SI)
  - Non Unique Secondary Index (NUSI)

- Teradata also provides Join Indexes the result of these are stored and if any changes will be reflected in these join indexed as well
  - Single Table Join Index
  - Multiple Table Join Index
  - Aggregated Join Index

- After the data is loaded in the Core/Dim Tables we collect Statistics as well on different columns and the optimizer creates an execution strategy that is based on these statistics.


---
### Tools and Technologies

- Teradata 16.20
- Talend
- Java
- SqlDBM
- Excel
