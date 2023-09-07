// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// ignore_for_file: must_be_immutable

import 'package:flutter/material.dart';
import 'package:flutter/physics.dart';
import 'package:flutter/services.dart';
import 'FoodWidget.dart';
import 'popup.dart';
import 'popup_content.dart';

const _noe = 8;

/// Category Route (screen).
///
/// This is the 'home' screen of the Unit Converter. It shows a header and
/// a list of [Categories].
///
/// While it is named CategoryRoute, a more apt name would be CategoryScreen,
/// because it is responsible for the UI at the route's destination.
class FoodRoute extends StatelessWidget {
  FoodRoute();

  late List<FoodWidget> categorys;

  static const _categoryNames = <String>[
    'Äpfel',
    'Bananen',
    'Joghurt',
    'Sahne',
    'Ananas',
    'Eier',
    'Milch',
    'Saft',
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
    categorys = List<FoodWidget>.generate(_noe,
        (i) => FoodWidget(_categoryNames[i], _baseColors[i], "02.04.2020"));

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
      floatingActionButton: FloatingActionButton(
        onPressed: () {
          showPopup(
            context,
            _popupBody(context),
            'Add Food',
          );
        },
        tooltip: 'Add Food',
        child: Icon(Icons.add),
      ),
    );
  }

  showPopup(BuildContext context, Widget widget, String title,
      {BuildContext? popupContext}) {
    Navigator.push(
      context,
      PopupLayout(
        top: 50,
        left: 30,
        right: 30,
        bottom: 50,
        child: PopupContent(
          content: Scaffold(
            appBar: AppBar(
              title: Text(title),
              systemOverlayStyle: SystemUiOverlayStyle.dark,
            ),
            resizeToAvoidBottomInset: false,
            body: widget,
          ),
        ),
      ),
    );
  }

  Widget _popupBody(BuildContext context) {
    return Container(
      child: Padding(
        padding: EdgeInsets.all(8.0),
        child: Column(
          children: <Widget>[
            Padding(
              padding: EdgeInsets.only(bottom: 10),
              child: TextField(
                //obscureText: true,
                decoration: InputDecoration(
                  border: OutlineInputBorder(),
                  labelText: 'Name',
                ),
              ),
            ),
            TextField(
              //obscureText: true,
              decoration: InputDecoration(
                border: OutlineInputBorder(),
                labelText: 'Mindesthaltbarkeitsdatum',
              ),
            ),
            Row(
              children: <Widget>[
                Container(
                  child: Padding(
                    padding: EdgeInsets.only(
                      bottom: 10,
                      left: 20,
                      right: 10,
                      top: 10,
                    ),
                    child: TextButton(
                      // color: Colors.blue,
                      // textColor: Colors.white,
                      // disabledColor: Colors.grey,
                      // disabledTextColor: Colors.black,
                      // padding: EdgeInsets.all(8.0),
                      // splashColor: Colors.blueAccent,
                      onPressed: () {
                        try {
                          Navigator.pop(context); //close the popup
                        } catch (e) {}
                      },
                      child: Text(
                        "Abbrechen",
                        style: TextStyle(fontSize: 20.0),
                      ),
                    ),
                  ),
                ),
                Container(
                  child: Padding(
                    padding: EdgeInsets.all(8.0),
                    child: TextButton(
                      // color: Colors.blue,
                      // textColor: Colors.white,
                      // disabledColor: Colors.grey,
                      // disabledTextColor: Colors.black,
                      // padding: EdgeInsets.all(8.0),
                      // splashColor: Colors.blueAccent,
                      onPressed: () {
                        try {
                          print("added before");

                          categorys.add(new FoodWidget(
                              "test1", _baseColors[3], "05.03.2020"));
                          print("added");
                          Navigator.pop(context); //close the popup
                        } catch (e) {
                          print("exception caught");
                          print(e);
                        }
                      },
                      child: Text(
                        "Hinzufügen",
                        style: TextStyle(fontSize: 20.0),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
