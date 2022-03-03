package com.spidey_children.barcelonaplayers.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.spidey_children.barcelonaplayers.BarcelonaViewModel
import com.spidey_children.barcelonaplayers.data.Detail
import com.spidey_children.barcelonaplayers.data.Player

@ExperimentalAnimationApi
@Composable
fun PlayerDetailScreen(
    viewModel: BarcelonaViewModel,
    navHostController: NavHostController,
    name: String
) {
    val playerInfo = viewModel.playerList.filter { it.name == name }
    val player = playerInfo[0]
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = player.name,
                        color = Color.White,
                        fontSize = 19.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        viewModel.showTopAndBottomBar = true
                        navHostController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            )
        }) {
        PlayerDetailContent(player = player, padding = it)
    }
}

@Composable
fun PlayerDetailContent(player: Player, padding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(
                text = "背番号",
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.h4.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
            Text(
                text = player.number.toInt().toString(),
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h4.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "ポジション",
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.h4.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
            Text(
                text = player.position,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h4.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = "詳細情報",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 32.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "身長",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
            Text(
                text = player.detail.height + "cm",
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "体重",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
            Text(
                text = player.detail.weight + "kg",
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "国籍",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
            Text(
                text = player.detail.country,
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Divider()
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "生年月日",
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h5.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f)
            )
            Text(
                text = player.detail.birth,
                fontSize = MaterialTheme.typography.h6.fontSize,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Center
            )
        }
        Text(
            text = "選手解説",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 32.dp)
        )
        Text(
            text = player.detail.content.toString().replace("\\n", "\n"),
            modifier = Modifier.padding(bottom = 16.dp).padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PlayerDetailContentPreview() {
    val player = Player(
        number = 55.0,
        name = "ピエール・エメリク・オーバメヤン",
        position = "FW",
        positionNum = 3.0,
        detail = Detail(
            height = "180",
            weight = "70",
            country = "ガボン",
            birth = "1999年10月30日",
            content = "1989年6月18日、ラヴァル（フランス・マイエンヌ）に生まれたピエール＝エメリク・オーバメヤンは、三つの国籍を持っているが、ガボン代表としてプレーしている。 32歳の選手は、複数のヨーロッパ諸国でプレーした経験がある。\n" +
                    "\n" +
                    "AC ミラン を含む複数のクラブをユース時から経験したオーバメヤンは、イタリアのクラブからのレンタルされ、2008/09年にフランスのディジョンで トップチームデビューを果たした。そこで多くのクラブチームの目を惹き、リール (2009/10)、 AS モナコ (2010/11) 、 サンテティエンヌ (2011/13)でプレーした。\n" +
                    "\n" +
                    "その次に扉を叩いたのは、ボルシアドルトムントであり、2013年から4年半を過ごし、 141ゴールを決めて貢献し、また、ブンデスリーガで 2017年には  31 ゴールをマークする記録を作った。\n" +
                    "\n" +
                    "2018 年の冬の移籍で、アーセナルへ移籍し、そこで4年間を過ごした。彼は 2019 年 22ゴールを決め、プレミアムリーグでの得点王となった。\n" +
                    "\n" +
                    "個人レベルでは、 2015年アフリカ年間最優秀選手、   2016年にブンデスリーガ最優秀選手としてのアワードを受けている。\n" +
                    "\n" +
                    "制覇してきた様々なチームタイトルの中には、サンテティエンヌとのフランスリーグカップ (2013)、ドルトムントでのドイツカップ (2017) 、アーセナルとの FAカップ(2020)がある。"
        )
    )
    PlayerDetailContent(padding = PaddingValues(4.dp), player = player)
}
