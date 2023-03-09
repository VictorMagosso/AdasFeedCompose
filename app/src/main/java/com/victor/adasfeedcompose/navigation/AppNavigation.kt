package com.victor.adasfeedcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.victor.adasfeedcompose.ui.feed.FeedScreen
import com.victor.adasfeedcompose.ui.feed.User
import com.victor.adasfeedcompose.ui.profile.ProfileScreen

object Routes {
    const val FEED = "feed"
    const val PROFILE = "profile"
}

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.FEED) {
        composable(Routes.FEED) { backstackEntry ->
//            backstackEntry.arguments?.putParcelable("user", user)
            FeedScreen { user ->
                navController.navigate("${Routes.PROFILE}/$user")
            }
        }

        composable(
            route = "${Routes.PROFILE}/{user}",
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) { backstackEntry ->
            backstackEntry.arguments?.getString("user")?.let { userJson ->
                val user = Gson().fromJson(userJson, User::class.java)
                ProfileScreen(user) {
                    navController.popBackStack()
                }
            }
        }
    }
}