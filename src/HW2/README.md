/**

Доделать запускатель тестов:
1. Создать аннотации BeforeEach, BeforeAll, AfterEach, AfterAll
2. Доработать класс TestRunner так, что
* 2.1 Перед всеми тестами запускаеются методы, над которыми стоит BeforeAll
* 2.2 Перед каждым тестом запускаются методы, над которыми стоит BeforeEach
* 2.3 Запускаются все тест-методы (это уже реализовано)
* 2.4 После каждого теста запускаются методы, над которыми стоит AfterEach
* 2.5 После всех тестов запускаются методы, над которыми стоит AfterAll

Другими словами, BeforeAll -> BeforeEach -> Test1 -> AfterEach -> BeforeEach -> Test2 -> AfterEach -> AfterAll


