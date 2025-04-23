package com.example.fetchrewards.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.fetchrewards.R
import com.example.fetchrewards.api.HiringResponse
import com.example.fetchrewards.ui.theme.FetchRewardsTheme
import com.example.fetchrewards.viewmodels.HiringViewModel
import kotlinx.coroutines.launch

@Composable
fun HiringScreen(modifier: Modifier) {
    val viewModel: HiringViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val hiringList = uiState.hiringList
    when {
        uiState.isLoading -> EmptyState(
            modifier, stringResource(R.string.loading)
        )

        !uiState.errorMessage.isNullOrBlank() -> EmptyState(
            modifier,
            uiState.errorMessage.toString()
        )

        else ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = modifier.padding(10.dp)
            ) {
                Header()
                ScrollToTopList(hiringList)
            }
    }
}

/**
 * Empty Ui state used to display text
 * when it is fetching data or
 * when there is error with empty list
 * */
@Composable
private fun EmptyState(modifier: Modifier, message: String) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}

/**
 * used as static header for the list item
 * */
@Composable
fun Header() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {

        Text(
            text = stringResource(R.string.list_id),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = stringResource(R.string.name),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )
        Text(
            text = stringResource(R.string.id),
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)

        )
    }
}

/**
 * List with scroll to top button when list scrolled up
 * */
@Composable
private fun ScrollToTopList(hiringList: List<HiringResponse>) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showScrollToTop by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = listState
        ) {
            items(items = hiringList) { item ->
                ListItem(item)
            }
        }
        if (showScrollToTop) {
            SmallFloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Icon(
                    Icons.Default.KeyboardArrowUp,
                    contentDescription = stringResource(R.string.scroll_to_top)
                )
            }
        }
    }
}


@Composable
fun ListItem(item: HiringResponse) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .height(100.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = item.listId.toString()
            )
            Text(
                text = item.name
            )
            Text(
                text = item.id.toString()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FetchRewardsTheme {
        Header()
    }
}

@Preview(showBackground = true)
@Composable
fun HiringScreenPreview() {
    FetchRewardsTheme {
        HiringScreen(modifier = Modifier)
    }
}