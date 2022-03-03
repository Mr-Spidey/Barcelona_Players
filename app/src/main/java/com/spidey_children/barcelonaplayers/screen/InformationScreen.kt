package com.spidey_children.barcelonaplayers.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InformationScreen(padding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "本アプリはFCバルセロナの選手情報を見るための非公式アプリです。\n\n" +
                    "選手タブでは選手の一覧を見ることができます。選手一覧はポジション順、背番号順、五十音順" +
                    "に並べ替えることができます。選手をタップすると、さらに詳細な情報を表示することができます。",
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InformationScreenPreview() {
    InformationScreen(padding = PaddingValues(4.dp))
}