package com.example.tooglebutton.utils

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.tooglebutton.R

@Composable
fun Theme(
    height:Dp=50.dp,
    lightIcon: Painter = painterResource(id = R.drawable.brightness),
    darkIcon:Painter = painterResource(id = R.drawable.dark_mode),
    isDark:Boolean=true,
    backgroundColorDark:Color,
    backgroundColorLight:Color,
    toogleColorDark:Color,
    toogleColorLight:Color,
    darkBorderColor:Color,
    lightBorderColor:Color,
    iconTintDark:Color,
    iconTintLight:Color,
    onClick:()->Unit
)
{
    val offset by animateDpAsState(targetValue =if(isDark) 0.dp else height, animationSpec= tween(300), label = "")
    val width:Dp=height*2
    val backgroundColor=if (isDark) backgroundColorDark else backgroundColorLight
    val toogleColor=if (isDark) toogleColorDark else toogleColorLight
    Box(modifier = Modifier
           .clip(CircleShape)
           .background(backgroundColor)
           .width(width)
           .height(height)
           .clickable { onClick() },)
       {
           Box(modifier = Modifier
               .background(backgroundColor)
               .size(width)
               .offset(x = offset)){
               //the content will be offset
               Box(modifier = Modifier
                   .clip(CircleShape)
                   .background(backgroundColor)
                   .size(height)){
                           Box(modifier = Modifier
                               .background(toogleColor)
                               .size(height))
               }
           }
           Row(verticalAlignment=Alignment.CenterVertically, horizontalArrangement=Arrangement.SpaceAround,
               modifier= Modifier.size(width).border(BorderStroke(2.dp, if(isDark){darkBorderColor}else lightBorderColor), shape = CircleShape)

           ) {
               Icon(
                   painter = if(!isDark) {darkIcon} else lightIcon,
                   contentDescription = "Icon",
                   tint = if(isDark) iconTintDark else iconTintLight,
                   modifier = Modifier.size((height/2)))
               Icon(
                   painter =if(isDark) {darkIcon} else lightIcon,
                   contentDescription = "Icon",
                   tint = if (isDark) iconTintDark else iconTintLight,
                   modifier = Modifier.size((height/2)))

           }
       }
}

