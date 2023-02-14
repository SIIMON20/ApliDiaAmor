package com.example.aplidiaamor.presentacion


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aplidiaamor.R

@Composable
fun LoginScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ){
        Image(painter = painterResource(id = R.drawable.clash),
            contentDescription = "Imagen del logo",
            contentScale = ContentScale.Inside
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ){
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                color = Color.White,
                shape = RoundedCornerShape(
                    topStartPercent = 8,
                    topEndPercent = 8
                )
            ){
                //Boton de input y de password
            }
            //Agregamos el floatingActionButton
            FloatingActionButton(
                modifier = Modifier.size(72.dp),
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