mvn -B -s settings.xml -DskipTests=true clean install
java -Dspring.profiles.active="heroku" -DDATABASE_URL="postgres://sysdba:masterkey@localhost:5432/updates_registry" -jar target/dependency/webapp-runner.jar target/*.war
