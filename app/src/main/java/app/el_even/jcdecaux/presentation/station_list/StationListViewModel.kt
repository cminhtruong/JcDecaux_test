package app.el_even.jcdecaux.presentation.station_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.el_even.jcdecaux.common.Resource
import app.el_even.jcdecaux.domain.interactor.get_stations.GetStationsUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StationListViewModel @Inject constructor(
	private val getStationsUC: GetStationsUC
) : ViewModel() {

	private val _state = mutableStateOf(StationListState())
	val state: State<StationListState> = _state

	init {
		getStations()
	}

	private fun getStations() {
		Timber.d("check stations here")
		getStationsUC().onEach { result ->
			when (result) {
				is Resource.Error -> _state.value =
					StationListState(error = result.message ?: "An unexpected error as result")
				is Resource.Loading -> _state.value = StationListState(isLoading = true)
				is Resource.Success -> _state.value =
					StationListState(stations = result.data ?: emptyList())
			}
		}.launchIn(viewModelScope)
	}
}