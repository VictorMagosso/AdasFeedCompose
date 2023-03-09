package com.victor.adasfeedcompose.ui.feed

import android.os.Parcelable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.google.gson.Gson
import com.victor.adasfeedcompose.ui.feed.component.HeaderComponent
import com.victor.adasfeedcompose.ui.feed.component.PostsComponent
import com.victor.adasfeedcompose.ui.feed.component.StoriesComponent
import kotlinx.parcelize.Parcelize

//@Parcelize
data class User(val name: String, val nickname: String)

@Composable
fun FeedScreen(onNavigateToProfileClick: (String) -> Unit) {
//    val lifecycle = LocalLifecycleOwner.current
//
//    when (lifecycle.lifecycle.currentState) {
//        Lifecycle.State.DESTROYED -> TODO()
//        Lifecycle.State.INITIALIZED -> TODO()
//        Lifecycle.State.CREATED -> TODO()
//        Lifecycle.State.STARTED -> TODO()
//        Lifecycle.State.RESUMED -> TODO()
//    }

    val userFromApi = User("Victor", "@victormagosso")
    val isLikedApi = true
    Box(contentAlignment = Alignment.BottomCenter) {

        LazyColumn {
            item { HeaderComponent(userFromApi) }
            item { StoriesComponent() }
            PostsComponent() { isLiked ->
                updateLikedPost(isLiked)
            }
        }

        val userToJson = Gson().toJson(userFromApi)

        Button(onClick = { onNavigateToProfileClick(userToJson) }) {
            Text(text = "Ir para perfil")
        }
    }
}

fun updateLikedPost(isLike: Boolean) {

}