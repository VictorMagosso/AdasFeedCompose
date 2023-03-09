package com.victor.adasfeedcompose.ui.feed.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.victor.adasfeedcompose.ui.feed.User
import com.victor.adasfeedcompose.ui.theme.AdasFeedComposeTheme

@Composable
fun HeaderComponent(
    user: User,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(text = "Olá,")

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = user.name)
            Text(text = user.nickname)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderComponentPreview() {
    AdasFeedComposeTheme {
        HeaderComponent(User("victor", "@victormagosso"))
    }
}