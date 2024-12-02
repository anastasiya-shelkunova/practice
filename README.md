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

## _**Лекция 7**_
1. Form<br>
Form используется для объединения и управления несколькими полями ввода.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(home: MyForm()));
}

class MyForm extends StatelessWidget {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Form Example')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'Enter your name'),
              ),
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    print('Form is valid!');
                  }
                },
                child: Text('Submit'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/7e9a3ad2-30be-4cea-87c4-7cba4a7c992f)

<br>

![image](https://github.com/user-attachments/assets/30ae4e1b-ad05-426f-acbf-2e3cf5ee2823)

<br>
2. TextField и TextFormField<br>

TextField и TextFormField используются для ввода текста.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: MyTextFieldExample(),
  ));
}

class MyTextFieldExample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('TextField and TextFormField Example')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            TextField(
              decoration: InputDecoration(
                labelText: 'TextField',
                hintText: 'Enter text here',
                border: OutlineInputBorder(),
              ),
            ),
            SizedBox(height: 16.0),
            TextFormField(
              decoration: InputDecoration(
                labelText: 'TextFormField',
                hintText: 'Enter text here',
                border: OutlineInputBorder(),
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

![image](https://github.com/user-attachments/assets/c249e7f0-068f-4fd9-9cca-3864c9b29f51)

<br>


3. Стилизация полей ввода<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: StyledTextField(),
  ));
}

class StyledTextField extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Styled TextField')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: TextField(
          decoration: InputDecoration(
            labelText: 'Enter text',
            border: OutlineInputBorder(),
            prefixIcon: Icon(Icons.person),
            filled: true,
            fillColor: Colors.grey[200],
          ),
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/111045b8-f736-4f1c-a9b3-c7b449a34857)

<br>

4. Ограничения ввода в поля формы<br>

```dart
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MaterialApp(
    home: LimitedInputField(),
  ));
}

class LimitedInputField extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Limited Input Example')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: TextField(
          decoration: InputDecoration(
            labelText: 'Enter digits only',
            hintText: '12345',
            border: OutlineInputBorder(),
          ),
          keyboardType: TextInputType.number, // Открывает цифровую клавиатуру
          inputFormatters: [
            FilteringTextInputFormatter.digitsOnly
          ], // Ограничение: только цифры
        ),
      ),
    );
  }
}
```
<br>
При вводе букв (например, "a", "b") или символов (например, "!"), они будут проигнорированы.<br>

![image](https://github.com/user-attachments/assets/bf86961f-9742-4348-9b2b-d604fb7645a5)

<br>

5. Получение текста из полей формы <br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: GetTextExample(),
  ));
}

class GetTextExample extends StatelessWidget {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Get Text from TextField')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(
              controller: _controller,
              decoration: InputDecoration(labelText: 'Enter some text'),
            ),
            ElevatedButton(
              onPressed: () {
                print('Entered text: ${_controller.text}');
              },
              child: Text('Print Text'),
            ),
          ],
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/fa686781-72f1-40e3-b254-6e08ffd83307)

<br>

![image](https://github.com/user-attachments/assets/218eb69c-6581-46a2-9357-beeb5f876783)

<br>
6. Валидация полей формы<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: ValidationExample(),
  ));
}

class ValidationExample extends StatelessWidget {
  final _formKey = GlobalKey<FormState>();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Form Validation')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'Enter email'),
                validator: (value) {
                  if (value == null || !value.contains('@')) {
                    return 'Enter a valid email';
                  }
                  return null;
                },
              ),
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    print('Form is valid');
                  }
                },
                child: Text('Submit'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/b33b8126-30ef-49f2-a171-2001066ace17)

<br>

![image](https://github.com/user-attachments/assets/c58caecb-4e50-4c2a-bf22-de8a99f64244)

<br>

7. Выпадающий список<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: DropdownExample(),
  ));
}

class DropdownExample extends StatefulWidget {
  @override
  _DropdownExampleState createState() => _DropdownExampleState();
}

