package codes.app006

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import codes.app006.ui.theme.App006Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App006Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun App() {
    ScreenCard(0, modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun App1() {
    ScreenCard(1, modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun App2() {
    ScreenCard(2, modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun App3() {
    ScreenCard(3, modifier = Modifier)
}

@Composable
fun ScreenCard(step: Int = 0, modifier: Modifier = Modifier) {
    // 0,1,2,3
    var step by remember { mutableIntStateOf(step) }
    var count by remember { mutableIntStateOf(0) }
    val imageResource = when(step){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val textResource = when(step){
        0 -> R.string.str11
        1 -> R.string.str12
        2 -> R.string.str13
        else -> R.string.str14
    }
    val descriptionResource = when(step){
        0 -> R.string.str21
        1 -> R.string.str22
        2 -> R.string.str23
        else -> R.string.str24
    }
    val handler = when(step){
        0, 2, 3 -> ({
            step = (step + 1) % 4
        })
        else -> ({
            if (count == 0) { // 先设定需要挤压的次数
                count = (2..4).random()
            }

            count--; // 挤压

            if (count == 0) { // 跳到下一步
                step = (step + 1) % 4
            }
        })
    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = stringResource(id = descriptionResource),
            modifier = Modifier
                .background(color = Color(202, 234, 212), shape = RoundedCornerShape(24.dp))
                .padding(32.dp)
                .clickable(onClick = handler)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(id = textResource),
            fontSize = 18.sp
        )
        Text(
            text = "DEBUG=> step: $step, count: $count"
        )
    }
}