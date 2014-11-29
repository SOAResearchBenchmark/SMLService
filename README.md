SMLService
==========

Statistics and Machine Learning Web Service offers statistical and machine learning methods to analyze data.
The machine learning part uses the Weka java library (http://www.cs.waikato.ac.nz/ml/weka/) (Version 3.7)

Static WSDL file for each version can be found at (replace {i} with the version):
http://ssrg18.cs.ualberta.ca:8080/SMLService/files/wsdl/SMLService_v{i}.wsdl

Available versions:

-v1
-v1.1

WSDL for the current version can be found at:
http://ssrg18.cs.ualberta.ca:8080/SMLService/services/SMLService?wsdl

The current version of the service offers the following operations:

---------------------------
clusterDataWithSimpleKMeans
---------------------------
Uses Simple KMeans to cluster data.

input:  - number of output clusters (k). (int)
        - source data. (string) Input data for the clusterer as one single string.
        - the type of the file that the input data will be saved in. (string) The operation accepts two types of files compatible with Weka: "csv" and "arff".
output: - number of output clusters (k). (int)
        - final cluster assignments. (int[]) An array corresponding to the initial data containing the index of the cluster to which each instance was clustered.
        - status code. (int) 0 for success, -1 for error.
        - response message. (string)  
        
---------------------------
classifyDataWithJ48
---------------------------
Produces J48 decision tree to produce a classifier for the given data.

input:  - the index of the column which corresponds to the class. (int)
        - source data. (string) Input data for the clusterer as one single string.
        - the type of the file that the input data will be saved in. (string) The operation accepts two types of files compatible with Weka: "csv" and "arff".
output: - the output decision tree as a string. (string)
        - status code. (int) 0 for success, -1 for error.
        - response message. (string)         