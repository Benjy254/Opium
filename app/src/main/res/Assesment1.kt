import androidx.activity.ComponentActivity

class Assesment1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Androidproject1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Signup()

                }
            }
        }
    }
}

@Preview
@Composable
fun Signup() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.slide_5),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }


    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .border(width = 2.dp, color = Color.Black)
    ) {

        TextComponent(
            value = "Wanderly",
            55.sp,
            Color.White,
            FontFamily.Cursive,
            FontWeight.ExtraBold,
            TextAlign.Center,

        )
        Spacer(modifier = Modifier.height(30.dp))
        TextComponent(
            value = "Your Ultimate Companion for Seamless" +
                    "Travel Experiences",
            12.sp, Color.White,
            FontFamily.Monospace,
            FontWeight.W100,
            TextAlign.Center,

        )
         Spacer(modifier = Modifier.height(370.dp))
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Sign in with phone number"
            )
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.padding(15.dp),
                text = "Sign in with apple"
            )
        }
        TextComponent(
            value = "Don't have an account? Sign up here",
            12.sp, Color.White,
            FontFamily.Monospace,
            FontWeight.W100,
            TextAlign.Center,

        )
        Spacer(modifier = Modifier.height(50.dp))
        TextComponent(
            value = "By creating or signing in you agree to our Terms and Policies",
            5.sp,
            Color.White,
            FontFamily.Monospace,
            FontWeight.W100,
            TextAlign.Center,

        )
    }





}

