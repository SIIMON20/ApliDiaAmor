package com.example.aplidiaamor.presentacion.registration

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.example.aplidiaamor.presentacion.components.RoundedButton
import com.example.aplidiaamor.presentacion.components.TransparentTextField

@Composable

fun registrationScreen(){
    val nameValue = remember{ mutableStateOf("")}
    val emailValue = remember{ mutableStateOf("")}
    val phoneValue = remember{ mutableStateOf("")}
    val passValue = remember{ mutableStateOf("")}
    val confirmPassValue = remember{ mutableStateOf("")}
    var passwordVisibility by remember{mutableStateOf(false)}
    var confirmPasswordVisibility by remember { mutableStateOf(false)}
    val focusManager = LocalFocusManager.current
    Box(modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())){
            Row(verticalAlignment = Alignment.CenterVertically) {
               IconButton(onClick = {/*TODO*/} ){
                   Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Regresar al login",
                   tint = MaterialTheme.colors.primary)
               }
                Text(text="Crear una cuenta ", style=MaterialTheme.typography.h6.copy(
                    color = MaterialTheme.colors.primary
                ))
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TransparentTextField(
                    //texto nombre
                    textFieldValue = nameValue,
                    textLabel = "Name",
                    keyboardType = KeyboardType.Text,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                )//fin del textField del password
                TransparentTextField( //texto nombre
                    textFieldValue = emailValue,
                    textLabel = "Correo",
                    keyboardType = KeyboardType.Email,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next
                )
                TransparentTextField( //texto nombre
                    textFieldValue = phoneValue,
                    textLabel = "Telefono",
                    maxChar = 10,
                    keyboardType = KeyboardType.Phone,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next
                )
                TransparentTextField( //texto nombre
                    textFieldValue = passValue,
                    textLabel = "Password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onNext = {
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    imeAction = ImeAction.Next,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }) {
                            Icon(
                                imageVector = if (passwordVisibility) {
                                    Icons.Default.Visibility
                                } else {
                                    Icons.Default.VisibilityOff
                                },
                                contentDescription = "Toggle"
                            )
                        }
                    },//fin del traiLingIcon
                    visualTransformation = if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                )//fin del textField del password

                TransparentTextField(
                    //texto nombre
                    textFieldValue = confirmPassValue,
                    textLabel = "Confirmar password",
                    keyboardType = KeyboardType.Password,
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    ),
                    imeAction = ImeAction.Next,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                confirmPasswordVisibility = !confirmPasswordVisibility
                            }) {
                            Icon(
                                imageVector = if (confirmPasswordVisibility) {
                                    Icons.Default.Visibility
                                } else {
                                    Icons.Default.VisibilityOff
                                },
                                contentDescription = "Toggle"
                            )
                        }
                    },//fin del traiLingIcon
                    visualTransformation = if (confirmPasswordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                )
                Spacer(modifier =Modifier.height(16.dp))//espacio
                RoundedButton(
                    text = "Sing Up",
                    displayProgressBar = false,
                    onClick = {//TODO{Registerr}
                         }
                ) //Boton de Sing Up
                ClickableText(text = buildAnnotatedString {
                    append("Already have Account")
                    withStyle(
                        style = SpanStyle(
                            color = MaterialTheme.colors.primary,
                            fontWeight = FontWeight.Bold
                        )
                    ){
                        append("Login")
                    }
                },
                    onClick = {
                        //TODO
                    }) //Already have a Account

            }//fin de la columna interior
        Spacer(modifier = Modifier.height(16.dp))//espacio
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Divider(
                    modifier = Modifier.width(24.dp),
                    thickness = 1.dp,
                    color = Color.Gray)//linea divisora
                Text(modifier = Modifier.padding(8.dp),
                    text = "OR",
                    style = MaterialTheme.typography.h6.copy(fontWeight= FontWeight.Black
                    )
                ) // Linea OR
                Divider(
                    modifier = Modifier.width(24.dp),
                    thickness = 1.dp,
                    color = Color.Gray) //Linea divisora
                //Botones adicionales de redes sociales
                }//fin de la fila
            Text(modifier = Modifier.padding(9.dp),
                text = "Login with",
                style = MaterialTheme.typography.body1.copy(MaterialTheme.colors.primary),
                textAlign = TextAlign.Center
                )
            }//Fin de la columna interna
            Spacer(modifier = Modifier.height(16.dp)) //espacio
            Column(modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                //TODO {Creamos un nuevo componente para los botones.}
            }
        }//Fin de la columna exterior
    }//Fin del Box
}//Fin de la funcion principal