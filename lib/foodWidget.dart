// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// To keep your imports tidy, follow the ordering guidelines at
// https://www.dartlang.org/guides/language/effective-dart/style#ordering
import 'package:flutter/material.dart';

const _rowHeight = 80.0;
const _borderRadius = 50.0;

class FoodWidget extends StatelessWidget {

  final String foodName;
  final IconData iconLocation;
  final ColorSwatch color;
  final String date;

  const FoodWidget(@required this.foodName, @required this.iconLocation,
      @required this.color, @required this.date);

/*
  Widget build(BuildContext context) {

    return Material(
      child: Padding (
        padding: EdgeInsets.all(4.0),
        child: Container(
          decoration: BoxDecoration(
            color: Colors.black12,
            border: Border.all(
              color: Colors.grey,
              width: 8,
            ),
            borderRadius: BorderRadius.circular(12),
          ),
          height: _rowHeight,
          child: Column(
            children: <Widget>[
              SizedBox(
                width: double.infinity,
                child: Container(
                  color: Colors.red,
                  child: Text(
                    "Should be left",
                    textAlign: TextAlign.left,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );


  }

  */

  Widget build(BuildContext context) {
    double _width = MediaQuery.of(context).size.width;
    return Material(
      child: Padding (
        padding: EdgeInsets.all(4.0),
        child: Container(
          padding: new EdgeInsets.all(10.0),
          decoration: BoxDecoration(
            color: Colors.black12,
            border: Border.all(
              color: Colors.grey,
              width: 1,
            ),
          ),
          height: _rowHeight,
          child: Container(
            decoration: BoxDecoration(
              color: Colors.orange,
              border: Border.all(
                color: Colors.green,
                width: 1,
              ),
            ),
            width: _width*0.5,
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                SizedBox(

                  child: Container(
                    color: Colors.red,
                    child: Padding(
                      padding: EdgeInsets.all(4.0),
                      child: Text(
                        "SizedBox 1",
                        textAlign: TextAlign.left,
                      ),
                    ),
                  ),
                ),
                SizedBox(
                  width: double.infinity,
                  child: Container(
                    color: Colors.red,
                    child: Padding(
                      padding: EdgeInsets.all(4.0),
                      child: Text(
                        "SizedBox 2",
                        textAlign: TextAlign.left,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );


  }



}
