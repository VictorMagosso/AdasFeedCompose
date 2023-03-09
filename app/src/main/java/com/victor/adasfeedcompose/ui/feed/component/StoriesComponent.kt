package com.victor.adasfeedcompose.ui.feed.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victor.adasfeedcompose.R.*
import com.victor.adasfeedcompose.ui.theme.AdasFeedComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoriesComponent(storiesList: List<Stories> = fakeStories()) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(storiesList) { stories ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(108.dp)
                    .height(134.dp)
                    .clickable {
                        println("Olá, sou ${stories.name}")
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Image(
                        painter = painterResource(id = stories.imageUser),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )

                    Row(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(7.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(23.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = stories.imageResource),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                        Column(modifier = Modifier.wrapContentSize()) {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 7.dp),
                                text = stories.name,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 14.sp
                            )
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 7.dp),
                                text = stories.postedTime,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontSize = 10.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun CardStoriesPreview() {
    val stories = Stories(
        "Jonas do Dark",
        "8 m",
        drawable.stories1,
        drawable.user5
    )
    AdasFeedComposeTheme {
        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .width(108.dp)
                .height(134.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = stories.imageResource),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )

                Row(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(7.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .size(23.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = stories.imageUser),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.wrapContentSize()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 7.dp),
                            text = stories.name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 14.sp
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 7.dp),
                            text = stories.postedTime,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = 10.sp
                        )
                    }
                }
            }
        }
    }
}

private fun fakeStories() = listOf(
    Stories(
        "Jonas do Dark",
        "8 m",
        drawable.user5,
        drawable.stories1
    ),
    Stories(
        "J.D.",
        "13 m",
        drawable.user4,
        drawable.stories2
    ),
    Stories(
        "São Silvestre",
        "15 m",
        drawable.user3,
        drawable.stories3
    ),
    Stories(
        "HH",
        "37 m",
        drawable.user2,
        drawable.stories4
    ),
)

data class Stories(
    val name: String,
    val postedTime: String,
    val imageResource: Int,
    val imageUser: Int
)