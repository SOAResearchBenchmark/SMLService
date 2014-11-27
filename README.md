SMLService
==========

Statistics and Machine Learning Web Service offers statistical and machine learning methods to analyze data.
The machine learning part uses the Weka java library (http://www.cs.waikato.ac.nz/ml/weka/) (Version 3.7)

Static WSDL file for each version can be found at (replace {i} with the version):
http://ssrg18.cs.ualberta.ca:8080/SMLService/files/wsdl/SMLService_v{i}.wsdl

WSDL for the current version can be found at:
http://ssrg18.cs.ualberta.ca:8080/SMLService/services/SMLService?wsdl

The service offers the following operations:

-------------
getFilesPath
-------------
Returns the path to the "files" folder on the server side. This path can be used to upload files to the server and qualify the input filename for the service operations.

input:
output: the path for the "files" folder on the server side. (string)

---------------------------
clusterDataWithSimpleKMeans
---------------------------
Uses Simple KMeans to cluster data.

input:  - number of output clusters (k). (int)
        - full path to the input file on the server side. (string) The operation accepts both CSV and ARFF files (for Weka). The filename should be qualified with the path to the "files" directory on the server side. The file should have been previously uploaded to the server.
output: - number of output clusters (k). (int)
        - final cluster assignments. (int[]) An array corresponding to the initial data containing the index of the cluster to which each instance was clustered.
        - status code. (int) 0 for success, -1 for error.
        - response message. (string)  
        
---------------------------
classifyDataWithJ48
---------------------------
Produces J48 decision tree to produce a classifier for the given data.

input:  - the index of the column which corresponds to the class. (int)
        - full path to the input file on the server side. (string) The operation accepts both CSV and ARFF files (for Weka). The filename should be qualified with the path to the "files" directory on the server side. The file should have been previously uploaded to the server. If CSV is provided, it has to be made sure that the first line of the file has the labels for the data.
output: - the output decision tree as a string. (string)
        - status code. (int) 0 for success, -1 for error.
        - response message. (string)         