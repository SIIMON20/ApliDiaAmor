package com.example.aplidiaamor.presentacion.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SocialMediaButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: ()->Unit,
    socialMediaColor: androidx.compose.ui.graphics.Color
){
    OutlinedButton(
        modifier = Modifier
            .width(280.dp)
            .height(50.dp),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.outlinedButtonColors
            (
            backgroundColor = androidx.compose.ui.graphics.Color.Transparent,
            contentColor = socialMediaColor
            ),
    ) {

    }
}