import android.widget.ImageButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlindemo.JetPackComposed.Activity.BottomSheet
import com.example.kotlindemo.JetPackComposed.ui.theme.Shapes
import com.example.kotlindemo.JetPackComposed.ui.theme.md_theme_light_surfaceTint
import com.example.kotlindemo.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MatrialDesignDemos() {


    Column(modifier = Modifier.fillMaxSize()) {
        var showMessage by remember { mutableStateOf(false) }
        Button(
            onClick = {
                showMessage = true
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(md_theme_light_surfaceTint),
            shape = Shapes.extraSmall

        ) {
            Text("Alert DialogBox")
        }
        if (showMessage) {
            AlertDialogComponent(onDismiss = { showMessage = false })
        }


        //Assistenship
        AssistshipView()

        //Bedge
        BedgeView()

        Spacer(modifier = Modifier.height(10.dp))
//        Navigation
        NavigationView()

        Spacer(modifier = Modifier.height(10.dp))

        var showSheet by remember { mutableStateOf(false) }

        if (showSheet) {
            BottomSheet() {
                showSheet = false
            }
        }

        Button(onClick = {
            showSheet = true
        }) {
            Text(text = "Show BottomSheet")
        }

        //Costom Button
        CoustomButton()

        CardView1()

        //CenterAlignedTopAppBar
        TopBarView()

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarView() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(text = "Center Topbar", maxLines = 1, overflow = TextOverflow.Ellipsis)
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "")
                }

            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "")
                }
            }
        )
    },
    content = {
            innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
//            val list = (0..75).map { it.toString() }
//            items(count = list.size) {
//                Text(
//                    text = list[it],
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 16.dp)
//                )
//            }
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardView1() {
    Column(Modifier.fillMaxWidth()) {

        Spacer(modifier = Modifier.size(10.dp))
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .size(width = 250.dp, height = 180.dp)
                .align(CenterHorizontally)
        ) {

            Column(Modifier.padding(10.dp)) {

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(35.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color.Gray)


                    ) {
                        // Content inside the rounded shape
                        Text(
                            text = "H",
                            modifier = Modifier.align(Alignment.Center),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
//                    Icon(
//                            Icons.Filled.Star, contentDescription = "", Modifier.align(
//                                Alignment.Center
//                            )
//                        )
                    }
                    Column(Modifier.fillMaxWidth()) {
                        Icon(
                            Icons.Filled.Star,
                            contentDescription = "",
                            Modifier
                                .align(Alignment.End)
                                .size(15.dp)
                        )
                    }


                }

                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "Title", fontSize = 25.sp)
                Text(text = "SubTitle", fontSize = 15.sp)
                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = stringResource(R.string.dummy_text),
                    Modifier.fillMaxWidth(),
                    fontSize = 10.sp,
                    maxLines = 3,
                    lineHeight = 13.sp
                )

            }

        }
    }

}


@Composable
fun CoustomButton() {
    Column(modifier = Modifier.fillMaxWidth()) {

        Button(
            onClick = { /*TODO*/ },
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding,

            elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 20.dp),
            modifier = Modifier.align(CenterHorizontally),
            border = BorderStroke(2.dp, color = Color.LightGray)

        ) {

            Icon(
                Icons.Filled.Favorite,
                contentDescription = "",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Like")
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BottomshitView(onDismiss: () -> Unit) {
//
//    BottomSheetScaffold(
//        sheetPeekHeight = 128.dp,
//        sheetContent = {
//            Box(
//                Modifier
//                    .fillMaxWidth()
//                    .height(128.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text("Swipe up to expand sheet")
//            }
//            Column(
//                Modifier
//                    .fillMaxWidth()
//                    .padding(64.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text("Sheet content")
//                Spacer(Modifier.height(20.dp))
//                Button(
//                    onClick = {
//                        onDismiss()
//                    }
//                ) {
//                    Text( "Click to collapse sheet" )
//                }
//            }
//        }) {
//        Column(
//            Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Scaffold Content")
//        }
////            innerPadding ->
////        Box(Modifier.padding(innerPadding)) {
////            Text("Scaffold Content")
////        }
//    }
//
//
//}

@Composable
fun BottomSheetContent(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bottom Sheet Content")
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onDismiss
        ) {
            Text("Dismiss Bottom Sheet")
        }
    }
}

@Composable
fun AssistshipView() {
    Column(modifier = Modifier.fillMaxWidth()) {


        Text(text = "2. Assistchip")
        AssistChip(onClick = { /*TODO*/ }, label = { Text(text = "Assist Chip") }, leadingIcon = {
            Icon(
                Icons.Filled.Star,
                contentDescription = "",
                Modifier.size(AssistChipDefaults.IconSize)
            )
        }, modifier = Modifier.align(CenterHorizontally)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BedgeView() {
    Text(text = "3. Bedge")
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            BadgedBox(badge = {
                Badge {
                    val badgeNumber = "8"
                    Text(badgeNumber, modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber new notifications"
                    })

                }

            }) {
                Icon(
                    Icons.Filled.Star, contentDescription = ""
                )

            }
        })

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationView() {
    BottomAppBar(actions = {
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(Icons.Filled.Check, contentDescription = "Localized description")
        }
        IconButton(onClick = { /* doSomething() */ }) {


            Icon(
                Icons.Filled.Edit,
                contentDescription = "Localized description",
            )
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(
                Icons.Filled.Star,
                contentDescription = "Localized description",
            )
        }
        IconButton(onClick = { /* doSomething() */ }) {
            Icon(
                Icons.Filled.Settings,
                contentDescription = "Localized description",
            )
        }

        IconButton(onClick = { /* doSomething() */ }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = "Localized description",
            )
        }
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            BadgedBox(badge = {
                Badge {
                    val badgeNumber = "8"
                    Text(badgeNumber, modifier = Modifier.semantics {
                        contentDescription = "$badgeNumber new notifications"
                    })

                }

            }) {
                Icon(
                    Icons.Filled.Star, contentDescription = ""
                )

            }
        })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { /* do something */ },
            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
        ) {
            Icon(Icons.Filled.Add, "Localized description")
        }
    })
}

@Composable
fun AlertDialogComponent(onDismiss: () -> Unit) {

    AlertDialog(onDismissRequest = {

        onDismiss()
    }, icon = { Icon(Icons.Filled.Favorite, contentDescription = null) }, title = {
        Text(text = "Title")
    }, text = {
        Text(
            "This area typically contains the supportive text " + "which presents the details regarding the Dialog's purpose."
        )
    }, confirmButton = {
        TextButton(onClick = {
            onDismiss()
        }) {
            Text("Confirm")
        }
    }, dismissButton = {
        TextButton(onClick = {
            onDismiss()
        }) {
            Text("Dismiss")
        }
    })

}

