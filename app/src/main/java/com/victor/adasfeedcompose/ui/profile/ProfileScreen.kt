package com.victor.adasfeedcompose.ui.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.victor.adasfeedcompose.ui.feed.User

@Composable
fun ProfileScreen(user: User, onNavigateToFeedClick: () -> Unit) {
    Column {
        Text(text = user.name)
        Button(onClick = { onNavigateToFeedClick() }) {
            Text(text = "Voltar para o feed")
        }
    }
}