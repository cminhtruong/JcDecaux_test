package app.el_even.jcdecaux.domain.interactor.get_station

import app.el_even.jcdecaux.common.Resource
import app.el_even.jcdecaux.data.remote.dto.toStation
import app.el_even.jcdecaux.domain.model.Station
import app.el_even.jcdecaux.domain.repository.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetStationUC @Inject constructor(
	private val repository: AppRepository
) {
	operator fun invoke(number: Int, contract: String): Flow<Resource<Station>> = flow {
		try {
			emit(Resource.Loading<Station>())
			val station = repository.getStation(number = number, contract = contract).toStation()
			emit(Resource.Success<Station>(station))
		} catch (e: HttpException) {
			emit(Resource.Error<Station>(e.localizedMessage ?: "An unexpected error happened"))
		} catch (e: IOException) {
			emit(Resource.Error<Station>("Couldn't reach server. Check your internet connection"))
		}
	}
}