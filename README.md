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

## _**Лекция 5**_
1. Что такое Null Safety <br>
Null Safety — это механизм в Dart, который предотвращает ошибки, связанные с обращением к объектам, которые могут быть null. Основная цель — сделать код более безопасным, обеспечивая, что переменные могут быть null, только если это явно указано.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  int? nullableNumber; // Может быть null
  nullableNumber = null; // Разрешено
  print(nullableNumber); // Вывод: null

  int nonNullableNumber = 42; // Не может быть null
  print(nonNullableNumber); // Вывод: 42
}
```
<br>

![image](https://github.com/user-attachments/assets/55a755dc-60a2-4864-b243-7be248aee4d0)

<br>

2. Основные принципы Null Safety<br>

Переменные должны быть объявлены либо как "nullable" (Тип?), либо "non-nullable" (Тип).
Инициализация: Все non-nullable переменные должны быть инициализированы значением.
Null-aware операторы помогают безопасно работать с nullable-объектами.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  String? nullableString; // Может быть null
  nullableString = 'Hello';
  print(nullableString); // Вывод: Hello

  String nonNullableString = 'Dart is awesome!'; // Не может быть null
  print(nonNullableString); // Вывод: Dart is awesome!
}
```
<br>

![image](https://github.com/user-attachments/assets/f7f8c8c6-3e43-418f-bf46-dd4902c6ac3c)

<br>

3. Иерархия типов<br>

Иерархия типов подразумевает, что null может быть присвоен только переменным типа Type?.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  String? nullableString = null; // Может быть null
  nullableString ??= 'Default Value'; // Присваивается, если значение null
  print(nullableString); // Вывод: Default Value

  String nonNullableString = 'Not null!';
  print(nonNullableString); // Вывод: Not null!
}
```
<br>

![image](https://github.com/user-attachments/assets/afc6d060-9406-4f50-a155-c888c9376469)

<br>

4. Null-aware операторы<br>
Операторы для работы с null.<br>
Оператор ?? <br>

```dart
import 'package:flutter/material.dart';

void main() {
  int? nullableNumber = null;
  int result =
      nullableNumber ?? 10; // Возвращает 10, если nullableNumber == null
  print(result); // Вывод: 10
}
```

<br>

![image](https://github.com/user-attachments/assets/0c698793-50fa-4a94-8eb6-bb14f081753e)

<br>

Оператор ?.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  String? nullableString = null;
  print(nullableString?.length); // Не вызывает ошибку, возвращает null
  // Вывод: null
}
```
<br>

![image](https://github.com/user-attachments/assets/e4c980ac-87b4-4e37-a338-f61551c8426d)

<br>

Оператор ??= <br>

```dart
import 'package:flutter/material.dart';

void main() {
  int? value;
  value ??= 5; // Присваивает 5, если значение null
  print(value); // Вывод: 5
}
```
<br>

![image](https://github.com/user-attachments/assets/6e487d93-7930-42cd-a504-083e8b2a1a20)

<br>

5. Каскадный null-aware оператор<br>
Позволяет безопасно вызывать методы у nullable объектов.<br>

```dart
import 'package:flutter/material.dart';

class Person {
  String? name;
  void setName(String newName) => name = newName;
}

void main() {
  Person? person = null;
  person?..setName('Alice'); // Не вызывает метод, если person == null
  print(person?.name); // Вывод: null

  person = Person();
  person?..setName('Bob'); // Устанавливаем имя
  print(person?.name); // Вывод: Bob
}
```
<br>

![image](https://github.com/user-attachments/assets/57955413-402f-45ae-9d88-f2d90211bba7)

<br>

6. Модификатор late <br>
Позволяет отложить инициализацию переменных, которые не могут быть null.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  late String greeting;
  greeting = 'Hello, late initialization!';
  print(greeting); // Вывод: Hello, late initialization!
}
```
<br>

![image](https://github.com/user-attachments/assets/4e01a7ce-e873-41fc-861c-75f2fa14f8e9)

<br>

7. Работа с коллекциями <br>
Коллекции поддерживают null-safe операции.<br>

Коллекция с nullable элементами:<br>

```dart
import 'package:flutter/material.dart';

void main() {
  List<int?> numbers = [1, 2, null, 4];
  print(numbers); // Вывод: [1, 2, null, 4]
}
```
<br>

![image](https://github.com/user-attachments/assets/a3974526-c4bd-4d9c-b1fe-adf1127e9baa)

<br>

Удаление null-значений:<br>
```dart
import 'package:flutter/material.dart';

void main() {
  List<int?> numbers = [1, null, 3];
  List<int> nonNullableNumbers = numbers.whereType<int>().toList();
  print(nonNullableNumbers); // Вывод: [1, 3]
}
```
![image](https://github.com/user-attachments/assets/470ded71-5767-43c0-b071-303da4d70872)

<br>

8. Работа с параметрами класса<br>
Позволяет указывать, может ли параметр быть null.<br>

```dart
import 'package:flutter/material.dart';

class User {
  final String name;
  final String? email;

  User(this.name, this.email);
}

void main() {
  User user = User('Alice', null); // email может быть null
  print(user.name); // Вывод: Alice
  print(user.email ?? 'No email provided'); // Вывод: No email provided
}
```
<br>

![image](https://github.com/user-attachments/assets/4b9eeb5e-2490-4961-b95e-e78a46db1c16)
<br>

9. Работа с параметрами функций<br>
Nullable параметры позволяют передавать null.<br>
```dart
void greet(String? name) {
  print('Hello, ${name ?? 'Guest'}!');
}

void main() {
  greet(null); // Вывод: Hello, Guest!
  greet('Alice'); // Вывод: Hello, Alice!
}
```
<br>

![image](https://github.com/user-attachments/assets/e946dca7-7c6c-4667-8305-4540b1f04938)

<br>

## _**Лекция 6**_
1. Простая навигация <br>
Навигация с помощью Navigator.push.<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: ScreenA()));
}

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen A')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => ScreenB()),
            );
          },
          child: Text('Go to Screen B'),
        ),
      ),
    );
  }
}

class ScreenB extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen B')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: Text('Back to Screen A'),
        ),
      ),
    );
  }
}
```

<br>
Первый экран <br>

![image](https://github.com/user-attachments/assets/60dc23a5-d3d2-4405-8280-c82da62b1e35)

<br>
Второй экран <br>

![image](https://github.com/user-attachments/assets/b04e6e98-e788-411e-8d26-f02967695de3)

<br>
2. Навигация по имени<br>
Используем именованные маршруты.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => ScreenA(),
      '/screenB': (context) => ScreenB(),
    },
  ));
}

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen A')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pushNamed(context, '/screenB');
          },
          child: Text('Go to Screen B'),
        ),
      ),
    );
  }
}

