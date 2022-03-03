package com.spidey_children.barcelonaplayers.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.data.Player

@Composable
fun PlayerScreen(viewModel: BarcelonaViewModel, navHostController: NavHostController) {
    var playerList by remember { mutableStateOf(viewModel.playerList) }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            contentPadding = PaddingValues(2.dp)
        ) {
            playerList = when (viewModel.sortPlayerListFlag) {
                1 -> {
                    playerList.sortedBy { it.number }
                }
                2 -> {
                    playerList.sortedBy { it.name }
                }
                else -> {
                    playerList
                        .sortedWith(compareBy<Player> { it.positionNum }.thenBy { it.number })
                }
            }
            items(playerList) {
                PlayerItem(
                    number = it.number.toInt().toString(),
                    name = it.name,
                    position = it.position,
                    navHostController = navHostController
                )
            }
        }
    }
}

@Composable
fun PlayerItem(
    number: String,
    name: String,
    position: String,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .clickable {
                navHostController.navigate(route = Screen.PlayerDetail.route + "/$name")
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(25)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = position,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Text(
                text = number,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 4.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                modifier = Modifier
                    .weight(5f)
                    .padding(start = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerItemPreview() {
    val navHostController = rememberNavController()
    PlayerItem(
        number = "25",
        name = "ピエール・エメリク・オーバメヤン",
        position = "FW",
        navHostController = navHostController
    )
}