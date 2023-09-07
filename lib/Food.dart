
import 'package:flutter/material.dart';

class Food extends StatelessWidget {
  final List<String> food;
  Food(this.food);

  Widget _buildProductItem(BuildContext context, int index) {
    return Card(
      child: Column(
        children: <Widget>[
          Image.asset('assets/macbook.jpg'),
          Text(food[index], style: TextStyle(color: Colors.deepPurple))
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
      itemBuilder: _buildProductItem,
      itemCount: food.length,
    );
  }
}