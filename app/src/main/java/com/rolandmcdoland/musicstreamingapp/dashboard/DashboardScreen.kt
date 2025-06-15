package com.rolandmcdoland.musicstreamingapp.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.rolandmcdoland.musicstreamingapp.R
import com.rolandmcdoland.musicstreamingapp.ui.theme.MusicStreamingAppTheme

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {
    DashboardScreenStateless(
        rows = mapOf(),
        modifier = modifier
    )
}

@Composable
fun DashboardScreenStateless(
    rows: Map<String, List<Album>>,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { additionalPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(additionalPadding)) {
            items(rows.keys.toList()) { rowName ->
                rows[rowName]?.let {
                    AlbumsRow(
                        name = rowName,
                        albums = it
                    )
                }
            }
        }
    }
}

@Composable
fun AlbumsRow(
    name: String,
    albums: List<Album>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = name
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(albums) { album ->
                AlbumItem(
                    album = album
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AlbumItem(
    album: Album,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Surface(shape = RoundedCornerShape(20.dp)) {
            GlideImage(
                model = album.artworkUrl,
                contentDescription = stringResource(R.string.album_cover),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(128.dp)
            )
        }
        Text(
            text = album.title,
            fontSize = TextUnit(11.0f, TextUnitType.Sp)
        )
        Text(
            text = album.artist,
            fontSize = TextUnit(11.0f, TextUnitType.Sp)
        )
    }
}

@Preview
@Composable
fun DashboardScreenPreview() {
    MusicStreamingAppTheme {
        DashboardScreenStateless(
            rows = mapOf(
                "Row 1" to
                        listOf(
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            ),
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            ),
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            )
                        ),
                "Row 2" to
                        listOf(
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            ),
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            ),
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            )
                        ),
                "Row 3" to
                        listOf(
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            ),
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            ),
                            Album(
                                "Example title",
                                "Example artist",
                                "https://example.com"
                            )
                        )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumsRowPreview() {
    MusicStreamingAppTheme {
        AlbumsRow(
            name = "Example row name",
            albums = listOf(
                Album(
                    "Example title",
                    "Example artist",
                    "https://example.com"
                ),
                Album(
                    "Example title",
                    "Example artist",
                    "https://example.com"
                ),
                Album(
                    "Example title",
                    "Example artist",
                    "https://example.com"
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AlbumItemPreview() {
    MusicStreamingAppTheme {
        AlbumItem(
            Album(
                "Example title",
                "Example artist",
                "https://example.com"
            )
        )
    }
}

data class Album(
    val title: String,
    val artist: String,
    val artworkUrl: String
)