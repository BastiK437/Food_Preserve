import 'package:flutter/material.dart';
import 'FoodRoute.dart';

void main() {
  runApp( MaterialApp (
    debugShowCheckedModeBanner: false,
    home: MyHomePage(),
  ));
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Food Preserve',
      home: FoodRoute(),
    );
  }
}
