package com.excitedbroltd.googlebuttonwithjetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.excitedbroltd.googlebuttonwithjetpack.ui.theme.GoogleButtonWithJetpackTheme

class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                myPreview()
            }
        }
    }

    @Composable
    @Preview(showSystemUi = true)
    fun myPreview() {
        GoogleButtonWithJetpackTheme {
            GoogleButton(onClicked = { Log.d(TAG, "onCreate: Button clicked") })
        }
    }
}