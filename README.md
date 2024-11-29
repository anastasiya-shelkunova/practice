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

## _**Лекция 3**_
1. Создает простое Flutter-приложение с двумя квадратами (контейнерами), расположенными по центру экрана<br>

```dart

import 'package:flutter/material.dart';
import 'dart:math';

void main() {
  runApp(const MaterialApp(
    home: PositionedTile(),
  ));
}

class PositionedTile extends StatefulWidget {
  const PositionedTile({super.key});

  @override
  State<PositionedTile> createState() => _PositionedTileState();
}

class _PositionedTileState extends State<PositionedTile> {
  late List<Widget> tiles;

  @override
  void initState() {
    super.initState();
    tiles = <StatefullColorTile>[StatefullColorTile(), StatefullColorTile()];
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Row(
          mainAxisSize: MainAxisSize.min,
          children: tiles,
        ),
      ),
      floatingActionButton: FloatingActionButton(
          onPressed: swapTiles,
          child: const Icon(
            Icons.swap_horiz,
          )),
    );
  }

  void swapTiles() {
    setState(() {
      tiles.insert(1, tiles.removeAt(0));
    });
  }
}

class StatefullColorTile extends StatefulWidget {
  const StatefullColorTile({super.key});

  @override
  State<StatefullColorTile> createState() => _StatelfulColorfulTileState();
}

class _StatelfulColorfulTileState extends State<StatefullColorTile> {
  late Color color;

  @override
  void initState() {
    super.initState();
    color = Colors.primaries[Random().nextInt(Colors.primaries.length)];
  }

  @override
  Widget build(BuildContext context) {
    return Container(width: 250, height: 250, color: color);
  }
}
```

<br>

Результат:
<br>

![image](https://github.com/user-attachments/assets/11101cee-fcf6-43a1-a86a-0e291aac8a4a)

<br>

2. Что бы поменять их местами, надо добавить в код ключи: <br>

```dart
import 'dart:math';
import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(
    home: PositionedTile(),
  ));
}

class PositionedTile extends StatefulWidget {
  const PositionedTile({super.key});

  @override
  State<PositionedTile> createState() => _PositionedTileState();
}

class _PositionedTileState extends State<PositionedTile> {
  late List<Widget> tiles;

  @override
  void initState() {
    super.initState();
    tiles = [
      StatefullColorTile(
        key: UniqueKey(),
      ),
      StatefullColorTile(
        key: UniqueKey(),
      )
    ];
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        // Центрирование всего содержимого
        child: Row(
          mainAxisSize:
              MainAxisSize.min, // Уменьшаем строку до минимального размера
          mainAxisAlignment:
              MainAxisAlignment.center, // Центрируем по горизонтали
          crossAxisAlignment:
              CrossAxisAlignment.center, // Центрируем по вертикали
          children: tiles,
        ),
      ),
      floatingActionButton: FloatingActionButton(
          onPressed: swapTiles,
          child: const Icon(
            Icons.swap_horiz, // Меняем значок для ясности
          )),
    );
  }

  void swapTiles() {
    setState(() {
      tiles.insert(1, tiles.removeAt(0)); // Меняем виджеты местами
    });
  }
}

class StatefullColorTile extends StatefulWidget {
  const StatefullColorTile({super.key});

  @override
  State<StatefullColorTile> createState() => _StatelfulColorfulTileState();
}

class _StatelfulColorfulTileState extends State<StatefullColorTile> {
  late Color color;

  @override
  void initState() {
    super.initState();
    color = Colors.primaries[Random()
        .nextInt(Colors.primaries.length)]; // Генерация случайного цвета
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 250,
      height: 250,
      color: color,
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/913d450e-feb1-4363-8cf7-9f68cae7a256)

<br>

<br>

![image](https://github.com/user-attachments/assets/e9f5acf6-33d3-466e-8027-63f789e9b1f2)

<br>

## _**Лекция 4**_
1. Создаем код, который использует такие виджеты как:

<br>Layout Widgets<br>
<br>Padding<br>
<br>Align<br>
<br>Center<br>
<br>Container<br>
<br>Row<br>
<br>Column<br>
<br>Expanded<br>
<br>Stack<br>
<br>ListView <br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(const MaterialApp(home: LayoutWidgetsExample()));
}

class LayoutWidgetsExample extends StatelessWidget {
  const LayoutWidgetsExample({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Layout Widgets Example'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0), // Padding вокруг всего содержимого
        child: Column(
          children: [
            // Использование Center для центровки текста
            Center(
              child: Text(
                'Using Layout Widgets',
                style: Theme.of(context)
                    .textTheme
                    .headlineSmall, // Актуальный стиль
              ),
            ),
            const SizedBox(height: 16), // Отступ между элементами
            // Использование Align для выравнивания текста
            Align(
              alignment: Alignment.centerRight,
              child: const Text(
                'Aligned to Right',
                style: TextStyle(fontSize: 18, color: Color.fromARGB(255, 117, 189, 247)),
              ),
            ),
            const SizedBox(height: 16),
            // Контейнер с цветным фоном
            Container(
              color: Colors.lightBlue,
              height: 100,
              width: double.infinity,
              child: const Center(
                child: Text(
                  'This is a Container',
                  style: TextStyle(color: Colors.white),
                ),
              ),
            ),
            const SizedBox(height: 16),
            // Row с двумя контейнерами
            Row(
              children: [
                Expanded(
                  flex: 1,
                  child: Container(
                    height: 50,
                    color: Colors.green,
                    child: const Center(child: Text('Row Item 1')),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  flex: 2,
                  child: Container(
                    height: 50,
                    color: Colors.orange,
                    child: const Center(child: Text('Row Item 2')),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 16),
            // Использование Stack
            Stack(
              children: [
                Container(
                  height: 100,
                  color: Colors.purple,
                ),
                Align(
                  alignment: Alignment.topLeft,
                  child: Container(
                    height: 50,
                    width: 50,
                    color: Colors.yellow,
                    child: const Center(child: Text('Stack')),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 16),
            // ListView внутри Expanded
            Expanded(
              child: ListView(
                children: List.generate(
                  10,
                  (index) => Padding(
                    padding: const EdgeInsets.symmetric(vertical: 8.0),
                    child: Container(
                      height: 50,
                      color: Colors.primaries[index % Colors.primaries.length],
                      child: Center(
                        child: Text('ListView Item ${index + 1}'),
                      ),
                    ),
                  ),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/c1d1925b-ff03-453e-9cee-59a7d18e4354)

<br>




