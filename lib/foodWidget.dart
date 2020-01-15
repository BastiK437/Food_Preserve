// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// To keep your imports tidy, follow the ordering guidelines at
// https://www.dartlang.org/guides/language/effective-dart/style#ordering
import 'package:flutter/material.dart';

const _rowHeight = 100.0;
const _borderRadius = 50.0;

class FoodWidget extends StatelessWidget {

  final String foodName;
  final IconData iconLocation;
  final ColorSwatch color;
  final String date;

  const FoodWidget( @required this.foodName, @required this.iconLocation, @required this.color, @required this.date );


  Widget build(BuildContext context) {
    return Material(
      color: Colors.transparent,
      child: Container(
        height: _rowHeight,
        child: InkWell(
          borderRadius: BorderRadius.all(Radius.circular(_borderRadius)),
          highlightColor: color[50],
          splashColor: color[100],
          onTap: (){
            print('I was tapped');
          },
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Row(
              children: <Widget>[
                Padding(
                  padding: EdgeInsets.only(right: 16.0),
                  child: iconLocation != null ? Icon(
                    Icons.cake,
                    size: 60.0,
                  ) : null,
                ),
                Center(
                    child: Text(
                      foodName,
                      textAlign: TextAlign.center,
                      style: TextStyle(
                        color: Colors.grey[700],
                        fontSize: 24.0,
                        fontWeight: FontWeight.w700,
                      ),
                    )),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
