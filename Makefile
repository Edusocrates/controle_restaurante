build:
	mvn compile

unit-test:
	mvn test

integration-test:
	mvn test -P integration-test

system-test:
	mvn test -P system-test

test:
	unit-test integration-test system-test

start-app:
	docker compose up --build

stop-app:
	docker compose down --rmi all --volumes

performance-test:
	mvn gatling:test -P performance-test