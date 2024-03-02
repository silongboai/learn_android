package codes.app004

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import codes.app004.ui.theme.App004Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App004Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //
                }
            }
        }
    }
}

@Composable
fun IntroductionPart() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.user_name),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        )
        Text(
            text = stringResource(id = R.string.user_profession),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Magenta
        )
    }
}

@Composable
fun ContactPart() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start
        ){
            Row {
                Icon(imageVector = Icons.Rounded.Phone, contentDescription = null)
                Text(text = stringResource(id = R.string.user_phone))
            }

            Row {
                Icon(imageVector = Icons.Rounded.Share, contentDescription = null)
                Text(text = stringResource(id = R.string.user_social))
            }

            Row {
                Icon(imageVector = Icons.Rounded.Email, contentDescription = null)
                Text(text = stringResource(id = R.string.user_email))
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .weight(3F)
        ) {
            IntroductionPart()
        }
        Row(
            modifier = Modifier
                .weight(1F)
        ) {
            ContactPart()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App004Theme {
        BusinessCard()
    }
}