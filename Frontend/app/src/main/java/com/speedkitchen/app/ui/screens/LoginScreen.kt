
package com.speedkitchen.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.speedkitchen.app.R

private val LoginOrange = Color(0xFFF36F38)
private val LoginCoral = Color(0xFFD94D42)
private val LoginCream = Color(0xFFFFF8EF)
private val LoginCarbon = Color(0xFF202321)
private val LoginGray = Color(0xFF77716A)
private val LoginGreen = Color(0xFF72A67A)

@Composable
fun LoginScreen(
    onLoginClick: (String, String) -> Unit,
    onRegisterClick: () -> Unit,
    onForgotPasswordClick: () -> Unit,
    onGuestClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LoginCream)
            .imePadding()
            .verticalScroll(rememberScrollState())
    ) {

        // CABECERA CON FOTOGRAFÍA

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.home_chef),
                contentDescription = "Chef cocinando",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0x77000000),
                                Color(0x22000000),
                                Color(0xCC000000)
                            )
                        )
                    )
            )

            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(22.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.cocina),
                    contentDescription = "Logo",
                    modifier = Modifier.size(44.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "SPEED KITCHEN",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Black
                    )

                    Text(
                        text = "MIX WITH YOUR FRIENDS",
                        color = Color.White,
                        fontSize = 9.sp,
                        letterSpacing = 1.sp
                    )
                }
            }

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(24.dp)
            ) {
                Text(
                    text = "¡QUÉ BUENO VERTE!",
                    color = Color.White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = "Vuelve a los fogones.",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }
        }

        // FORMULARIO

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 26.dp)
        ) {

            Text(
                text = "Iniciar sesión",
                color = LoginCarbon,
                fontSize = 27.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Accede a tu cuenta y sigue compitiendo.",
                color = LoginGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(26.dp))

            // CORREO

            Text(
                text = "CORREO ELECTRÓNICO",
                color = LoginCarbon,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = {
                    Text("ejemplo@correo.com")
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = LoginCarbon,
                    unfocusedTextColor = LoginCarbon,
                    focusedBorderColor = LoginOrange,
                    unfocusedBorderColor = Color(0xFFE2DAD0),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedPlaceholderColor = LoginGray,
                    unfocusedPlaceholderColor = LoginGray,
                    cursorColor = LoginOrange
                )
            )

            Spacer(modifier = Modifier.height(18.dp))

            // CONTRASEÑA

            Text(
                text = "CONTRASEÑA",
                color = LoginCarbon,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = {
                    Text("Introduce tu contraseña")
                },
                singleLine = true,
                visualTransformation = if (showPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    TextButton(
                        onClick = {
                            showPassword = !showPassword
                        }
                    ) {
                        Text(
                            text = if (showPassword) "Ocultar" else "Ver",
                            color = LoginOrange,
                            fontWeight = FontWeight.Bold
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = LoginCarbon,
                    unfocusedTextColor = LoginCarbon,
                    focusedBorderColor = LoginOrange,
                    unfocusedBorderColor = Color(0xFFE2DAD0),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedPlaceholderColor = LoginGray,
                    unfocusedPlaceholderColor = LoginGray,
                    cursorColor = LoginOrange
                )
            )

            // RECUPERAR CONTRASEÑA

            Text(
                text = "¿Has olvidado tu contraseña?",
                color = LoginOrange,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        onForgotPasswordClick()
                    }
                    .padding(vertical = 14.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // BOTÓN INICIAR SESIÓN

            Button(
                onClick = {
                    onLoginClick(email.trim(), password)
                },
                enabled = email.isNotBlank() && password.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = LoginOrange,
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFFE9C2AF),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "INICIAR SESIÓN  →",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            // INVITADO

            OutlinedButton(
                onClick = onGuestClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = LoginCarbon
                )
            ) {
                Text(
                    text = "ENTRAR COMO INVITADO",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            // REGISTRO

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿Todavía no tienes cuenta? ",
                    color = LoginGray,
                    fontSize = 13.sp
                )

                Text(
                    text = "Regístrate",
                    color = LoginOrange,
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    modifier = Modifier.clickable {
                        onRegisterClick()
                    }
                )
            }

            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}
