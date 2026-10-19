package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.test.ui.theme.TestTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue





class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                var fullName by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>("Sato", "Misaki", "Ilham"))
                }
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = Color.Yellow
                ) { innerPadding ->
                    Box (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            OutlinedTitle()
                            Row(modifier = Modifier.fillMaxWidth()) {
                                OutlinedTextField(
                                    value = fullName,
                                    onValueChange = { text ->
                                        fullName = text
                                    },
                                    label = { Text(text = "Name") },
                                    modifier = Modifier.weight(1f)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Button(onClick = {
                                    if (fullName.isNotBlank()) {
                                        names = names + fullName
                                        fullName = ""
                                    }},
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFFAA36)
                                    )
                                ) {
                                    Text(text = "Join")
                                }
                            }
                            currentMember()
                            LazyColumn{
                                items(names) { currentName ->
                                    Text(text = currentName,
                                        color = Color.Black,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }
                            }
                        }
                        Mascot(
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
                    }
                }
            }
        }
    }
}



@Composable
fun OutlinedTitle(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.wrapContentSize()) {
        Text(
            text = "NHK Member Registration",
            color = Color(0xFFD97919),
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            style = TextStyle(
                drawStyle = Stroke(width = 18f)
            ),
        )
        Text(
            text = "NHK Member Registration",
            color = Color(0xFFFFAA36),
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
            style = TextStyle(
                drawStyle = Stroke(width = 10f)
            ),
        )
        Text(
            text = "NHK Member Registration",
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Black,
        )
    }
}

@Composable
fun currentMember(){
        Box(modifier = Modifier.wrapContentSize()) {
            Text(
                text = "Current Member",
                color = Color(0xFFD97919),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                style = TextStyle(
                    drawStyle = Stroke(width = 18f)
                ),
            )
            Text(
                text = "Current Member",
                color = Color(0xFFFFAA36),
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                style = TextStyle(
                    drawStyle = Stroke(width = 10f)
                ),
            )
            Text(
                text = "Current Member",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
            )
        }
}
@Composable
fun Mascot(modifier: Modifier = Modifier){
        Image(
            painter = painterResource(id = R.drawable.nhk_agent_vector),
            contentDescription = "NHK Characters",
            modifier = modifier.size(300.dp)
        )
}


@Preview(showBackground = true)
@Composable
fun RegisterPreview() {
    TestTheme {
            Box (
                modifier = Modifier
                    .fillMaxSize()
            ){
                OutlinedTitle()
                Mascot(
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        }
}
