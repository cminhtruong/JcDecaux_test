package app.el_even.jcdecaux.domain.interactor.get_stations

import app.el_even.jcdecaux.common.Resource
import app.el_even.jcdecaux.data.remote.dto.toStation
import app.el_even.jcdecaux.domain.model.Station
import app.el_even.jcdecaux.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

class GetStationsUC @Inject constructor(
	private val repository: AppRepository
) {
	operator fun invoke(): Flow<Resource<List<Station>>> = flow {
		try {
			Timber.d("check station")
			emit(Resource.Loading<List<Station>>())
			val stations = repository.getStations().map { it.toStation() }
			emit(Resource.Success<List<Station>>(stations))
		} catch (e: HttpException) {
			Timber.d("check station1")
			emit(
				Resource.Error<List<Station>>(
					e.localizedMessage ?: "An unexpected error happened"
				)
			)
		} catch (e: IOException) {
			Timber.d("check station2")
			emit(Resource.Error<List<Station>>("Couldn't reach server. Check your internet connection"))
		}
	}
}