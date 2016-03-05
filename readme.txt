1. Сброс пароля для db.postgres:
	
	sudo -u db.postgres psql
	\password
	\q

2. Создание роли:
	
	sudo -u db.postgres psql
	CREATE USER sysdba WITH PASSWORD 'masterkey';
	\q

	// GRANT ALL PRIVILEGES ON DATABASE "test_database" to tester;

3. Создание базы данных:

	sudo -u db.postgres psql
	CREATE DATABASE updates_registry WITH OWNER sysdba ENCODING 'UTF8';
	\q

4.