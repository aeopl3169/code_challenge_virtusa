package com.shashi.shiva.codechallengevirtusa.ui.dashboard.compose

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shashi.shiva.codechallengevirtusa.R
import com.shashi.shiva.codechallengevirtusa.ui.theme.CodeChallengeVirtusaTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun DrawerCompose(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    totalLiqrCoin: String,
    userId: String,
    logout: (String) -> Unit,
) {


    Column(
        Modifier
            .testTag(stringResource(R.string.drawer_test_tag))
            .fillMaxSize()
            .background(MaterialTheme.colors.onSecondary)) {
        Box(contentAlignment = Alignment.Center) {


            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)) {

                Image(modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                    painter = painterResource(R.drawable.ic_baseline_person_24),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = "")
                Text(
                    text = userId,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.body1,
                )
                 Text(
                    text = "Total = "+totalLiqrCoin,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.onSecondary,
                    style = MaterialTheme.typography.body1,
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.dp_10)))

            }

        }

        Column(Modifier.padding(dimensionResource(R.dimen.dp_20))) {
            DrawerItem(R.drawable.ic_home,
                R.string.dashboard,
                {
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }

                })

            DrawerItem(R.drawable.ic_logout,
                R.string.logout,
                {
                    logout("logout")
                })


        }
    }

}


@Composable
fun DrawerItem(icon: Int, title: Int, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(dimensionResource(R.dimen.dp_60))
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically) {
        Image(modifier = Modifier
            .width(dimensionResource(R.dimen.dp_25))
            .height(dimensionResource(R.dimen.dp_25)),
            painter = painterResource(icon),
            contentDescription = "")
        Spacer(modifier = Modifier.width(dimensionResource(R.dimen.dp_15)))
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.h6,
        )

    }

    Divider(color = MaterialTheme.colors.primary)


}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun Preview() {
    CodeChallengeVirtusaTheme {
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
        val scope = rememberCoroutineScope()

        DrawerCompose(scope, scaffoldState,
            "23","123", {})
    }
}