class _DropdownExampleState extends State<DropdownExample> {
  String? _selectedValue; // Хранит выбранное значение

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Dropdown Example')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            DropdownButton<String>(
              value: _selectedValue, // Текущее выбранное значение
              hint: Text('Select an option'), // Подсказка
              items: ['Option 1', 'Option 2', 'Option 3']
                  .map((value) => DropdownMenuItem<String>(
                        value: value,
                        child: Text(value),
                      ))
                  .toList(),
              onChanged: (newValue) {
                setState(() {
                  _selectedValue = newValue; // Обновление выбранного значения
                });
              },
            ),
            SizedBox(height: 16.0),
            if (_selectedValue != null)
              Text(
                'Selected: $_selectedValue',
                style: TextStyle(fontSize: 18.0),
              ),
          ],
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/c384d1d7-49bb-4bfc-8d2b-94934c779355)

<br>

![image](https://github.com/user-attachments/assets/b85bc554-9080-4c22-a8da-6ed3bcfe1337)

<br>

![image](https://github.com/user-attachments/assets/9ba1c5c4-e830-46ed-aa9e-3771bf14ea97)

<br>


8. "Фокусировка" полей ввода<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: FocusExample(),
  ));
}

class FocusExample extends StatelessWidget {
  final FocusNode _focusNode = FocusNode();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Focus Example')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            TextField(focusNode: _focusNode),
            ElevatedButton(
              onPressed: () {
                _focusNode.requestFocus();
              },
              child: Text('Focus TextField'),
            ),
          ],
        ),
      ),
    );
  }
}
```
<br>


![image](https://github.com/user-attachments/assets/cd8ee200-2b1e-4256-95fa-853754fc6f92)

<br>
9. SnackBar- демонстрирует, как отобразить кратковременное всплывающее сообщение внизу экрана в приложении Flutter.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: SnackBarExample(),
  ));
}

class SnackBarExample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('SnackBar Example')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            ScaffoldMessenger.of(context).showSnackBar(
              SnackBar(content: Text('This is a SnackBar!')),
            );
          },
          child: Text('Show SnackBar'),
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/76836b6d-96fa-45a5-abc0-76c2ba3dc6ec)

<br>

![image](https://github.com/user-attachments/assets/f0d4e589-8e97-4924-87a1-e871b8685771)

<br>


10. AlertDialog - используется для отображения всплывающего окна с предупреждением (или диалогом) поверх основного интерфейса.
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: AlertDialogExample(),
  ));
}

class AlertDialogExample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('AlertDialog Example')),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            showDialog(
              context: context,
              builder: (context) => AlertDialog(
                title: Text('Alert'),
                content: Text('This is an alert dialog.'),
                actions: [
                  TextButton(
                    onPressed: () => Navigator.pop(context),
                    child: Text('OK'),
                  ),
                ],
              ),
            );
          },
          child: Text('Show Alert'),
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/1fd42459-b2bf-4966-865e-0b0e337296be)

<br>

![image](https://github.com/user-attachments/assets/68a5beb9-246e-420c-8c9b-489dceb449d2)

<br>

11. Использование жестов<br>
```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: GestureExample(),
  ));
}

class GestureExample extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Gesture Example')),
      body: GestureDetector(
        onTap: () {
          print('Screen tapped');
        },
        child: Container(
          color: Colors.blue,
          child: Center(
            child: Text('Tap anywhere', style: TextStyle(color: Colors.white)),
          ),
        ),
      ),
    );
  }
}

```
<br>

![image](https://github.com/user-attachments/assets/2d77aa19-07d5-4764-8719-8711a0d844b5)

<br>

![image](https://github.com/user-attachments/assets/940e44c6-6b98-452b-9362-581a2f2560d1)

<br>

## _**Лекция 8**_
1. Загружаем данные из HTTP (в формате JSON).<br>
2. Выполняем ручную сериализацию JSON с помощью создания модели.<br>
3. Демонстрация автоматическую сериализацию JSON с использованием пакета json_serializable.<br>

```dart
import 'dart:convert'; 
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http; 
import 'package:json_annotation/json_annotation.dart'; 

part 'main.g.dart'; // Генерируемая часть для json_serializable

void main() {
  runApp(MaterialApp(
    home: JsonExample(),
  ));
}

