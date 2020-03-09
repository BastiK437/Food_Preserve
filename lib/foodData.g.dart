// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'FoodData.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

FoodData _$FoodDataFromJson(Map<String, dynamic> json) {
  return FoodData(
    json['name'] as String,
    json['mhd'] as String,
    json['opened'] as bool,
  );
}

Map<String, dynamic> _$FoodDataToJson(FoodData instance) => <String, dynamic>{
      'name': instance.name,
      'mhd': instance.mhd,
      'opened': instance.opened,
    };
