package com.liilab.dependancyinjectionapplication.di

import com.liilab.dependancyinjectionapplication.data.datasource.local.dao.NoteDao
import com.liilab.dependancyinjectionapplication.data.datasource.remote.api.PixabayApi
import com.liilab.dependancyinjectionapplication.data.repository.NoteRepositoryImpl
import com.liilab.dependancyinjectionapplication.data.repository.PixabayRepositoryImpl
import com.liilab.dependancyinjectionapplication.domain.repository.NoteRepository
import com.liilab.dependancyinjectionapplication.domain.repository.PixabayRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePixabayRepository(pixabayApi: PixabayApi): PixabayRepository {
        return PixabayRepositoryImpl(pixabayApi)
    }

    @Singleton
    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
    }
}