class ScreenB extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen B')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: Text('Back to Screen A'),
        ),
      ),
    );
  }
}
```
<br>
Screen B<br>

![image](https://github.com/user-attachments/assets/29d8c51b-3e65-4bee-9fbc-81517d793cf3)

<br>

Screen A<br>

![image](https://github.com/user-attachments/assets/2d89848d-9304-4781-a8ad-f1f5e4d71c87)

<br>

3. Простая передача данных между экранами<br>
Передача данных через Navigator.push.<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: ScreenA()));
}

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen A')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => ScreenB(data: 'Hello from Screen A!'),
              ),
            );
          },
          child: Text('Go to Screen B'),
        ),
      ),
    );
  }
}

class ScreenB extends StatelessWidget {
  final String data;
  ScreenB({required this.data});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen B')),
      body: Center(
        child: Text(data),
      ),
    );
  }
}
```
<br>

Экран А<br>

![image](https://github.com/user-attachments/assets/475fda02-d1b7-45a0-b205-a4d37e0bcfec)

<br>

Экран В <br>

![image](https://github.com/user-attachments/assets/7f153d2a-8ac6-4876-b02d-4262d204b19c)

<br>

4. Передача данных при навигации по имени<br>
Передача данных с использованием Navigator.pushNamed.<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    initialRoute: '/',
    routes: {
      '/': (context) => ScreenA(),
      '/screenB': (context) => ScreenB(),
    },
  ));
}

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen A')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pushNamed(
              context,
              '/screenB',
              arguments: 'Hello from Screen A!',
            );
          },
          child: Text('Go to Screen B'),
        ),
      ),
    );
  }
}

class ScreenB extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final String data = ModalRoute.of(context)!.settings.arguments as String;

    return Scaffold(
      appBar: AppBar(title: Text('Screen B')),
      body: Center(
        child: Text(data),
      ),
    );
  }
}
```
<br>

Экран А <br>

![image](https://github.com/user-attachments/assets/e2aa63ba-cec5-4d75-9819-807599853be7)

<br>

Экран В <br>

![image](https://github.com/user-attachments/assets/2d11b4ca-cfab-49a1-a8b7-e195f8c150ee)

<br>
5. Передача данных с onGenerateRoute<br>
Обработчик маршрутов, позволяющий передавать данные.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    initialRoute: '/',
    onGenerateRoute: (settings) {
      if (settings.name == '/screenB') {
        final String data = settings.arguments as String;
        return MaterialPageRoute(
          builder: (context) => ScreenB(data: data),
        );
      }
      return null;
    },
    home: ScreenA(),
  ));
}

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen A')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pushNamed(
              context,
              '/screenB',
              arguments: 'Hello from Screen A!',
            );
          },
          child: Text('Go to Screen B'),
        ),
      ),
    );
  }
}

class ScreenB extends StatelessWidget {
  final String data;
  ScreenB({required this.data});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen B')),
      body: Center(
        child: Text(data),
      ),
    );
  }
}
```
<br>
Результат:<br>

![image](https://github.com/user-attachments/assets/35e4d748-09b1-4cb0-88e5-2b58fd74e646)

<br>

6. Передача данных с использованием обратного возврата<br>
Возвращаем данные после завершения экрана.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: ScreenA()));
}

class ScreenA extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen A')),
      body: Center(
        child: ElevatedButton(
          onPressed: () async {
            final result = await Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => ScreenB()),
            );
            print('Result: $result');
          },
          child: Text('Go to Screen B'),
        ),
      ),
    );
  }
}

class ScreenB extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Screen B')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pop(context, 'Data from Screen B');
          },
          child: Text('Return to Screen A'),
        ),
      ),
    );
  }
}
```
<br>

Экран А <br>

![image](https://github.com/user-attachments/assets/e901e5d0-c4e6-42af-b315-f44514e1a93d)

<br>
Экран В <br>

![image](https://github.com/user-attachments/assets/0c5ec679-b156-47b1-81bf-7a17053d0035)

<br>

![image](https://github.com/user-attachments/assets/7616f82c-8e5a-4ab4-bfa0-fa0bf026d341)

<br>










