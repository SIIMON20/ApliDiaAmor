package com.example.aplidiaamor.presentacion.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TransparentTextField(
    //tipo de modificador para poderr personalizar cada control
    modifier:Modifier = Modifier,
    //texto escrito por el usuario que sera mutable porque cambia
    textFieldValue: MutableState<String>,
    //texto que llevara el control del mensaje
    textLabel : String,
    //numero maximo de caracteres a escribir
    maxChar: Int?=null,
    //convierta la primera letra de cada palabra a mayuscula
    capitalization:KeyboardCapitalization = KeyboardCapitalization.None,
    //tipo de teclado a utilizar
    keyboardType: KeyboardType,
    //acciones a realizar con el teclado
    keyboardActions:KeyboardActions,
    //accion a sefuir despues de perder el foco
    imeAction: ImeAction,
    //funcion composable para agregar un icono de se necesario
    trailingIcon: @Composable()(()->Unit)? = null,
    //ocualta los textos en los campos
    visualTransformation: VisualTransformation = VisualTransformation.None
    ){
    TextField(
        modifier = modifier.fillMaxSize() ,
        //numero de caracteres a tomar del control
    value = textFieldValue.value.take(maxChar ?:40),
        onValueChange = {textFieldValue.value=it},
        label = { Text(text = textLabel)},
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(
            capitalization = capitalization,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.textFieldColors(
               backgroundColor = Color.Transparent
        )
    )//fin del textfield
}//fin del control