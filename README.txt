PL/EN

Java version: Java 1.8
IDE: Intelij IDEA

Instrukcja uruchamiania testów:
mvn surefire-report:report  	<- uruchamia wszystkie testy i generuje raport (target/site/surefire-report.html)

mvn -Dtest=TEST_NAME test	<- uruchamia wybrany zestaw testowy

mvn -Dtest=TestUsers_Test#testUserFunctionality test	<- uruchamia konkretny przypadek testowy dla danej klasy




Test running instructions:
mvn surefire-report:report  	<- runs all test cases and generates raport (target/site/surefire-report.html)

mvn -Dtest=TEST_NAME test	<- runs choosen test suite

mvn -Dtest=TestUsers_Test#testUserFunctionality test	<- run choosen test case for particullar class