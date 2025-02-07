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

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.view.Display.Mode
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
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
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.res.stringResource


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
fun MyApp(modifier: Modifier = Modifier) {

    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    var expanded by rememberSaveable { mutableStateOf(false) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }
}

@Composable
fun OnboardingScreen(
    onContinueClicked: () -> Unit,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier
                .padding(vertical = 24.dp),
            onClick = onContinueClicked
        ) {
            Text("Continue")
        }
    }

}
@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    Modul11Theme {
        OnboardingScreen(onContinueClicked = {})
    }
}


//@Composable
//private fun Greeting(name: String, modifier: Modifier = Modifier) {
//
//    var expanded by rememberSaveable { mutableStateOf(false) }
//
//    val extraPadding by animateDpAsState(
//        if (expanded) 48.dp else 0.dp,
//        animationSpec = spring(
//            dampingRatio = Spring.DampingRatioMediumBouncy,
//            stiffness = Spring.StiffnessLow
//        )
//    )
//    Surface(
//        color = MaterialTheme.colorScheme.primary,
//        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//    ) {
//        Row(modifier = Modifier.padding(24.dp)) {
//            Column(modifier = Modifier
//                .weight(1f)
//                .padding(bottom = extraPadding.coerceAtLeast(0.dp))
//            ) {
//                Text(text = "Rat dance 🧀🐀" , fontWeight = FontWeight.ExtraBold)
//                Text(text = "i love cheese", fontSize = 12.sp)
//                Text(
//                    text = name,
//                    style = MaterialTheme.typography.headlineMedium.copy(
//                        fontWeight = FontWeight.ExtraBold
//                    )
//                )
//            }
//
//            IconButton(onClick = { expanded = !expanded }) {
//                Icon(
//                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
//                    contentDescription = if (expanded) "Show less" else "Show more"
//                )
//            }
//
//        }
//    }
//}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "Rat dance 🧀🐀" , fontWeight = FontWeight.ExtraBold)
            Text(text = "i love cheese", fontSize = 12.sp)
            Text(
                text = name, style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color gyatt lazy, " +
                            "padding theme skibidi, sed do bouncy. ").repeat(4),
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }
            )
        }
    }
}

@Composable
private fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(1000) { "$it" }
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = UI_MODE_NIGHT_YES,
    name = "GreetingPreviewDark"
)

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
    Modul11Theme {
        Greetings()
    }
}
@Preview
@Composable
fun MyAppPreview() {
    Modul11Theme {
        MyApp(Modifier.fillMaxSize())
    }
}


@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    Modul11Theme {
        MyApp(Modifier.fillMaxSize())
    }
}


