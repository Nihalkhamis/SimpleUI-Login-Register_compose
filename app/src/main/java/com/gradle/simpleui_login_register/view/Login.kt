package com.gradle.simpleui_login_register.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gradle.simpleui_login_register.R
import com.gradle.simpleui_login_register.ui.theme.Purple500

@Composable
fun LoginPage(navController: NavController) {

    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val emailVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White), contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.background(Color.White),
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                    painter = painterResource(R.drawable.login),
                    contentDescription = "Login Image",
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.padding(20.dp))

            // one of the layouts of material design of jetpack compose that holds column and many other components
            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.padding(20.dp))

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        // email
                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = {
                                emailVal.value = it
                            },
                            label = {
                                Text(text = "Email Address", color = Color.Black)
                            },
                            placeholder = {
                                Text(text = "Email Address", color = Color.Black)
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black,
                                textColor = Color.Black
                            )
                        )

                        // password
                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = {
                                passwordVal.value = it
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility.value = !passwordVisibility.value
                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password",
                                        tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password", color = Color.Black) },
                            singleLine = true,
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(), //whether to show password with dots or not
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )

                        Spacer(modifier = Modifier.padding(20.dp))


                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            onClick = {
                                when{
                                    emailVal.value.isEmpty() ->{
                                        Toast.makeText(context, "You must enter your email", Toast.LENGTH_SHORT).show()
                                    }
                                    passwordVal.value.isEmpty() ->{
                                        Toast.makeText(context, "You must enter your password", Toast.LENGTH_SHORT).show()
                                    }
                                    else ->{
                                        Toast.makeText(context, "Logged in successfully", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Sign In", fontSize = 20.sp, color = Color.Black)
                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                        Text(
                            text = "Create an account?",
                            color = Color.Black,
                            modifier = Modifier.clickable { navController.navigate("register_page") }
                        )

                        Spacer(modifier = Modifier.padding(20.dp))

                    }
                }
            }

        }

    }

}