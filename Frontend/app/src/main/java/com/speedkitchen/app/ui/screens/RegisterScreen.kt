
package com.speedkitchen.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

private val RegisterOrange = Color(0xFFF36F38)
private val RegisterCoral = Color(0xFFD94D42)
private val RegisterCream = Color(0xFFFFF8EF)
private val RegisterCarbon = Color(0xFF202321)
private val RegisterGray = Color(0xFF77716A)

@Composable
fun RegisterScreen(
    onRegisterClick: (String, String, String) -> Unit,
    onLoginClick: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var showPassword by remember { mutableStateOf(false) }
    var showConfirmPassword by remember { mutableStateOf(false) }

    val passwordsMatch = password == confirmPassword

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(RegisterCream)
            .imePadding()
            .verticalScroll(rememberScrollState())
    ) {

        // CABECERA CON FOTOGRAFÍA

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(205.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.fresh_ingredients),
                contentDescription = "Ingredientes frescos",
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
                    contentDescription = "Logo Speed Kitchen",
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
                    text = "¡ÚNETE A LA COCINA!",
                    color = Color.White,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Black
                )

                Text(
                    text = "Tu próxima competición empieza aquí.",
                    color = Color.White,
                    fontSize = 13.sp
                )
            }
        }

        // FORMULARIO

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {

            Text(
                text = "Crear cuenta",
                color = RegisterCarbon,
                fontSize = 27.sp,
                fontWeight = FontWeight.Black
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Prepara tu perfil y empieza a competir.",
                color = RegisterGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(23.dp))

            // NOMBRE DE USUARIO

            Text(
                text = "NOMBRE DE USUARIO",
                color = RegisterCarbon,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(7.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Tu nombre de usuario") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = registerFieldColors()
            )

            Spacer(modifier = Modifier.height(15.dp))

            // CORREO ELECTRÓNICO

            Text(
                text = "CORREO ELECTRÓNICO",
                color = RegisterCarbon,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(7.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("ejemplo@correo.com") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = registerFieldColors()
            )

            Spacer(modifier = Modifier.height(15.dp))

            // CONTRASEÑA

            Text(
                text = "CONTRASEÑA",
                color = RegisterCarbon,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(7.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Crea una contraseña") },
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
                            color = RegisterOrange
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = registerFieldColors()
            )

            Spacer(modifier = Modifier.height(15.dp))

            // REPETIR CONTRASEÑA

            Text(
                text = "CONFIRMAR CONTRASEÑA",
                color = RegisterCarbon,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(7.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = { Text("Repite tu contraseña") },
                singleLine = true,
                visualTransformation = if (showConfirmPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    TextButton(
                        onClick = {
                            showConfirmPassword = !showConfirmPassword
                        }
                    ) {
                        Text(
                            text = if (showConfirmPassword) "Ocultar" else "Ver",
                            color = RegisterOrange
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp),
                colors = registerFieldColors()
            )

            // AVISO DE CONTRASEÑAS

            if (confirmPassword.isNotEmpty() && !passwordsMatch) {
                Text(
                    text = "Las contraseñas no coinciden",
                    color = RegisterCoral,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(top = 7.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // BOTÓN CREAR CUENTA

            Button(
                onClick = {
                    onRegisterClick(
                        username.trim(),
                        email.trim(),
                        password
                    )
                },
                enabled = username.isNotBlank() &&
                        email.isNotBlank() &&
                        password.isNotBlank() &&
                        confirmPassword.isNotBlank() &&
                        passwordsMatch,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = RegisterOrange,
                    contentColor = Color.White,
                    disabledContainerColor = Color(0xFFE9C2AF),
                    disabledContentColor = Color.White
                )
            ) {
                Text(
                    text = "CREAR CUENTA  →",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Black
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // VOLVER AL LOGIN

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "¿Ya tienes cuenta? ",
                    color = RegisterGray,
                    fontSize = 13.sp
                )

                TextButton(onClick = onLoginClick) {
                    Text(
                        text = "Inicia sesión",
                        color = RegisterOrange,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
private fun registerFieldColors() =
    OutlinedTextFieldDefaults.colors(
        focusedTextColor = RegisterCarbon,
        unfocusedTextColor = RegisterCarbon,
        focusedBorderColor = RegisterOrange,
        unfocusedBorderColor = Color(0xFFE2DAD0),
        focusedContainerColor = Color.White,
        unfocusedContainerColor = Color.White,
        focusedPlaceholderColor = RegisterGray,
        unfocusedPlaceholderColor = RegisterGray,
        cursorColor = RegisterOrange
    )
