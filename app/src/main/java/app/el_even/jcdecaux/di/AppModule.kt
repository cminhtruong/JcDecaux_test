package app.el_even.jcdecaux.di

import app.el_even.jcdecaux.common.Constant.BASE_URL
import app.el_even.jcdecaux.data.remote.api.AppApi
import app.el_even.jcdecaux.data.repository.AppRepositoryImpl
import app.el_even.jcdecaux.domain.repository.AppRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun provideAppApi(): AppApi = Retrofit.Builder()
		.baseUrl(BASE_URL)
		.addConverterFactory(
			MoshiConverterFactory.create(
				Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
			)
		)
		.addCallAdapterFactory(CoroutineCallAdapterFactory())
		.build()
		.create(AppApi::class.java)

	@Provides
	@Singleton
	fun provideAppRepository(api: AppApi): AppRepository = AppRepositoryImpl(appApi = api)
}