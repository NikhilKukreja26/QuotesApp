package dev.nikhilkukreja.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import dev.nikhilkukreja.quotesapp.ui.theme.QuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()

            val navItemList: List<NavItem> = listOf<NavItem>(
                NavItem(label = "Home", route = DestinationsRoutes.Home.route,  icon = Icons.Default.Home),
                NavItem(label = "Explore", route = DestinationsRoutes.Explore.route, icon = Icons.Default.Explore),
                NavItem(label = "Saved", route = DestinationsRoutes.Saved.route, icon = Icons.Default.Favorite),
                )

            var selectedIndex by remember { mutableIntStateOf(0) }
            QuotesAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar() {
                            navItemList.forEachIndexed { index, navItem ->
                                NavigationBarItem(
                                    selected = selectedIndex == index,
                                    onClick = {
                                        selectedIndex = index
                                        navHostController.navigate(navItem.route)


                                    },
                                    icon = {
                                        Icon(
                                            imageVector = navItem.icon,
                                            contentDescription = navItem.label
                                        )
                                    },
                                    label = {
                                        Text(text = navItem.label)
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    AppNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = navHostController
                    )

                }
            }
        }
    }
}


