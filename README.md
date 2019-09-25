# HourseMinPath

Web-сервис для расчета минимального пути шахматного коня от его начального до конечного положения на шахматной доске, который будет принимать HTTP GET запросы на:

[http://localhost:8080/hourse/rest/count]()

а ответом будет JSON строка вида:
```json
{
  "count": "6",
  "_links": {
    "self": {
      "href": "http://localhost:8080/hourse/rest/count?width=8&height=8&start=A1&end=H8"
    }
  }
}
```
Вы можете модифицировать сообщение ответа, если добавить к строке запроса параметры width, height, start, end, которые задают ширину и высоту доски, начальное и конечное положение коня на шахматной доске соответственно.

По умолчанию значения параметров следующие: width=8, height=8, start=A1, end=H8

## Сборка и запуск приложения

Чтобы собрать приложение с помощью Maven и запустить, выполните в терминале:
```
mvn package && java -jar target/hourse-min-path-0.0.1-SNAPSHOT.jar
```
Для проверки работоспособности приложения введите в другом терминале:
```
$ curl http://localhost:8080/hourse/rest/count
{"count":"6","_links":{"self":{"href":"http://localhost:8080/hourse/rest/count?width=8&height=8&start=A1&end=H8"}}}
```
