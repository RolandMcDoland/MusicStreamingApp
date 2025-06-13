package com.rolandmcdoland.musicstreamingapp.player.di

import android.content.Context
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ServiceScoped
import javax.inject.Singleton

@Module
@InstallIn(ServiceComponent::class)
object PlayerModule {
    @ServiceScoped
    @Provides
    fun providePlayer(@ApplicationContext context: Context): Player =
        ExoPlayer.Builder(context).build()

    @ServiceScoped
    @Provides
    fun provideMediaSession(
        @ApplicationContext context: Context,
        player: Player
    ): MediaSession =
        MediaSession.Builder(context, player).build()
}