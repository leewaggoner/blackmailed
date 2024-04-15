package com.wreckingballsoftware.blackmailed.extensions

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json


fun Long.millisToTimeString(): String {
    val seconds = this / 1000
    return String.format("%02d:%02d", seconds / 60, seconds % 60)
}

fun List<String>.listJsonEncode(): String =
    Json.encodeToJsonElement(
        serializer = ListSerializer(String.serializer()),
        value = this
    ).toString()

fun List<List<String>>.listOfListsJsonEncode(): String =
    Json.encodeToJsonElement(
        serializer = ListSerializer(ListSerializer(String.serializer())),
        value = this
    ).toString()

fun String.listJsonDecode(): List<String> =
    Json.decodeFromString(
        deserializer = ListSerializer(String.serializer()),
        string = this
    )

fun String.listOfListsJsonDecode(): List<List<String>> =
    Json.decodeFromString(
        deserializer = ListSerializer(ListSerializer(String.serializer())),
        string = this
    )
