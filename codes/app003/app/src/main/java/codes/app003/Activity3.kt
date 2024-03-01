package codes.app003

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import codes.app003.ui.theme.App003Theme

class Activity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App003Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1F)) {
            ComposableInforCard(
                title = stringResource(id = R.string.str31),
                description = stringResource(id = R.string.str32),
                backgroundColor = colorResource(id = R.color.color31),
                modifier = Modifier.weight(1F)
            )
            ComposableInforCard(
                title = stringResource(id = R.string.str33),
                description = stringResource(id = R.string.str34),
                backgroundColor = colorResource(id = R.color.color32),
                modifier = Modifier.weight(1F)
            )
        }
        Row(Modifier.weight(1F)) {
            ComposableInforCard(
                title = stringResource(id = R.string.str35),
                description = stringResource(id = R.string.str36),
                backgroundColor = colorResource(id = R.color.color33),
                modifier = Modifier.weight(1F)
            )
            ComposableInforCard(
                title = stringResource(id = R.string.str37),
                description = stringResource(id = R.string.str38),
                backgroundColor = colorResource(id = R.color.color34),
                modifier = Modifier.weight(1F)
            )
        }
    }
}

@Composable
fun ComposableInforCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Activity3Preview() {
    App003Theme {
        ComposeQuadrantApp()
    }
}