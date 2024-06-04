package com.example.android.mycoffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.VerticalAlignmentLine
import com.example.android.mycoffeeapp.ui.theme.MyCoffeeAppTheme
import kotlinx.coroutines.selects.select

data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {


            MyCoffeeAppTheme {
//                MainPage()
                BottomBar()
            }
        }
    }
}

@Composable
fun LAzyColumn(){

}
@Composable
fun ColumnInput(){

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(){
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


    val items = listOf(
        BottomNavItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false,
            badgeCount = 2
        ),
        BottomNavItem(
            title = "Account",
            selectedIcon = Icons.Filled.AccountCircle,
            unselectedIcon = Icons.Outlined.AccountCircle,
            hasNews = true,
        ),
    )


Surface(
// modifier = Modifier.fillMaxSize() ,//        MainPage()

    color = MaterialTheme.colorScheme.background
){
    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex ==index ,
                        onClick = {
                            selectedItemIndex = index
//                            navController.navigate(item.title)  //i need to add the place to go to if they click on items
                        },
                        label = {
                                Text(text = item.title)
                        },
                        icon = { BadgedBox(
                            badge ={
                                if(item.badgeCount != null) {
                                    Badge{
                                        Text(text = item.badgeCount.toString())
                                    }
                                }else if (item.hasNews){
                                    Badge()
                                }
                            }
                        ) {Icon(
                            imageVector = if(index ==selectedItemIndex){
                                item.selectedIcon
                            }else item.unselectedIcon,
                            contentDescription = item.title
                        )

                        }
                        }
                    )
                }
            }
        }
    ) {
        MainPage()


    }
}
}
@Composable
fun Settngs(){
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = "This is Settings Page")
    }
}


@Composable
fun MainPage(){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(text = "First Cup")
                Text(text = " Test Good")
            }


        }

    }

}