# finkar
Разработана программа: финансовый калькулятор.

Приложение работает в консоли.
Для того чтобы запустить приложение из консоли введите следующую комнаду:
1)java -Dlog4j.configurationFile="..\..\..\resources\log2j2-test.xml" -classpath ..\..;..\..\..\resources\log4j\log4j-api\2.12.0\log4j-api-2.12.0.jar;..\..\..\resources\log4j\log4j-core\2.12.0\log4j-core-2.12.0.jar com.company.Main 
Данная команда запускает программу с интерфейсом.
2)java -Dlog4j.configurationFile="..\..\..\resources\log2j2-test.xml" -classpath ..\..;..\..\..\resources\log4j\log4j-api\2.12.0\log4j-api-2.12.0.jar;..\..\..\resources\log4j\log4j-core\2.12.0\log4j-core-2.12.0.jar com.company.Main [Аргумент1] [Аргумент2] [Аргумент3]
Данная команда позволяет запустить приложение из консоли.
Доступные валюты:
1)RUB (рубль);
2)USD (доллар);
3)EUR (евро);
4)VND (донг);
5)JPY (иена);
Курсы валюты загружаются из файла.

В приложении есть валидация данных пользователя программы.

Для логгирования используется библиотека log4j.
