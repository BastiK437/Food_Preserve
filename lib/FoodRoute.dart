// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

import 'package:flutter/material.dart';
import 'foodWidget.dart';

// TODO: Check if we need to import anything

// TODO: Define any constants
const _noe = 8;

/// Category Route (screen).
///
/// This is the 'home' screen of the Unit Converter. It shows a header and
/// a list of [Categories].
///
/// While it is named CategoryRoute, a more apt name would be CategoryScreen,
/// because it is responsible for the UI at the route's destination.
class FoodRoute extends StatelessWidget {
  const FoodRoute();

  static const _categoryNames = <String>[
    'Length',
    'Area',
    'Volume',
    'Mass',
    'Time',
    'Digital Storage',
    'Energy',
    'Currency',
  ];

  static const _baseColors = <Color>[
    Colors.teal,
    Colors.orange,
    Colors.pinkAccent,
    Colors.blueAccent,
    Colors.yellow,
    Colors.greenAccent,
    Colors.purpleAccent,
    Colors.red,
  ];

  @override
  Widget build(BuildContext context) {
    // from above. Use a placeholder icon, such as `Icons.cake` for each
    // Category. We'll add custom icons later.
    final categorys = List<FoodWidget>.generate(_noe, (i) => FoodWidget(_categoryNames[i], null, _baseColors[i], "test"));

    final listView = Container(
      child: ListView(
        children: categorys,
      ),
    );

    final appBar = AppBar(
      elevation: 0.0,
      centerTitle: true,
      title: Text(
        'Food Preserve',
        style: TextStyle(
          fontSize: 30.0,
        ),
      ),

    );

    return Scaffold(
      appBar: appBar,
      body: listView,
    );
  }
}
