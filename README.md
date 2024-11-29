# Flatter
## _**Лекция 1**_
1. Установка Flutter, распоковываем в в {имя_пользователя}/dev/<br>
2. Установка значения Path<br>
![image](https://github.com/user-attachments/assets/f7ae914a-9704-4372-bfa0-a35cb89bb116)<br>
3. Проверяем Flutter doctor<br>
![image](https://github.com/user-attachments/assets/6e43d066-10da-4202-b756-14f0e0af14eb)<br>
4. Скачиваем Android Studio<br>
![image](https://github.com/user-attachments/assets/db6075b5-8fd3-4d7f-a8ac-2f54bc5502ba)<br>
5. Выбираем расположение<br>
![image](https://github.com/user-attachments/assets/7fea0b36-ffb9-4875-b526-0bf4ee284605)<br>
6. Скачивание<br>
![image](https://github.com/user-attachments/assets/c9f98930-8db1-452c-9374-c5a0945d2c29)<br>
7. Настройка Android Studio<br>
![image](https://github.com/user-attachments/assets/7f44a843-d87a-400e-82d4-08b6c360552d)<br>
8. Установка и настройка VS Code<br>
![image](https://github.com/user-attachments/assets/81af538d-56c2-4d84-b151-fdecbf3a766c)<br>
9. Проверяем Flutter doctor <br>![image](https://github.com/user-attachments/assets/d1720880-ab89-4eb2-b034-5f50d934cb99)<br>
10. Вывод:<br>
11. Запуск в браузере:<br>![image](https://github.com/user-attachments/assets/1205aa4f-07f7-48c6-b116-e19ec1d2453c)<br>
12. Запуск на эмуляторе:<br>![image](https://github.com/user-attachments/assets/470657a1-b903-40a0-b355-1767abda7532)<br>



## _**Лекция 2**_
1. Создаем виджет без сохранения состояния<br>
```dart
import 'package:flutter/material.dart';
void main() {
  runApp(const MyStatelessWidget(color: Colors.red));
}
class MyStatelessWidget extends StatelessWidget{
  const MyStatelessWidget({super.key, required this.color});
  final Color color;
  @override
  Widget build(BuildContext context) {  
    return Container(
      color: color
    );
  }
}
```
<br>![image](https://github.com/user-attachments/assets/bad585cb-bfcc-46c5-bf9d-ce80311d3f15)<br>
2. Изменяю код для виджета с отслеживанием состояния, добавляю Stateful<br>
```dart
import 'package:flutter/material.dart';
void main() {
  runApp(MyStatelessWidget(color: const Color.fromARGB(255, 231, 244, 54)));
}
class MyStatelessWidget extends StatefulWidget {
  const MyStatelessWidget({super.key, required this.color});
  final Color color;
  @override
  State<MyStatelessWidget> createState() => _MyStatelessWidgetState();
}
class _MyStatelessWidgetState extends State<MyStatelessWidget> {
  late Color color;
  void initState() {
    super.initState();
    color = widget.color;
  }
  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        setState(() {
          color = const Color.fromARGB(255, 38, 186, 231);
        });
      },
      child: Container(color: color),
    );
  }
}
```
<br>
При нажатии цвет фона менется на другой <br>

![image](https://github.com/user-attachments/assets/b9723154-abb2-4007-a336-4453ac0925e6)
<br>
3. Работа с Asset
3.1 Создаю новую папку с именем "Asset" <br>
![image](https://github.com/user-attachments/assets/bb80a1dd-da54-437d-98f3-af4bb5e3cd4d)
<br>
3.2 Добавляю в эту папку изображение <br>
3.3 Добавляю код в файл с расширением yaml <br>
  ![image](https://github.com/user-attachments/assets/4c949fd5-434d-4d9b-b701-40d2d0609b85)
<br>
  ![image](https://github.com/user-attachments/assets/355b7782-b480-4589-ac5d-a0b093b764a7)
<br>
3.4 Изменяем код в main.dart <br>
 
```dart
import 'package:flutter/material.dart';

void main() {
  runApp( MaterialApp(
    home: Scaffold(
appBar: AppBar(
  title: const Text('Title'),
  actions:[IconButton(onPressed: (){}, icon: const Icon(Icons.add))],
),
    body: MyStatelessWidget(color: Colors.red),
     floatingActionButton: IconButton(onPressed: (){}, icon: const Icon(Icons.add)),
)));
}

class MyStatelessWidget extends StatefulWidget{
  const MyStatelessWidget({super.key, required this.color});
  
  final Color color;

  @override
  State<MyStatelessWidget> createState() => _MyStatelessWidgetState();
}

class _MyStatelessWidgetState extends State<MyStatelessWidget> {
  late Color color;
  void initState(){
    super.initState();
    color=widget.color;
  }
  
  @override
  Widget build(BuildContext context) {  
    return GestureDetector( 
      onTap: () {
        setState(() {
                  color = Colors.green;
        });
      },
      child: Container(
        color: color,
        child: Image.asset('Assets/zzz.jpg'),
      ),
    );
  }
}

```
Но возникает ошибка: <br>
![image](https://github.com/user-attachments/assets/6e7f7c78-6273-43da-98bd-c730fed9219b)
<br>
После исправления ошибки: <br>
![image](https://github.com/user-attachments/assets/b8e4a7f4-ca24-47f0-aad5-5846cc0d675a)
<br>

4. Работа с Font
4.1 Создаем папку для шрифтов <br>
   
![image](https://github.com/user-attachments/assets/b4432214-4b74-4e58-a508-21203cea176b)

<br>
4.2 Добавляем код в файл с расщирением yaml
<br>

![image](https://github.com/user-attachments/assets/2930c887-5d8f-452d-83fa-27bcbfe7ac06)

<br>
4.3 Изменяем код для main.dart <br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: const Text(
          'Title',
          style: TextStyle(fontFamily: 'Roboto', fontSize: 20),
        ),
        actions: [
          IconButton(
            onPressed: () {},
            icon: const Icon(Icons.add),
          )
        ],
      ),
      body: MyStatelessWidget(color: Colors.lightBlue),
      floatingActionButton:
          IconButton(onPressed: () {}, icon: const Icon(Icons.add)),
    ),
  ));
}

class MyStatelessWidget extends StatefulWidget {
  const MyStatelessWidget({super.key, required this.color});

  final Color color;

  @override
  State<MyStatelessWidget> createState() => _MyStatelessWidgetState();
}

class _MyStatelessWidgetState extends State<MyStatelessWidget> {
  late Color color;

  @override
  void initState() {
    super.initState();
    color = widget.color;
  }

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        setState(() {
          color = Colors.green; // Меняет цвет на зелёный при нажатии.
        });
      },
      child: Container(
        color: color,
        child: const Center(
          child: Text(
            'Hello, Flutter!',
            style: TextStyle(
              fontFamily: 'Roboto',
              fontSize: 24,
              fontStyle: FontStyle.italic, // Используем курсивный шрифт.
              color: Colors.white, // Белый цвет текста.
            ),
          ),
        ),
      ),
    );
  }
}

```

<br>
Результат:
<br>

![image](https://github.com/user-attachments/assets/7548b534-8d90-48e6-ae0b-bed7da3728ef)
<br>
