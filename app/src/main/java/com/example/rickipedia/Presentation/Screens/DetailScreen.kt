package com.example.rickipedia.Presentation.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.rickipedia.Presentation.ViewModels.CharacterDetailViewModel

@Composable
fun DetailScreen(
    viewModel: CharacterDetailViewModel,
    characterId: String,
) {
    val characterDetails by viewModel.character.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchCharacterById(characterId)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF222222)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            characterDetails?.let { details ->
                Text(
                    text = details.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = details.status,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            characterDetails?.let { details ->
                Image(
                    painter = rememberImagePainter(data = details.image),
                    contentDescription = "Character Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .padding(vertical = 16.dp)
                )
            }
            // Text for Origin
            Text(
                text = "Origin",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Display origin details
            characterDetails?.let { details ->
                Text(
                    text = details.origin.name,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Location",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(top = 16.dp)
            )

            // Display location details
            characterDetails?.let { details ->
                Text(
                    text = details.location.name,
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}