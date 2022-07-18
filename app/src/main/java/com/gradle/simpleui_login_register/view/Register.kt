package com.gradle.simpleui_login_register.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.gradle.simpleui_login_register.R
import com.gradle.simpleui_login_register.ui.theme.Purple500

@Composable
fun Register(navController: NavController) {
    val context = LocalContext.current
    val scaffoldState = rememberScaffoldState()
    val nameVal = remember { mutableStateOf("") }
    val emailVal = remember { mutableStateOf("") }
    val phoneVal = remember { mutableStateOf("") }
    val passwordVal = remember { mutableStateOf("") }
    val confirmPasswordVal = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
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
                    painter = painterResource(R.drawable.register_img),
                    contentDescription = "Register Image",
                    modifier = Modifier
                        .height(300.dp)
                        .width(400.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.padding(5.dp))

            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(30.dp))
                        .background(Color.White)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedTextField(
                            value = nameVal.value,
                            onValueChange = { nameVal.value = it },
                            label = { Text(text = "Name", color = Color.Black) },
                            placeholder = { Text(text = "Name", color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = emailVal.value,
                            onValueChange = { emailVal.value = it },
                            label = { Text(text = "Email Address", color = Color.Black) },
                            placeholder = { Text(text = "Email Address", color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = phoneVal.value,
                            onValueChange = { phoneVal.value = it },
                            label = { Text(text = "Phone Number", color = Color.Black) },
                            placeholder = { Text(text = "Phone Number", color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            )
                        )

                        OutlinedTextField(
                            value = passwordVal.value,
                            onValueChange = { passwordVal.value = it },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password", color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        passwordVisibility.value = !passwordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password Eye",
                                        tint = if (passwordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        OutlinedTextField(
                            value = confirmPasswordVal.value,
                            onValueChange = { confirmPasswordVal.value = it },
                            label = { Text(text = "Password", color = Color.Black) },
                            placeholder = { Text(text = "Password", color = Color.Black) },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(
                                unfocusedBorderColor = Color.Black, textColor = Color.Black
                            ),
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        confirmPasswordVisibility.value =
                                            !confirmPasswordVisibility.value
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                        contentDescription = "Password Eye",
                                        tint = if (confirmPasswordVisibility.value) Purple500 else Color.Gray
                                    )
                                }
                            },
                            visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                            else PasswordVisualTransformation()
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            onClick = {
                                when {
                                    nameVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter the name!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    emailVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter the email address!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    phoneVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter the phone number!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    passwordVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter password!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    confirmPasswordVal.value.isEmpty() -> {
                                        Toast.makeText(
                                            context,
                                            "Please enter confirm password!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    else -> {
                                        Toast.makeText(
                                            context,
                                            "Successfully Registered!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }

                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Sign Up", fontSize = 20.sp, color = Color.Black)
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(text = "Login Instead" , color = Color.Black,
                            modifier = Modifier.clickable {
                                navController.navigate("login_page")
                            }
                        )

                        Spacer(modifier = Modifier.padding(5.dp))


                    }
                }
            }
        }
    }
}