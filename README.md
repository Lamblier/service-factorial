Приложение высчитывает факториал натурального числа, но не больше 39.
При вводе числа < 0 или > 39 выдаст ошибку.

Сбор метрик:
- Prometheus http://localhost:8080/actuator/prometheus
- Grafana http://localhost:3000/login	admin:admin

В Grafana встроены dashbords:
- первый с JVM'мом
- второй с процессом выполнения

Для запуска приложения, проект нужно склонировать.

Скрипты находятся в папке scripts, docker команды нужно запускать из каталога scripts

Для сборки образов в докер команда - docker-compose up --build    

Тестовое задание
Разработать микросервис, который удовлетворяет следующим условиям:
1) Принимает на вход по HTTP json:
  {“factorial_num” :  5}

2) Вычисляет факториал числа, полученного в body

3) Возвращает рассчитанное значение в json формате:
 {“result” : 120 }

4) Обработка технических и бизнес-ошибок (например, чтобы пользователь на отправлял запросы на расчет факториала чисел более 100 и т.п.) должна присутствовать.

5) Сервис должен предоставлять технические метрики в формете Prometheus и health по HTTP. Можно придумать свои бизнес метрики (например, время расчета факториала). 

6) Сборщик проекта: maven или gradle

7) Также необходимо подключить к проекту систему контроля версий Git.

8) Предусмотреть упаковку сборки в Docker.

9) Написать unit и интеграционные тесты. 
