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
  // final IconData iconLocation;
  final Color color;
  final String date;

  const FoodWidget(this.foodName, this.color, this.date);

  Widget build(BuildContext context) {
    double _width = MediaQuery.of(context).size.width;
    Color _color = Colors.orange;
    int daysLeft = 20;
    return Material(
        child: Padding(
      padding: EdgeInsets.all(4.0),
      child: Container(
        decoration: BoxDecoration(
          color: Colors.black12,
          border: Border.all(
            color: _color,
            width: 2,
          ),
          borderRadius: BorderRadius.circular(10),
        ),
        //padding: EdgeInsets.all(8.0),
        //color: Colors.red,
        height: _rowHeight,
        child: Container(
          decoration: BoxDecoration(
            color: Colors.white,
            border: Border.all(
              color: Colors.white,
              width: 4,
            ),
            borderRadius: BorderRadius.circular(10),
          ),
          child: Row(
            children: <Widget>[
              Container(
                decoration: BoxDecoration(
                  color: Colors.orange,
                  border: Border.all(
                    color: Colors.white,
                    width: 4,
                  ),
                  borderRadius: BorderRadius.circular(10),
                ),
                //padding: EdgeInsets.all(4.0),
                width: _width * 0.75,
                child: Column(
                  children: <Widget>[
                    Container(
                        padding: EdgeInsets.all(4.0),
                        color: Colors.white,
                        child: Align(
                          alignment: Alignment.topLeft,
                          child: Text(
                            foodName,
                            textAlign: TextAlign.left,
                            style: TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 22,
                            ),
                          ),
                        )),
                    Container(
                      padding: EdgeInsets.all(4.0),
                      color: Colors.white,
                      child: Row(
                        children: <Widget>[
                          Container(
                            child: Text(
                              "MHD: ",
                              textAlign: TextAlign.left,
                              style: TextStyle(
                                fontSize: 15,
                              ),
                            ),
                          ),
                          Container(
                            child: Text(
                              date,
                              textAlign: TextAlign.left,
                              style: TextStyle(
                                fontSize: 15,
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ],
                ),
                //child: Text("Container 1"),
              ),
              Container(
                decoration: BoxDecoration(
                  color: _color,
                  border: Border.all(
                    color: _color,
                    width: 6,
                  ),
                  borderRadius: BorderRadius.circular(10),
                ),
                width: _rowHeight - 20,
                height: _rowHeight - 20,
                //padding: EdgeInsets.all(4.0),
                child: Container(
                  decoration: BoxDecoration(
                    color: _color,
                    border: Border.all(
                      color: _color,
                      width: 4,
                    ),
                    borderRadius: BorderRadius.circular(10),
                  ),
                  child: Align(
                    alignment: Alignment.center,
                    child: Text(
                      daysLeft.toString(),
                      style: TextStyle(
                        fontSize: 25,
                      ),
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    ));
  }
}
