package com.victor.adasfeedcompose.ui.app

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.victor.adasfeedcompose.R

@Composable
fun ToolbarComponent(
    scrollBehavior: TopAppBarScrollBehavior,
) {
    MediumTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        scrollBehavior = scrollBehavior
    )
}