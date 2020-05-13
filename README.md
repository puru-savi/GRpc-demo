# GRpc-demo
Demo of using GRPC with Spring boot

Steps to run the project.

1. Download the project and import it into your IDE elcipse, Intelij etc as maven project.
2. Run mvn clean install command from your terminal, it will create all the java stub class in your target folder.
3. Start the application as spring boot.
4. Download BloomRPC on your machine and import proto file of the project.
5. Test the APIs on bloomRPC and validate the data in H2 database.

Note: You can access H2 database on localhost:8080/h2/console
		DBUrl: jdbc:h2:mem:testdb
		Username: sa
		password: 

