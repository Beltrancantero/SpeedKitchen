
package com.speedkitchen.app.ui.screens

import android.graphics.BitmapFactory
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private val ProfileCream = Color(0xFFFFF8EF)
private val ProfileOrange = Color(0xFFF36F38)
private val ProfileCoral = Color(0xFFD94D42)
private val ProfileCarbon = Color(0xFF292824)
private val ProfileGray = Color(0xFF77716A)
private val ProfileGreen = Color(0xFF78866B)
private val ProfileBlue = Color(0xFF3679C9)
private val ProfileLight = Color(0xFFF0EBE4)

@Composable
fun ProfileScreen() {

    var displayName by remember { mutableStateOf("Mi perfil") }
    var username by remember { mutableStateOf("@chef_nuevo") }
    var biography by remember {
        mutableStateOf("Preparado para demostrar mi talento en la cocina.")
    }

    var showEditDialog by remember { mutableStateOf(false) }
    var selectedSection by remember { mutableStateOf("Resumen") }

    var profileImageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            profileImageUri = uri
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ProfileCream)
            .verticalScroll(rememberScrollState())
    ) {

        // CABECERA DEL PERFIL
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            ProfileOrange,
                            ProfileCoral,
                            Color(0xFF9D493A)
                        )
                    )
                )
                .padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 25.dp,
                    bottom = 35.dp
                )
        ) {
            Column {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = "SPEED KITCHEN",
                            color = Color.White.copy(alpha = 0.85f),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            letterSpacing = 2.sp
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = "Mi perfil",
                            color = Color.White,
                            fontSize = 27.sp,
                            fontWeight = FontWeight.Black
                        )
                    }

                    IconButton(
                        onClick = { showEditDialog = true }
                    ) {
                        Text(
                            text = "⚙",
                            fontSize = 25.sp,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(25.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // FOTO DE PERFIL
                    ProfileAvatar(
                        imageUri = profileImageUri,
                        onClick = {
                            imagePicker.launch("image/*")
                        }
                    )

                    Spacer(modifier = Modifier.width(17.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = displayName,
                            fontSize = 23.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = username,
                            fontSize = 14.sp,
                            color = Color.White.copy(alpha = 0.85f)
                        )

                        Spacer(modifier = Modifier.height(9.dp))

                        Surface(
                            shape = RoundedCornerShape(30.dp),
                            color = Color.White.copy(alpha = 0.20f)
                        ) {
                            Text(
                                text = "🍳 Chef principiante",
                                modifier = Modifier.padding(
                                    horizontal = 11.dp,
                                    vertical = 6.dp
                                ),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = biography,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )

                Spacer(modifier = Modifier.height(13.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        imagePicker.launch("image/*")
                    }
                ) {
                    Text(
                        "📷 Cambiar foto de perfil",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // NIVEL Y EXPERIENCIA
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 3.dp
                )
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(54.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(
                                    Brush.linearGradient(
                                        listOf(
                                            ProfileOrange,
                                            ProfileCoral
                                        )
                                    )
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                "1",
                                fontSize = 27.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.White
                            )
                        }

                        Spacer(modifier = Modifier.width(13.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                "Nivel 1",
                                fontSize = 19.sp,
                                fontWeight = FontWeight.Black,
                                color = ProfileCarbon
                            )

                            Text(
                                "Aprendiz de cocina",
                                fontSize = 12.sp,
                                color = ProfileGray
                            )
                        }

                        Text(
                            "⭐",
                            fontSize = 26.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(19.dp))

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "Progreso de experiencia",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = ProfileCarbon
                        )

                        Text(
                            "0 / 500 XP",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = ProfileOrange
                        )
                    }

                    Spacer(modifier = Modifier.height(9.dp))

                    LinearProgressIndicator(
                        progress = { 0f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(9.dp)
                            .clip(CircleShape),
                        color = ProfileOrange,
                        trackColor = ProfileLight
                    )

                    Spacer(modifier = Modifier.height(9.dp))

                    Text(
                        "Completa desafíos para conseguir experiencia y subir de nivel.",
                        fontSize = 11.sp,
                        color = ProfileGray,
                        lineHeight = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ESTADÍSTICAS
            SectionTitle(
                title = "Estadísticas",
                subtitle = "Tu trayectoria como cocinero"
            )

            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                StatisticCard(
                    modifier = Modifier.weight(1f),
                    icon = "⚔",
                    value = "0",
                    label = "Partidas",
                    accent = ProfileOrange
                )

                StatisticCard(
                    modifier = Modifier.weight(1f),
                    icon = "🏆",
                    value = "0",
                    label = "Victorias",
                    accent = ProfileGreen
                )

                StatisticCard(
                    modifier = Modifier.weight(1f),
                    icon = "⭐",
                    value = "0",
                    label = "Puntuación",
                    accent = ProfileBlue
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            // NAVEGACIÓN INTERNA
            SectionTitle(
                title = "Mi actividad",
                subtitle = "Consulta tus progresos y colecciones"
            )

            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                listOf("Resumen", "Logros", "Recetas").forEach { section ->
                    val selected = selectedSection == section

                    Surface(
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                selectedSection = section
                            },
                        shape = RoundedCornerShape(13.dp),
                        color = if (selected) {
                            ProfileOrange
                        } else {
                            Color.White
                        },
                        border = if (selected) {
                            null
                        } else {
                            BorderStroke(1.dp, ProfileLight)
                        }
                    ) {
                        Box(
                            modifier = Modifier.padding(
                                vertical = 12.dp,
                                horizontal = 4.dp
                            ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = section,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (selected) {
                                    Color.White
                                } else {
                                    ProfileGray
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            when (selectedSection) {

                "Resumen" -> {
                    ActivitySummary()
                }

                "Logros" -> {
                    AchievementsSection()
                }

                "Recetas" -> {
                    FavoriteRecipesSection()
                }
            }

            Spacer(modifier = Modifier.height(25.dp))

            // HISTORIAL
            SectionTitle(
                title = "Historial de partidas",
                subtitle = "Tus últimos enfrentamientos"
            )

            Spacer(modifier = Modifier.height(12.dp))

            EmptyStateCard(
                icon = "⚔",
                title = "Aún no hay enfrentamientos",
                description = "Cuando participes en partidas, podrás consultar aquí tus resultados."
            )

            Spacer(modifier = Modifier.height(25.dp))

            // AJUSTES
            SectionTitle(
                title = "Cuenta y configuración",
                subtitle = "Personaliza tu experiencia"
            )

            Spacer(modifier = Modifier.height(12.dp))

            ProfileMenuItem(
                icon = "✏️",
                title = "Editar perfil",
                description = "Modifica tu nombre y presentación",
                onClick = { showEditDialog = true }
            )

            Spacer(modifier = Modifier.height(9.dp))

            ProfileMenuItem(
                icon = "🔔",
                title = "Notificaciones",
                description = "Preferencias de avisos",
                onClick = {}
            )

            Spacer(modifier = Modifier.height(9.dp))

            ProfileMenuItem(
                icon = "🔒",
                title = "Privacidad y seguridad",
                description = "Opciones de tu cuenta",
                onClick = {}
            )

            Spacer(modifier = Modifier.height(9.dp))

            ProfileMenuItem(
                icon = "ℹ️",
                title = "Acerca de Speed Kitchen",
                description = "Información de la aplicación",
                onClick = {}
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "SPEED KITCHEN · MIX WITH YOUR FRIENDS",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 10.sp,
                color = ProfileGray,
                letterSpacing = 1.sp,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )

            Spacer(modifier = Modifier.height(25.dp))
        }
    }

    // DIÁLOGO DE EDICIÓN
    if (showEditDialog) {
        EditProfileDialog(
            currentName = displayName,
            currentUsername = username,
            currentBiography = biography,
            onDismiss = {
                showEditDialog = false
            },
            onSave = { name, user, bio ->
                displayName = name
                username = if (user.startsWith("@")) user else "@$user"
                biography = bio
                showEditDialog = false
            }
        )
    }
}

@Composable
private fun ProfileAvatar(
    imageUri: Uri?,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    val bitmap by produceState<android.graphics.Bitmap?>(
        initialValue = null,
        key1 = imageUri
    ) {
        value = if (imageUri == null) {
            null
        } else {
            withContext(Dispatchers.IO) {
                try {
                    context.contentResolver.openInputStream(imageUri)?.use {
                        BitmapFactory.decodeStream(it)
                    }
                } catch (e: Exception) {
                    null
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .size(91.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.25f))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (bitmap != null) {
            Image(
                bitmap = bitmap!!.asImageBitmap(),
                contentDescription = "Foto de perfil",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        } else {
            Text(
                text = "👨‍🍳",
                fontSize = 43.sp
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(27.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "📷",
                fontSize = 13.sp
            )
        }
    }
}

@Composable
private fun SectionTitle(
    title: String,
    subtitle: String
) {
    Column {
        Text(
            title,
            fontSize = 19.sp,
            fontWeight = FontWeight.Black,
            color = ProfileCarbon
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            subtitle,
            fontSize = 12.sp,
            color = ProfileGray
        )
    }
}

@Composable
private fun StatisticCard(
    modifier: Modifier = Modifier,
    icon: String,
    value: String,
    label: String,
    accent: Color
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 15.dp, horizontal = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(icon, fontSize = 20.sp)

            Spacer(modifier = Modifier.height(7.dp))

            Text(
                value,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
                color = accent
            )

            Text(
                label,
                fontSize = 10.sp,
                color = ProfileGray
            )
        }
    }
}

@Composable
private fun ActivitySummary() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ActivityInfoCard(
            icon = "🔥",
            title = "Racha de victorias",
            description = "Tu mejor racha aparecerá aquí.",
            value = "0"
        )

        ActivityInfoCard(
            icon = "🍽️",
            title = "Recetas completadas",
            description = "Descubre cuántas recetas has preparado.",
            value = "0"
        )

        ActivityInfoCard(
            icon = "🎯",
            title = "Precisión media",
            description = "Tu rendimiento en los desafíos.",
            value = "—"
        )
    }
}

@Composable
private fun AchievementsSection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        AchievementCard(
            icon = "🍳",
            title = "Primeros pasos",
            description = "Completa tu primera receta.",
            unlocked = false
        )

        AchievementCard(
            icon = "⚔",
            title = "Primer duelo",
            description = "Participa en tu primera partida.",
            unlocked = false
        )

        AchievementCard(
            icon = "🏆",
            title = "Primer campeón",
            description = "Consigue tu primera victoria.",
            unlocked = false
        )
    }
}

@Composable
private fun FavoriteRecipesSection() {
    EmptyStateCard(
        icon = "🍝",
        title = "Tu colección está vacía",
        description = "Cuando marques recetas como favoritas, podrás encontrarlas aquí."
    )
}

@Composable
private fun ActivityInfoCard(
    icon: String,
    title: String,
    description: String,
    value: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 25.sp)

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = ProfileCarbon
                )

                Text(
                    description,
                    fontSize = 11.sp,
                    color = ProfileGray
                )
            }

            Text(
                value,
                fontSize = 17.sp,
                fontWeight = FontWeight.Black,
                color = ProfileOrange
            )
        }
    }
}

@Composable
private fun AchievementCard(
    icon: String,
    title: String,
    description: String,
    unlocked: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(17.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(47.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(
                        if (unlocked) {
                            Color(0xFFFFE6D9)
                        } else {
                            ProfileLight
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 23.sp)
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = ProfileCarbon
                )

                Text(
                    description,
                    fontSize = 11.sp,
                    color = ProfileGray
                )
            }

            Text(
                if (unlocked) "✓" else "🔒",
                fontSize = 17.sp
            )
        }
    }
}