// Модель для ручной сериализации
class Post {
  final int userId;
  final int id;
  final String title;
  final String body;

  Post(
      {required this.userId,
      required this.id,
      required this.title,
      required this.body});

  // Ручная сериализация
  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(
      userId: json['userId'],
      id: json['id'],
      title: json['title'],
      body: json['body'],
    );
  }

  // Ручная сериализация
  Map<String, dynamic> toJson() {
    return {
      'userId': userId,
      'id': id,
      'title': title,
      'body': body,
    };
  }
}

// Модель для автогенерации с json_serializable
@JsonSerializable()
class Comment {
  final int postId;
  final int id;
  final String name;
  final String email;
  final String body;

  Comment(
      {required this.postId,
      required this.id,
      required this.name,
      required this.email,
      required this.body});

  factory Comment.fromJson(Map<String, dynamic> json) =>
      _$CommentFromJson(json);
  Map<String, dynamic> toJson() => _$CommentToJson(this);
}

class JsonExample extends StatefulWidget {
  @override
  _JsonExampleState createState() => _JsonExampleState();
}

class _JsonExampleState extends State<JsonExample> {
  List<Post> posts = [];
  List<Comment> comments = [];
  bool isLoading = true;

  @override
  void initState() {
    super.initState();
    fetchData();
  }

  // Получение данных
  Future<void> fetchData() async {
    // HTTP-запрос для получения постов
    final postResponse =
        await http.get(Uri.parse('https://jsonplaceholder.typicode.com/posts'));
    final commentResponse = await http
        .get(Uri.parse('https://jsonplaceholder.typicode.com/comments'));

    if (postResponse.statusCode == 200 && commentResponse.statusCode == 200) {
      // Ручная сериализация JSON для постов
      final List<dynamic> postJson = jsonDecode(postResponse.body);
      posts = postJson.map((data) => Post.fromJson(data)).toList();

      // Автогенерация сериализации JSON для комментариев
      final List<dynamic> commentJson = jsonDecode(commentResponse.body);
      comments = commentJson.map((data) => Comment.fromJson(data)).toList();

      setState(() {
        isLoading = false;
      });
    } else {
      throw Exception('Failed to load data');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('JSON Example')),
      body: isLoading
          ? Center(child: CircularProgressIndicator())
          : ListView(
              children: [
                Text(
                  'Posts (Manual JSON Serialization):',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
                ...posts.take(5).map((post) => ListTile(
                      title: Text(post.title),
                      subtitle: Text(post.body),
                    )),
                Divider(),
                Text(
                  'Comments (Generated JSON Serialization):',
                  style: TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
                ),
                ...comments.take(5).map((comment) => ListTile(
                      title: Text(comment.name),
                      subtitle: Text(comment.body),
                    )),
              ],
            ),
    );
  }
}
```
<br>
Для работы json_serializable нужно добавить зависимости в pubspec.yaml:<br>

![image](https://github.com/user-attachments/assets/acef46e0-82c8-40c7-9853-d9a9e7778695)

<br>
В итоге получаем:<br>

1. Загрузка данных:<br>

![image](https://github.com/user-attachments/assets/79a5cc6c-3d0f-4eea-a0a3-035609019540)

<br>


2. Первые 5 постов(заголовок и описпние):<br>

![image](https://github.com/user-attachments/assets/3827af24-1ada-4b72-9ab6-8948212256ed)

<br>

3. Первые 5 комментариев (имена авторов и комментарии):<br>

![image](https://github.com/user-attachments/assets/b523dacd-4550-4679-9946-2c19e928c528)

<br>


## _**Лекция 9**_
1. setState — это самый простой способ управления состоянием в Flutter. Это метод, который уведомляет Flutter о необходимости перерисовать виджеты с изменившимися данными. Используется для управления состоянием в пределах одного виджета.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: CounterApp(),
    );
  }
}

class CounterApp extends StatefulWidget {
  @override
  _CounterAppState createState() => _CounterAppState();
}

class _CounterAppState extends State<CounterApp> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("setState Example")),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('Counter value:', style: TextStyle(fontSize: 20)),
            Text('$_counter', style: TextStyle(fontSize: 40)),
            ElevatedButton(
              onPressed: _incrementCounter,
              child: Text("Increment"),
            ),
          ],
        ),
      ),
    );
  }
}
```
<br>

