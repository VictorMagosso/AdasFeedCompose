package com.victor.adasfeedcompose

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.victor.adasfeedcompose.navigation.AppNavigation
import com.victor.adasfeedcompose.ui.feed.FeedScreen
import com.victor.adasfeedcompose.ui.theme.AdasFeedComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdasFeedComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AppNavigation(navController = rememberNavController())
//                    Column() {
//                    }
//
//                    Row(modifier = Modifier.padding(bottom = 6.dp)) {
//                    }
//
//                    Box(modifier = Modifier
//                        .fillMaxSize()
//                        .fillMaxWidth()) {
//
//                    }
//                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column {
        Text(
            text = "$name!",
            modifier = Modifier
                .padding(2.dp)
                .background(Color.Red)
        )
        Text(text = "Ola estou abaixo")
        Text(text = "Ola estou abaixo")
        Text(text = "Ola estou abaixo")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdasFeedComposeTheme {
        Greeting("Android")
    }
}

//class ProfileFragment() : Fragment() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater?,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater?.inflate(R.layout.fragment_profile, container, false)
//
//        view?.findViewById<ComposeView>(R.id.composeViewFragment).setContent {
//
//        }
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }
//}