package com.example.kot1041_app.lap.lap6

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kot1041_app.R

data class Movielap2(
    val title: String,
    val duration: String,
    val releaseDate: String,
    val description: String,
    val imageResId: Int
)

enum class ViewType { ROW, COLUMN, GRID }

@Composable
fun Lap6b2() {
    val movies = listOf(
        Movielap2("Inception", "2h 28m", "2010", "A thief who steals corporate secrets...", R.drawable.raiden),
        Movielap2("Interstellar", "2h 49m", "2014", "A team of explorers travel through a wormhole...", R.drawable.raiden2),
        Movielap2("The Dark Knight", "2h 32m", "2008", "Batman raises the stakes in his war on crime...", R.drawable.raiden3),
        Movielap2("Avatar", "2h 42m", "2009", "A marine on an alien planet...", R.drawable.raiden4)
    )

    var viewType by remember { mutableStateOf(ViewType.ROW) }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { viewType = ViewType.ROW }) { Text("Row") }
            Button(onClick = { viewType = ViewType.COLUMN }) { Text("Column") }
            Button(onClick = { viewType = ViewType.GRID }) { Text("Grid") }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (viewType) {
            ViewType.ROW -> LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(movies.size) { index ->
                    MovieItem(movie = movies[index])
                }
            }

            ViewType.COLUMN -> LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(movies.size) { index ->
                    MovieColumnItem(movie = movies[index])
                }
            }

            ViewType.GRID -> LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(movies.size) { index ->
                    MovieItem(movie = movies[index])
                }
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movielap2) {
    Card(
        modifier = Modifier
            .width(160.dp)
//            .height(240.dp),
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = movie.imageResId),
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )
            Text(
                text = movie.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "⏱ ${movie.duration}", modifier = Modifier.padding(horizontal = 8.dp))
            Text(text = "📅 ${movie.releaseDate}", modifier = Modifier.padding(horizontal = 8.dp))
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = movie.description,
                modifier = Modifier.padding(horizontal = 8.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

    }
}

@Composable
fun MovieColumnItem(movie: Movielap2) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = movie.imageResId),
                contentDescription = movie.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(140.dp),
                contentScale = androidx.compose.ui.layout.ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = movie.title, style = MaterialTheme.typography.titleMedium)
                Text(text = "⏱ ${movie.duration}")
                Text(text = "📅 ${movie.releaseDate}")
                Text(
                    text = movie.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