@Composable
private fun EmptyStateCard(
    icon: String,
    title: String,
    description: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(19.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(icon, fontSize = 35.sp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = ProfileCarbon
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                description,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = ProfileGray,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
private fun ProfileMenuItem(
    icon: String,
    title: String,
    description: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(icon, fontSize = 22.sp)

            Spacer(modifier = Modifier.width(13.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    title,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = ProfileCarbon
                )

                Text(
                    description,
                    fontSize = 11.sp,
                    color = ProfileGray
                )
            }

            Text(
                "›",
                fontSize = 25.sp,
                color = ProfileGray
            )
        }
    }
}

@Composable
private fun EditProfileDialog(
    currentName: String,
    currentUsername: String,
    currentBiography: String,
    onDismiss: () -> Unit,
    onSave: (String, String, String) -> Unit
) {
    var name by remember(currentName) {
        mutableStateOf(currentName)
    }

    var username by remember(currentUsername) {
        mutableStateOf(currentUsername.removePrefix("@"))
    }

    var biography by remember(currentBiography) {
        mutableStateOf(currentBiography)
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                "Editar perfil",
                fontWeight = FontWeight.Black
            )
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nombre") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Nombre de usuario") },
                    prefix = { Text("@") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = biography,
                    onValueChange = { biography = it },
                    label = { Text("Presentación") },
                    modifier = Modifier.fillMaxWidth(),
                    minLines = 2,
                    maxLines = 3
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (name.isNotBlank() && username.isNotBlank()) {
                        onSave(
                            name.trim(),
                            username.trim(),
                            biography.trim()
                        )
                    }
                },
                enabled = name.isNotBlank() && username.isNotBlank()
            ) {
                Text(
                    "Guardar",
                    color = ProfileOrange
                )
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar", color = ProfileGray)
            }
        },
        containerColor = ProfileCream
    )
}
