import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.GenericFontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.opium.Navigation.ROUTE_BOOKING_SCREEN
import com.example.opium.Navigation.ROUTE_HOMING_SCREEN
import com.example.opium.Navigation.ROUTE_LOGIN_SCREEN
import com.example.opium.Navigation.ROUTE_REGISTER_SCREEN
import com.example.opium.R
import com.example.opium.ui.theme.OpiumTheme



@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.slide_13),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )



        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .border(width = 2.dp, color = Color.Black)
        ) {


            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Welcome Guests",
                color = Color.Magenta,
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 80.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(300.dp))
            Button(
                onClick = { navController.navigate(ROUTE_HOMING_SCREEN) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = "Get Started"
                )
            }
            Spacer(modifier = Modifier.height(40.dp))

            }
        }
    }

@Composable
fun <TextUnit> TextComponent(value: String, sp: TextUnit, white: Color, fontFamily: GenericFontFamily, extraBold: FontWeight, center: TextAlign) {

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen( rememberNavController())
}