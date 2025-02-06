package id.ac.umn.modul1_1
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import id.ac.umn.modul1_1.ui.theme.Modul11Theme // Correct theme reference
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            Modul11Theme {
//                MyApp(modifier = Modifier.fillMaxSize())
//            }
////            Modul11Theme {
////                // A surface container using the 'background' color from the theme
////                Surface(
////                    modifier = Modifier.fillMaxSize(),
////                    color = MaterialTheme.colorScheme.background
////                ) {
////                    Greeting("Android")
////                }
////            }
//        }
//    }
//}
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = MaterialTheme.colorScheme.primary) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
//}
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview () {
//    Modul11Theme {
//        MyApp()
//    }
//}
//
////@Preview(showBackground = true)
////@Composable
////fun GreetingPreview() {
////    Modul11Theme { // Use the correct theme in preview
////        Greeting("Dane")
////    }
////}
//
//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Dane2")
//    }
//}

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.ac.umn.modul1_1.ui.theme.Modul11Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Modul11Theme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

//@Composable
//fun MyApp(modifier: Modifier = Modifier) {
//    Surface(
//        modifier = modifier,
//        color = MaterialTheme.colorScheme.background
//    ) {
//        Greeting("Android")
//    }
//}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Surface(color = MaterialTheme.colorScheme.primary) {
//        Text(
//            text = "Hello $name!",
//            modifier = modifier.padding(24.dp)
//        )
//    }
//}

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose")
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello ")
                Text(text = name)
            }
            ElevatedButton(
                onClick = { /* TODO */ }
            ) {
                Text("Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    Modul11Theme {
        MyApp()
    }
}


