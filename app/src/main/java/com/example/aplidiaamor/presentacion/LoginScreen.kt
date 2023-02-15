package com.example.aplidiaamor.presentacion


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.aplidiaamor.R
import com.example.aplidiaamor.presentacion.components.TransparentTextField

@Composable
fun LoginScreen() {
    val emailValue = rememberSaveable{mutableStateOf("")}
    val passwordValue = rememberSaveable{mutableStateOf("")}
    var passwordVisibility = rememberSaveable{mutableStateOf("")}
    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.clash),
            contentDescription = "Imagen del logo",
            contentScale = ContentScale.Inside
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            ConstraintLayout() {
                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(510.dp)
                        .constrainAs(surface) {
                            //Alinea el control al final del surface
                            bottom.linkTo(parent.bottom)
                        },
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ) {
                    //Boton de input y de password
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Bienvenido",
                            style = MaterialTheme.typography.h4.copy(
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Text(text = "Accede a tu cuenta",
                            style = MaterialTheme.typography.h5.copy(
                                color = MaterialTheme.colors.primary,
                                fontWeight = FontWeight.Medium
                            )
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ){
                    TransparentTextField(
                        //colocamos el calor de la variable muteable
                        textFieldValue = emailValue,
                        //texto que mostrara el control
                        textLabel ="Email" ,
                        //tipo de teclado === email
                        keyboardType = KeyboardType.Email,
                        //accion del teclado TODO

                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(focusDirection = FocusDirection.Down)
                            }
                        ),
                        //foco a seguir despues de digitar
                        imeAction = ImeAction.Next,
                    )
                            TransparentTextField(//textfield del password
                                //colocamos el valor de la variable muteable
                                textFieldValue = passwordValue,
                                //texto que mostrara el control
                                textLabel = "Password",
                                //tipo de teclado === password
                                keyboardType = KeyboardType.Password,
                                //accion del teclado TODO
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()
                                        //TODO **accion a seguir del loguin
                                    }
                                ),
                                //terminacion del foco Done
                                imeAction = ImeAction.Done,
                            )
                        }//Fin de la columna interna

                    }//fin de la columna central

                }//fin del surface


                //Agregamos el floatingActionButton
                FloatingActionButton(
                    modifier = Modifier
                        .size(72.dp)
                        .constrainAs(fab) {
                            //alineamos el control en la parte superior del surface
                            top.linkTo(surface.top, margin = (-36).dp)
                            //alineamos el otro control en la parte inferior
                            end.linkTo(surface.end, margin = 36.dp)
                        },
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = { /*TODO*/ })
                {
                    Icon(
                        modifier = Modifier.size(72.dp),
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Boton de avanzar",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
