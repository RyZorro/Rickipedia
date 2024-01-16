package com.example.rickipedia.Presentation.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.rickipedia.Application.DTOs.CharacterDto

@Composable
fun CharacterItem(
    character: CharacterDto
) {
    val painter = rememberImagePainter(
        data = character.image,
        builder = { crossfade(true) }
    )
    Column(
        modifier = Modifier
            .width(200.dp)
            .padding(vertical = 8.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color.Black.copy(alpha = 0.8f))
    ) {
        Image(
            painter = painter,
            contentDescription = "Character Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = character.name,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 12.dp),
            color = Color.White
        )
    }
}