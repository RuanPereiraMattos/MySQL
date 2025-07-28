# MySQL Project to show how to connect to MySQL localhost and on the network
1. Project was created only with default configuration from IntelliJ IDE
2. pom.xml was edited to add mysql-connector-j dependency
3. Main.java was edited to have three constructors:
   1. Empty constructor: plug and play, url, username and passwords already set. Be careful, because the default constructor use "jdbc:mysql://localhost:3306" as url, "root" as username and password.
   2. Full constructor: you have to specify url, username and password.
   3. Partial constructor: you have to username and password.  Be careful, because the default constructor use "jdbc:mysql://localhost:3306" as url.
4. Was created getConnection in two versions:
   1. First with no parameters, so the first constructor calls it easily and return connection variable with no problems.
   2. Second constructor with all params, url, username and password, so the second and third constructor can call it with no problem, but be careful, because the thrird constructor calls getConnection passing the default url as parameter as well username and password but in this case, using user input username and password.
5. Was created "use" method so if the user calls the constructors that doesn't have url, the user can input manually url with database name together, but be careful because it can throw exception.