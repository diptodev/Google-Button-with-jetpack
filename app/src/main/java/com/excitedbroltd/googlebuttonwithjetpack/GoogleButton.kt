package com.excitedbroltd.googlebuttonwithjetpack

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun GoogleButton(
    image: Painter = painterResource(id = R.drawable.google_icon),
    onClicked: () -> Unit,

    ) {
    var isClicked by remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .clickable {
                isClicked = !isClicked
            },
        color = Color.LightGray
    ) {
        var name by remember {
            mutableStateOf("Sign up with google")
        }
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = 3f,
                        stiffness = Spring.StiffnessHigh
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

            ) {
            name = if (isClicked) "Creating account..." else "Sign up with google"

            Text(text = name)


            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                painter = image,
                contentDescription = "google",
                tint = Color.Unspecified,
                modifier = Modifier.width(25.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            if (isClicked) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp),
                    strokeWidth = 2.dp
                )
            }
            onClicked()
        }
    }
}

@Composable
@Preview
fun GoogleButtonPrev() {
    GoogleButton(onClicked = {})
}