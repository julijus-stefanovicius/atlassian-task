## Instructions
Download and install Atlassian SDK tools: *https://marketplace.atlassian.com/download/apps/1210950/version/42510*

Download and install JAVA 8 JDK: *https://download.oracle.com/otn/java/jdk/8u271-b09/61ae65e088624f5aaa0b1d2d801acb16/jdk-8u271-windows-x64.exe* (login needed)

Open command line in the project root folder and run the command: ```atlas-run```

Open browser and go to *http://localhost:2990/jira* and login with default credentials( Username: **admin**, password: **admin** )

Access the endpoint by going to *http://localhost:2990/jira/rest/itunesrest/1.0/artists?name={artistName}*, where {artistName} is any artist you want to search for.

You can also use Postman to do GET requests and see the JSON response.
