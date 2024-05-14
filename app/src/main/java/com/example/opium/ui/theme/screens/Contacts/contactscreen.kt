package com.example.opium.ui.theme.screens.Contacts

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.opium.Navigation.ROUTE_BOOKING_SCREEN
import com.example.opium.Navigation.ROUTE_CONTACT_SCREEN
import com.example.opium.R
import com.example.opium.ui.theme.screens.Bookings.ListAppear
import com.example.opium.ui.theme.screens.Bookings.Rooms
import com.example.opium.ui.theme.screens.Bookings.RoomsList
import com.example.opium.ui.theme.screens.Home.NavController as NavController1

@Composable
fun RoomScreen(navController: NavHostController){
    Column {
          TopBar()
          BookingList(roomsList , navController )
          BottomAppBarWork()
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    RoomScreen(rememberNavController())
}
@Composable
fun BottomAppBarWork() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "search")

                    }
                    Spacer(modifier = Modifier.width(40.dp))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.FavoriteBorder,
                            contentDescription = "Localized description",
                        )
                    }

                    Spacer(modifier = Modifier.width(40.dp))
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.MailOutline,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.AccountCircle, "Localized description")
                    }
                }
            )
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = ""
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){

    val context = LocalContext.current.applicationContext
    TopAppBar(title = {Text(text = "Opium", fontFamily = FontFamily.Cursive, fontSize = 50.sp, color = Color.Magenta,
        fontWeight = FontWeight.Bold)},
        navigationIcon ={
            IconButton(onClick = {  }) {
                Icon(imageVector = Icons.Filled.Home, contentDescription ="Home", tint = Color.Magenta )

            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black ,
            titleContentColor = Color.Black ,
            navigationIconContentColor = Color.Magenta
        ),
        actions = {
            IconButton(onClick = { Toast.makeText(context,"Notifications will appear here", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "notification", tint = Color.DarkGray)
            }
//            IconButton(onClick = {Toast.makeText(context,"You can share using",Toast.LENGTH_SHORT).show()}) {
//                Icon(imageVector = Icons.Filled.Share, contentDescription = "Share")
//            }
            IconButton(onClick = { Toast.makeText(context,"Choose from the given options", Toast.LENGTH_SHORT).show()}) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        }

    )

}
@Composable
fun BookingList(roomsList: List<Rooms>, navController: NavHostController) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 18.dp),
        modifier = Modifier.background(Color.White)
    ) {
        items(roomsList) { rooms ->
            ContactScreen( model = rooms,navController)
        }
    }
}


@Composable
fun ContactScreen(model: Rooms, navController: NavHostController){
        Card(shape = MaterialTheme.shapes.medium ,
            modifier = Modifier
                .size(400.dp, 400.dp)
                .padding(10.dp),
        ) {
            Column(modifier = Modifier.clickable {}) {
                Image(painter = painterResource(id = model.image ),
                    contentDescription = model.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(400.dp, 300.dp)
                        //.padding(5.dp)
                        .background(Color.Cyan)
                )
                Row {
                    Text(text = model.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black)
                    Spacer(modifier = Modifier.width(100.dp))

                    Button(onClick = {navController.navigate(ROUTE_BOOKING_SCREEN)},
                        colors = ButtonDefaults.buttonColors(Color.Black)){
                        Text(text = model.button, fontSize = 55.sp
                        )
                    }

                }
                Text(text = model.price,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }
        }
    }
data class Rooms(val name: String,val image: Int,val price: String,val button:String)
private val roomsList by lazy {
    listOf(
        Rooms("Contains a Bed for two,a hottub,and a flat screen tv ", R.drawable.slide_17,"2500ksh","Book"),
        Rooms("Has two beds,a hottub and a flat screen", R.drawable.slide_18,"3000ksh","Book"),
        Rooms("Has two beds,modern showers and a flat screen tv", R.drawable.slide_19,"3500ksh","Book "),
        Rooms("Accomodates one person with one bed,showers,and a flat screen tv", R.drawable.slide_20,"3000ksh","Book"),
        Rooms("Has two large beds,hottub,and flat screen tv", R.drawable.slide_21,"3500ksh","Book"),)}


