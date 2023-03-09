package com.victor.adasfeedcompose.ui.feed.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.victor.adasfeedcompose.R

data class Post(
    val userName: String,
    val postMessage: String,
    val userImage: Int,
    val postImage: Int,
    val isLiked: Boolean = false,
    val isFavorite: Boolean = false,
)


fun LazyListScope.PostsComponent(
    posts: List<Post> = fakePosts(),
    isLikedChanged: (isLiked: Boolean) -> Unit
) {
    items(posts) { post ->
        // sempre alterar através de lambdas passando por parâmetros
        var isLiked by remember { mutableStateOf(post.isLiked) }

        Box(modifier = Modifier.fillMaxSize()) {
            Column {
                Row {
                    Image(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = post.userImage),
                        contentDescription = null
                    )
                    Text(text = post.userName)
                }
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(198.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = post.postImage),
                    contentDescription = null
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {

                    IconToggleButton(checked = post.isLiked, onCheckedChange = { isChecked ->
                        isLikedChanged(isChecked)
                        isLiked = isChecked
                    }) {
                        if (!isLiked) {
                            Icon(
                                tint = Color.White,
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.liked1),
                                contentDescription = "Dois cliques para gostar deste post"
                            )
                        } else {
                            Icon(
                                tint = Color.Red,
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.liked_fill),
                                contentDescription = "Dois cliques para desmarcar este post como \"gostei\""
                            )
                        }
                    }

                    Text(text = post.postMessage)

                    var isFavorite by remember { mutableStateOf(post.isFavorite) }

                    IconToggleButton(checked = post.isFavorite, onCheckedChange = {
                        isFavorite = !isFavorite
                    }) {
                        if (!isFavorite) {
                            Icon(
                                tint = Color.White,
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.favorite),
                                contentDescription = "Dois cliques para favoritar este post"
                            )
                        } else {
                            Icon(
                                tint = Color.Yellow,
                                modifier = Modifier.size(20.dp),
                                painter = painterResource(id = R.drawable.favorite_fill),
                                contentDescription = "Dois cliques para desfavoritar este post"
                            )
                        }
                    }
                }
            }
        }
    }
}


private fun fakePosts() = listOf(
    Post(
        "Victor",
        "Hoje foi dia de muita gravação",
        R.drawable.user1,
        R.drawable.paisagem_post,
        true,
        true
    ),
    Post(
        "Matheus S.",
        "Sextooooou em Marte! Aqui não",
        R.drawable.user2,
        R.drawable.universe_image,
        true,
        true
    ),
    Post(
        "Rosangela M.",
        "Só festa :D",
        R.drawable.user3,
        R.drawable.stories4,
        false,
        true
    ),
    Post(
        "Jean C. A.",
        "Gratidão por essa semana",
        R.drawable.user4,
        R.drawable.stories3,
        false,
        false
    )
)