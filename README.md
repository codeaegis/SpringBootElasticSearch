# SpringBootElasticSearch
Elastic Search demo app

Before you run the app please modify property file \src\main\resources\application.properties
elasticsearch.host = localhost
elasticsearch.port = 9300

Above these value should point to elastic search Host address and elastic search tcp port.
The default port for elastic search to accept rest based requests is 9200 which is port where it accepts HTTP requests.

Application can be run by below maven commands
mvn spring-boot:run

To clean the project use maven command
mvn clean