![image](https://github.com/user-attachments/assets/74974dd0-2352-474a-90c4-bc64e285aa97)

<br>

2. Использование InheritedWidget<br>
InheritedWidget используется для предоставления данных вниз по дереву виджетов без необходимости передавать их явно.<br>

```dart
import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class IndexProvider extends InheritedWidget {
  final int index;
  final Function(int) onIndexChanged;

  const IndexProvider({
    required this.index,
    required this.onIndexChanged,
    required Widget child,
  }) : super(child: child);

  static IndexProvider? of(BuildContext context) {
    return context.dependOnInheritedWidgetOfExactType<IndexProvider>();
  }

  @override
  bool updateShouldNotify(covariant IndexProvider oldWidget) {
    return oldWidget.index != index;
  }
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: IndexManager(),
    );
  }
}

class IndexManager extends StatefulWidget {
  @override
  _IndexManagerState createState() => _IndexManagerState();
}

class _IndexManagerState extends State<IndexManager> {
  int _currentIndex = 0;

  void _updateIndex(int newIndex) {
    setState(() {
      _currentIndex = newIndex;
    });
  }

  @override
  Widget build(BuildContext context) {
    return IndexProvider(
      index: _currentIndex,
      onIndexChanged: _updateIndex,
      child: MyHomepage(),
    );
  }
}

class MyHomepage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final indexProvider = IndexProvider.of(context);

    return Scaffold(
      appBar: AppBar(
        title: Text("InheritedWidget Example"),
      ),
      body: Center(
        child: Text(
          'Current index: ${indexProvider?.index ?? 0}',
          style: TextStyle(fontSize: 24),
        ),
      ),
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: indexProvider!.index,
        onTap: indexProvider.onIndexChanged,
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "Home"),
          BottomNavigationBarItem(icon: Icon(Icons.search), label: "Search"),
          BottomNavigationBarItem(
              icon: Icon(Icons.settings), label: "Settings"),
        ],
      ),
    );
  }
}
```
<br>

Вывод в центре экрана: Current index: 0 <br>
Это значение _currentIndex по умолчанию, установленное в IndexManager.<br>

![image](https://github.com/user-attachments/assets/959c413e-d030-4a6d-a71d-8dbf853137ea)

<br>
 При нажатии на вторую кнопку навигации (Search):<br>
BottomNavigationBar обновляет индекс через IndexProvider.<br>
На экране отобразится: Current index: 1<br>

![image](https://github.com/user-attachments/assets/f881e881-6be4-4efe-8ab4-3349f62839f2)

<br>
При нажатии на третью кнопку навигации (Settings):<br>
На экране отобразится: Current index: 2.<br>

![image](https://github.com/user-attachments/assets/0c56870c-d3f6-4c53-aa2f-a440f2b89068)
<br>
Эта информация (Current index) обновляется автоматически благодаря механизму обновления InheritedWidget, который уведомляет зависимые виджеты об изменении состояния.<br>

3. Демонстрирую использование InheritedWidget для управления состоянием и изменения цвета контейнера:<br>

```dart
import 'dart:math';
import 'package:flutter/material.dart';

void main() {
  runApp(AppDataProvider(
    appData: AppData(backgroundColor: Colors.green),
    child: const MaterialApp(
      home: HomePage(),
    ),
  ));
}

/// Класс AppData для хранения данных о цвете
class AppData {
  Color backgroundColor;

  AppData({required this.backgroundColor});

  /// Метод для изменения цвета
  void changeBackgroundColor(Color newColor) {
    backgroundColor = newColor;
  }
}

/// AppDataProvider, наследует InheritedWidget
class AppDataProvider extends InheritedWidget {
  const AppDataProvider({
    required this.appData,
    required super.child,
    super.key,
  });

  final AppData appData;

  static AppDataProvider? of(BuildContext context) =>
      context.dependOnInheritedWidgetOfExactType<AppDataProvider>();

  /// Метод для уведомления Flutter о необходимости обновления виджетов
  @override
  bool updateShouldNotify(AppDataProvider oldWidget) {
    return true; // Всегда уведомляем о любых изменениях
  }
}

/// Главная страница с контейнером и кнопкой для изменения цвета
class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("InheritedWidget Example")),
      body: Center(
        child: Container(
          width: 200,
          height: 200,
          color: AppDataProvider.of(context)?.appData.backgroundColor,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                AppDataProvider.of(context)
                        ?.appData
                        .backgroundColor
                        .toString() ??
                    '',
                textAlign: TextAlign.center,
                style: const TextStyle(fontSize: 16),
              ),
              const SizedBox(height: 10),
              ElevatedButton(
                onPressed: () {
                  setState(() {
                    AppDataProvider.of(context)
                        ?.appData
                        .changeBackgroundColor(Util.randomColor());
                  });
                },
                child: const Text('Change Color'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
class Util {
  static Color randomColor() {
    return Color(Random().nextInt(0xffffffff)).withOpacity(1.0);
  }
}
```
<br>
Цвет контейнера: зелёный (Colors.green), установленный в main.<br>
В тексте внутри контейнера будет отображаться код цвета (например, Color(0xff00ff00)).<br>

![image](https://github.com/user-attachments/assets/7a0ada62-9b78-479f-a902-ebc7786b9dec)

После нажатия на кнопку "Change Color":<br>

Цвет контейнера изменится на случайный.<br>
Код нового цвета будет отображаться в тексте внутри контейнера.<br>

![image](https://github.com/user-attachments/assets/720fc28c-715e-4922-a08d-aed82259e6d8)
<br>
4. Код для реализации изменения цвета с использованием ChangeNotifierProvider из пакета provider. Код включает основные возможности, такие как подписка на изменения состояния с помощью watch и обновление данных через read.<br>

```dart
import 'dart:math';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';


class AppData with ChangeNotifier {
  Color backgroundColor;

  AppData({required this.backgroundColor});

  void changeBackgroundColor(Color newColor) {
    backgroundColor = newColor;
    notifyListeners();
  }
}


class Util {
  static Color randomColor() {
    return Color(Random().nextInt(0xffffffff)).withOpacity(1.0);
  }
}

void main() {
  runApp(ChangeNotifierProvider(
    create: (context) => AppData(backgroundColor: Colors.green),
    child: const MyApp(),
  ));
}


class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Provider Example',
      theme: ThemeData(primarySwatch: Colors.blue),
      home: const HomePage(),
    );
  }
}

/// Главная страница
class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Provider Example')),
      body: Center(
        child: Container(
          width: 200,
          height: 200,
          color: context.watch<AppData>().backgroundColor,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
             
              Text(
                context.watch<AppData>().backgroundColor.toString(),
                textAlign: TextAlign.center,
                style: const TextStyle(fontSize: 16),
              ),
              const SizedBox(height: 10),

              
              ElevatedButton(
                onPressed: () {
                  context
                      .read<AppData>()
                      .changeBackgroundColor(Util.randomColor());
                },
                child: const Text('Change Color'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
```
<br>
При запуске контейнер отображает цвет Colors.green и текст Color(0xff00ff00).<br>

![image](https://github.com/user-attachments/assets/7897106f-f495-405f-b3d4-ce4b42d2f1d9)

<br>
При нажатии кнопки:<br>
Генерируется новый случайный цвет.<br>
Фон контейнера и текст обновляются автоматически, благодаря механизму уведомления notifyListeners.<br>

![image](https://github.com/user-attachments/assets/84f1d46d-d33c-4db4-9766-daef1370e241)

<br>

## _**Лекция 10**_
Потоки (Streams) в Dart — это последовательности асинхронных данных, которые передаются с течением времени. Основная цель — это абстракция работы с асинхронными данными, например, событиями, полученными с серверов или пользовательским вводом.<br>

#1. Проект Flutter с использованием BLoC<br>

BLoC (Business Logic Component) — это архитектурный паттерн, который отделяет бизнес-логику от UI-слоя в приложении. В нем вся логика работы с состояниями представлена потоками.<br>

Компоненты BLoC:<br>

Входные потоки — принимают события (например, действия пользователя).<br>
Выходные потоки — из которых получаем данные (например, новые состояния).<br>

1. Установка зависимостей<br>
В pubspec.yaml добавляю зависимости для flutter_bloc:<br>

![image](https://github.com/user-attachments/assets/05430121-b8b2-42c0-85f2-049a79a4c920)

<br>
2. Создаю файл counter_event.dart<br>

```dart
abstract class CounterEvent {}
class IncrementCounter extends CounterEvent {} // Событие увеличения счетчика
class DecrementCounter extends CounterEvent {}  // Событие уменьшения счетчика
```
<br>
3. Создаю файл counter_state.dart<br>

```dart
abstract class CounterState {
  final int counterValue;
  CounterState({required this.counterValue});
}

class CounterInitial extends CounterState {
  CounterInitial({required int counterValue})
      : super(counterValue: counterValue);
}

class CounterChanged extends CounterState {
  CounterChanged({required int counterValue})
      : super(counterValue: counterValue);
}
```
<br>

4. Создаю файл counter_bloc.dart<br>

```dart
// lib/bloc/counter_bloc.dart

import 'package:flutter_bloc/flutter_bloc.dart';
import 'counter_event.dart';
import 'counter_state.dart';

class CounterBloc extends Bloc<CounterEvent, CounterState> {
  CounterBloc() : super(CounterInitial(counterValue: 0)); // начальное состояние

  @override
  Stream<CounterState> mapEventToState(CounterEvent event) async* {
    if (event is IncrementCounter) {
      // Если событие Increment, увеличиваем счетчик
      yield CounterChanged(counterValue: state.counterValue + 1);
    } else if (event is DecrementCounter) {
      // Если событие Decrement, уменьшаем счетчик
      yield CounterChanged(counterValue: state.counterValue - 1);
    }
  }
}
```
<br>
5. В main.dart создаю основной экран и используйте BlocProvider и BlocBuilder для работы с BLoC.<br>

```dart
// lib/main.dart

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'bloc/counter_bloc.dart';
import 'bloc/counter_event.dart';
import 'bloc/counter_state.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: BlocProvider(
        create: (context) => CounterBloc(), // Провайдер BLoC
        child: CounterScreen(),
      ),
    );
  }
}

class CounterScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('BLoC Example')),
      body: Center(
        child: BlocBuilder<CounterBloc, CounterState>(
          builder: (context, state) {
            int counterValue = state.counterValue;

            return Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text('Counter: $counterValue', style: TextStyle(fontSize: 32)),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ElevatedButton(
                      onPressed: () {
                        BlocProvider.of<CounterBloc>(context)
                            .add(IncrementCounter()); // отправляем событие
                      },
                      child: Text('Increment'),
                    ),
                    SizedBox(width: 16),
                    ElevatedButton(
                      onPressed: () {
                        BlocProvider.of<CounterBloc>(context)
                            .add(DecrementCounter()); // отправляем событие
                      },
                      child: Text('Decrement'),
                    ),
                  ],
                ),
              ],
            );
          },
        ),
      ),
    );
  }
}
```
<br>

При запуске:<br>

![image](https://github.com/user-attachments/assets/484e13ef-6f74-47df-b8a1-e635322e9ba7)

При нажатии кнопки Increment:<br>

![image](https://github.com/user-attachments/assets/7c16e289-77e3-43a5-8246-08583a48fee4)

<br>
При нажатии на кнопку Decrement:<br>

![image](https://github.com/user-attachments/assets/d0ef5e84-1b42-47c2-a48b-d364192f8a7d)

<br>
#2. Проект Flutter с использованием Cubit<br>

1. Создаю файл counter_state.dart<br>

```dart
abstract class CounterState {
  final int counterValue;
  CounterState({required this.counterValue});
}

class CounterInitial extends CounterState {
  CounterInitial({required int counterValue})
      : super(counterValue: counterValue);
}

class CounterChanged extends CounterState {
  CounterChanged({required int counterValue})
      : super(counterValue: counterValue);
}
```
<br>

2. Создаю файл counter_cubit.dart<br>

```dart
// lib/cubit/counter_cubit.dart

import 'package:bloc/bloc.dart';
import 'counter_state.dart';

class CounterCubit extends Cubit<CounterState> {
  CounterCubit()
      : super(CounterInitial(counterValue: 0)); // начальное состояние

  void increment() {
    int newValue = state.counterValue + 1;
    emit(CounterChanged(counterValue: newValue)); // изменяем состояние
  }

  void decrement() {
    int newValue = state.counterValue - 1;
    emit(CounterChanged(counterValue: newValue)); // изменяем состояние
  }
}
```
<br>
3. В main.dart создаю основной экран и использую BlocProvider и BlocBuilder для работы с Cubit.<br>

```dart
// lib/main.dart

import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'cubit/counter_cubit.dart';
import 'cubit/counter_state.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: BlocProvider(
        create: (context) => CounterCubit(), // Провайдер Cubit
        child: CounterScreen(),
      ),
    );
  }
}

class CounterScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Cubit Example')),
      body: Center(
        child: BlocBuilder<CounterCubit, CounterState>(
          builder: (context, state) {
            int counterValue = state.counterValue;

            return Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text('Counter: $counterValue', style: TextStyle(fontSize: 32)),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ElevatedButton(
                      onPressed: () {
                        BlocProvider.of<CounterCubit>(context)
                            .increment(); // отправляем метод
                      },
                      child: Text('Increment'),
                    ),
                    SizedBox(width: 16),
                    ElevatedButton(
                      onPressed: () {
                        BlocProvider.of<CounterCubit>(context)
                            .decrement(); // отправляем метод
                      },
                      child: Text('Decrement'),
                    ),
                  ],
                ),
              ],
            );
          },
        ),
      ),
    );
  }
}
```
<br>

Результат:<br>
При нажатии на кнопку Increment:<br>

![image](https://github.com/user-attachments/assets/2a0000c4-6c6a-4ceb-9d2d-575bf7fc46ed)

<br>

При нажатии на кнопку Decrement:<br>

![image](https://github.com/user-attachments/assets/0a0aeac8-2529-46b2-8948-e1b7dcad1699)

<br>

#Использованием Cubit вместо BLoC, который выполняет ту же задачу (изменение цвета при нажатии на кнопку).<br>

1. Создание класса ColorCubit:<br>

```dart
import 'package:bloc/bloc.dart';
import 'package:flutter/material.dart';

// Утилита для генерации случайного цвета
class Util {
  static Color randomColor() {
    final random = (DateTime.now().millisecondsSinceEpoch % 256);
    return Color.fromRGBO(random, random, random, 1);
  }
}

// Cubit для управления состоянием цвета
class ColorCubit extends Cubit<Color> {
  ColorCubit() : super(Colors.green); // начальный цвет зеленый

  // Метод для смены цвета
  void changeColor() {
    emit(Util.randomColor()); // генерируем и отправляем новый случайный цвет
  }
}
```
<br>

2. Создание экрана с UI для работы с Cubit:<br>

```dart
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'cubit/color_cubit.dart'; // Импортируем наш Cubit

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Cubit Color Change')),
      body: BlocProvider(
        create: (context) =>
            ColorCubit(), // Создаем и передаем Cubit в дерево виджетов
        child: Center(
          child: BlocBuilder<ColorCubit, Color>(
            // Подписываемся на изменения цвета
            builder: (context, state) {
              return Container(
                width: 200,
                height: 200,
                color: state, // Используем состояние (цвет)
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Text(state.toString()), // Показываем цвет в виде строки
                    ElevatedButton(
                      onPressed: () {
                        // Отправляем событие для смены цвета
                        context.read<ColorCubit>().changeColor();
                      },
                      child: const Text('Change color'),
                    ),
                  ],
                ),
              );
            },
          ),
        ),
      ),
    );
  }
}

void main() {
  runApp(MaterialApp(home: HomePage()));
}
```
<br>

![image](https://github.com/user-attachments/assets/212a1baa-0621-4ebb-81d4-895835cf37f8)

<br>

![image](https://github.com/user-attachments/assets/5bb292e8-d537-427a-87a4-864b5eb44a52)

<br>
